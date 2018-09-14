package com.landbay.service;

import com.landbay.model.FundedLoans;
import com.landbay.model.Investor;
import com.landbay.model.Loan;
import com.landbay.rules.MatchingRulesImpl;
import com.sun.jersey.spi.inject.Inject;

import java.util.ArrayList;
import java.util.List;

public class Match {

    @Inject
    private MatchingRulesImpl matchingRules;

    private List<Loan> loanData;
    private List<Investor> investorData;
    private List<FundedLoans> fundedLoans;


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
        }
    }

    private void processLoan(String productType, Loan loan)
    {
        List<Investor> investors = new ArrayList<>();

        if (productType.equals("TRACKER"))
            investors = investorTermFilter(loan, matchingRules.getTrackerInvestors());
        if (productType.equals("FIXED"))
            investors = investorTermFilter(loan, matchingRules.getFixedInvestors());

        while (!investors.isEmpty() && loan.getfundedStatus() == false)
        {
            fundTheLoan(investors.get(0), loan);
            investors.remove(0);
        }
    }

    private void fundTheLoan(Investor investor, Loan loan)
    {
        if (investor.getFundRemaining() >= loan.getAmountUnfunded())
        {
            int investmentLeftOver = investor.getFundRemaining() - loan.getAmountUnfunded();
            investor.setFundRemaining(investmentLeftOver);
            loan.setFundedStatus(true);

        } else if (investor.getFundRemaining() < loan.getAmountUnfunded())
        {
            int loanAmountUnfunded = loan.getAmountUnfunded() - investor.getFundRemaining();
            loan.setAmountUnfunded(loanAmountUnfunded);
        }
    }


}
