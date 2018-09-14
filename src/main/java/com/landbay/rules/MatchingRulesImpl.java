package com.landbay.rules;

import com.landbay.model.Investor;
import com.landbay.model.Loan;

import java.util.ArrayList;
import java.util.Comparator;
import java.util.List;
import java.util.logging.Logger;
import java.util.stream.Collectors;

public class MatchingRulesImpl implements MatchingRules {

    private final static Logger LOGGER = Logger.getLogger(MatchingRulesImpl.class.getName());

    private List<Investor> trackerInvestors;
    private List<Investor> fixedInvestors;

    public MatchingRulesImpl() {
        trackerInvestors = new ArrayList<>();
        fixedInvestors = new ArrayList<>();
    }

    // public getter methods

    public List<Investor> getTrackerInvestors()
    {
        return this.trackerInvestors;
    }

    public List<Investor> getFixedInvestors()
    {
        return this.fixedInvestors;
    }


    // interface methods implemented

    /**
     * Returns a sorted list of loans in date order - oldest first
     * @param unsortedList
     * @return
     */
    @Override
    public List<Loan> sortLoansByOldestFirst(List<Loan> unsortedList)
    {
        return unsortedList.stream()
                .sorted(Comparator.comparing(Loan::getCompletedDate))
                .collect(Collectors.toList());
    }

    /**
     * Sorts Fixed and Tracker investment requests from the InvestorDao
     * @param unsortedList
     */
    @Override
    public void sortProductTypesIntoLists(List<Investor> unsortedList)
    {
       for (Investor inv : unsortedList)
           switch (inv.getProductType())
           {
               case "TRACKER":
                   trackerInvestors.add(inv);
                   break;
               case "FIXED":
                   fixedInvestors.add(inv);
                   break;
               default:
                   LOGGER.info("The product type specified is invalid for " + inv.getInvestor());
                   break;
           }
    }

    /**
     * Returns list of investment requests that exceed the loan term
     * @param loan
     * @param investors
     * @return
     */
    @Override
    public List<Investor> investorTermFilter(Loan loan, List<Investor> investors)
    {
        List<Investor> sortedList = new ArrayList<>();

        for (Investor inv : investors)
            if (inv.getTerm() > loan.getTerm())
                sortedList.add(inv);

        return sortedList;
    }
}
