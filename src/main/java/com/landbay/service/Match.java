package com.landbay.service;

import com.landbay.model.FundedLoan;
import com.landbay.model.Investor;
import com.landbay.model.Loan;
import com.landbay.rules.MatchingRulesImpl;
import com.sun.jersey.spi.inject.Inject;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * This is the main class in the application
 * where the logic is applied
 */
public class Match {

    @Inject
    private MatchingRulesImpl matchingRules;

    private List<Loan> loanData;
    private List<Investor> investorData;
    private List<FundedLoan> fundedLoans;
    private FundedLoan fundedLoan;

    private HashMap<Investor, Integer > updateInvestors = new HashMap<>();


    public Match(MatchingRulesImpl matchingRules, List<Loan> loanData, List<Investor> investorData) {
        this.matchingRules = matchingRules;
        this.loanData = loanData;
        this.investorData = investorData;
    }

    private List<Loan> sortLoansByOldestFirst(List<Loan> unsortedList)
    {
        return matchingRules.sortLoansByOldestFirst(unsortedList);
    }

    private void sortProductTypesIntoLists(List<Investor> unsortedList)
    {
        matchingRules.sortProductTypesIntoLists(unsortedList);
    }

    private List<Investor> investorTermFilter(Loan loan, List<Investor> investors)
    {
        return matchingRules.investorTermFilter(loan, investors);
    }

    /**
     * This method starts the matching process
     */
    public void startMatch()
    {
        List<Loan> sortedLoans = sortLoansByOldestFirst(this.loanData);
        sortProductTypesIntoLists(this.investorData);

        for (Loan ln : sortedLoans)
        {
            switch (ln.getProduct())
            {
                case "TRACKER":
                    processLoan("TRACKER", ln);
                    break;
                case "FIXED":
                    processLoan("FIXED", ln);
                    break;
                default:
                    break;
            }

            /* if the loan is funded update FundedLoans list and the investor details */
            if (fundedLoan.getFundedStatus() && fundedLoan.getAmountUnfunded() == 0 )
            {
                fundedLoans.add(fundedLoan);
                for (Map.Entry<Investor, Integer> pair : updateInvestors.entrySet())
                    pair.getKey().setFundRemaining(pair.getValue());

//                System.out.println(fundedLoan);
            }
        }

//        System.out.println(fundedLoans);
        for (FundedLoan fun : fundedLoans)
            System.out.println(fun.toString());

    }

    /**
     * This method creates a new funded loan object and
     * filters the loan with the appropriate product type
     *
     * @param productType
     * @param loan
     */
    private void processLoan(String productType, Loan loan)
    {
        List<Investor> investors = new ArrayList<>();
        fundedLoan = new FundedLoan(loan.getLoanId(), loan.getLoanAmount(), loan.getCompletedDate());

//        System.out.println(fundedLoan);


        if (productType.equals("TRACKER"))
            investors = investorTermFilter(loan, matchingRules.getTrackerInvestors());
        System.out.println(investors);

        if (productType.equals("FIXED"))
            investors = investorTermFilter(loan, matchingRules.getFixedInvestors());

        while (!investors.isEmpty() && !fundedLoan.getFundedStatus())
        {
            fundTheLoan(investors.get(0), fundedLoan);
            investors.remove(0);
        }
    }

    /**
     * This method funds the loan with the investment
     *
     * @param investor
     * @param loan
     */
    private void fundTheLoan(Investor investor, FundedLoan loan)
    {
        if (investor.getFundRemaining() >= loan.getAmountUnfunded())
        {
            int amountInvested = loan.getAmountUnfunded();
            updateInvestors.put(investor, amountInvested);
            loan.setInvestors(investor.getInvestor(), amountInvested);
            loan.setAmountUnfunded(0);
            loan.setFundedStatus(true);

        } else if (investor.getFundRemaining() < loan.getAmountUnfunded())
        {
            int amountInvested = investor.getFundRemaining();
            updateInvestors.put(investor, amountInvested);
            loan.setInvestors(investor.getInvestor(), amountInvested);
            int loanAmountUnfunded = loan.getAmountUnfunded() - amountInvested;
            loan.setAmountUnfunded(loanAmountUnfunded);
        }
    }


}
