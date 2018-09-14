package com.landbay.rules;

import com.landbay.dao.InvestmentRequestCsvDaoImpl;
import com.landbay.dao.LoanCsvDaoImpl;
import com.landbay.model.InvestmentRequest;
import com.landbay.model.Loan;

import java.util.ArrayList;
import java.util.Comparator;
import java.util.List;
import java.util.logging.Logger;
import java.util.stream.Collectors;

public class MatchRequestRulesImpl implements MatchRequestRules {

    private final static Logger LOGGER = Logger.getLogger(MatchRequestRulesImpl.class.getName());

    private LoanCsvDaoImpl loanCsvDaoImp;
    private InvestmentRequestCsvDaoImpl investmentRequestCsvDao;
    private List<InvestmentRequest> trackerInvestmentRequests;
    private List<InvestmentRequest> fixedInvestmentRequests;

    public MatchRequestRulesImpl() {
        investmentRequestCsvDao = new InvestmentRequestCsvDaoImpl();
        loanCsvDaoImp = new LoanCsvDaoImpl();
        trackerInvestmentRequests = new ArrayList<>();
        fixedInvestmentRequests = new ArrayList<>();
    }

    // public getter methods

    public List<InvestmentRequest> getTrackerInvestmentRequestsList()
    {
        return this.trackerInvestmentRequests;
    }

    public List<InvestmentRequest> getFixedInvestmentRequestsList()
    {
        return this.fixedInvestmentRequests;
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
     * Sorts Fixed and Tracker investment requests from the InvestmentRequestDao
     * @param unsortedList
     */
    @Override
    public void sortProductTypesIntoLists(List<InvestmentRequest> unsortedList)
    {
       for (InvestmentRequest inv : unsortedList)
           switch (inv.getProductType())
           {
               case "TRACKER":
                   trackerInvestmentRequests.add(inv);
                   break;
               case "FIXED":
                   fixedInvestmentRequests.add(inv);
                   break;
               default:
                   LOGGER.info("The product type specified is invalid for " + inv.getInvestor());
                   break;
           }
    }


    /**
     * Returns list of investment requests that exceed the loan term
     * @param loan
     * @param investmentRequests
     * @return
     */
    @Override
    public List<InvestmentRequest> investmentRequestTermFilter(Loan loan, List<InvestmentRequest> investmentRequests)
    {
        List<InvestmentRequest> sortedList = new ArrayList<>();

        for (InvestmentRequest inv : investmentRequests)
            if (inv.getTerm() > loan.getTerm())
                sortedList.add(inv);

        return sortedList;
    }
}
