package com.landbay.service;

import com.google.gson.Gson;
import com.google.gson.GsonBuilder;
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
    private List<FundedLoan> listOfFundedLoans;
    private FundedLoan loanToBeFunded;

    private List<Investor> fixedInvestors;
    private List<Investor> trackerInvestors;

    private HashMap<String, Integer > tempInvestorList = new HashMap<>();


    public Match(MatchingRulesImpl matchingRules, List<Loan> loanData, List<Investor> investorData) {
        this.matchingRules = matchingRules;
        this.loanData = loanData;
        this.investorData = investorData;

        this.listOfFundedLoans = new ArrayList<>();
        this.fixedInvestors = new ArrayList<>();
        this.trackerInvestors = new ArrayList<>();
    }

    private List<Loan> sortLoansByOldestFirst(List<Loan> unsortedList)
    {
        return matchingRules.sortLoansByOldestFirst(unsortedList);
    }

    private void sortProductTypesIntoLists(List<Investor> unsortedList)
    {
        matchingRules.sortProductTypesIntoLists(unsortedList);
        this.fixedInvestors = matchingRules.getFixedInvestors();
        this.trackerInvestors = matchingRules.getTrackerInvestors();
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
        sortProductTypesIntoLists(this.investorData);
        List<Loan> sortedLoans = sortLoansByOldestFirst(this.loanData);

        for (Loan ln : sortedLoans) {
            switch (ln.getProduct()) {
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
            if (loanToBeFunded.getFundedStatus()) {
                listOfFundedLoans.add(loanToBeFunded);

                if (loanToBeFunded.getProduct().equals("TRACKER")) {
                    for (Map.Entry<String, Integer> entry : tempInvestorList.entrySet())
                        updateInvestor(entry.getKey(), entry.getValue(), trackerInvestors);

                    tempInvestorList.clear();
                } else if (loanToBeFunded.getProduct().equals("FIXED")) {
                    for (Map.Entry<String, Integer> entry : tempInvestorList.entrySet())
                        updateInvestor(entry.getKey(), entry.getValue(), fixedInvestors);

                    tempInvestorList.clear();
                }
            }
        }

        printInJsonFormat(listOfFundedLoans);
    }


    /**
     * This method creates a new funded loan object and
     * filters the loan with the appropriate product type
     *
     * @param productType Tracker or Fixed
     * @param loan specific loan that we are matching
     */
    private void processLoan(String productType, Loan loan)
    {
        List<Investor> investors = new ArrayList<>();
        loanToBeFunded = new FundedLoan(
                loan.getLoanId(),
                loan.getProduct(),
                loan.getLoanAmount(),
                loan.getTerm(),
                loan.getCompletedDate());

        if (productType.equals("TRACKER"))
            investors = investorTermFilter(loan, this.trackerInvestors);
        if (productType.equals("FIXED"))
            investors = investorTermFilter(loan, this.fixedInvestors);

        for (Investor inv : investors){
            fundTheLoan(inv, loanToBeFunded);

            if (loanToBeFunded.getFundedStatus())
                break;
        }

    }

    /**
     * This method funds the loan with the investment
     *
     * @param investor name of individual investor
     * @param canWeFundThisLoan specific loan that we are matching
     */
    private void fundTheLoan(Investor investor, FundedLoan canWeFundThisLoan)
    {
        if (investor.getFundRemaining() >= canWeFundThisLoan.getAmountUnfunded())
        {
            int amountInvested = canWeFundThisLoan.getAmountUnfunded();
            tempInvestorList.put(investor.getInvestor(), amountInvested);

            canWeFundThisLoan.setInvestors(investor.getInvestor(), amountInvested);
            canWeFundThisLoan.setAmountUnfunded(0);
            canWeFundThisLoan.setFundedStatus(true);

        } else if (investor.getFundRemaining() > 0 && investor.getFundRemaining() < canWeFundThisLoan.getAmountUnfunded())
        {
            int amountInvested = investor.getFundRemaining();
            tempInvestorList.put(investor.getInvestor(), amountInvested);
            canWeFundThisLoan.setInvestors(investor.getInvestor(), amountInvested);
            int loanAmountUnfunded = canWeFundThisLoan.getAmountUnfunded() - amountInvested;
            canWeFundThisLoan.setAmountUnfunded(loanAmountUnfunded);

            if (canWeFundThisLoan.getAmountUnfunded() == 0)
                canWeFundThisLoan.setFundedStatus(true);
        }
    }

    /**
     * updates investor object from list
     * @param name of the investor
     * @param fundInvested amount invested
     * @param list that the investor belongs to
     */
    private void updateInvestor(String name, int fundInvested, List<Investor> list){
        for (Investor in : list) {
            if (in.getInvestor().equals(name)) {
                int fundRemaining = in.getFundRemaining() - fundInvested;
                in.setFundRemaining(fundRemaining);
                break;
            }
        }
    }

    /**
     * Method converts list to json
     * @param listOfFundedLoans List of all the qualified loans
     */
    private void printInJsonFormat(List<FundedLoan> listOfFundedLoans) {
        for (FundedLoan loan : listOfFundedLoans) {
            Gson gson = new GsonBuilder().setPrettyPrinting().create();
            String jsonFormatted = gson.toJson(loan);
            System.out.println(jsonFormatted);
        }
    }
}


