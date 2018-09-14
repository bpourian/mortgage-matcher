package com.landbay;

import com.landbay.model.InvestmentRequest;
import com.landbay.rules.MatchRequestRulesImpl;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

/**
 * This main class will run the application and
 * output the list of loans that have been matched
 *
 */
public class MortgageMatcher
{
    public static void main( String[] args ) throws IOException {
//        InvestmentRequestCsvDaoImpl investmentRequestCsvDaoImpl = new InvestmentRequestCsvDaoImpl();
//        investmentRequestCsvDaoImpl.listInvestmentRequests();
//
//
//        LoanCsvDaoImpl loanCsvDao = new LoanCsvDaoImpl();
//        loanCsvDao.listLoan();
//
        MatchRequestRulesImpl matchRequestRules = new MatchRequestRulesImpl();
        matchRequestRules.sortLoansByOldestFirst();
        matchRequestRules.sortProductTypesIntoLists();
//        System.out.println(matchRequestRules.sortLoansByOldestFirst());
//
//        System.out.println(matchRequestRules.getFixedInvestmentRequestsList().get(0).getInvestor());
//        System.out.println(matchRequestRules.getTrackerInvestmentRequestsList());
//
        List<InvestmentRequest> li = new ArrayList<>();

        li = matchRequestRules.investmentRequestTermFilter(matchRequestRules.sortLoansByOldestFirst().get(1), matchRequestRules.getFixedInvestmentRequestsList());


        for (InvestmentRequest l : li) {
            System.out.println(l.getInvestor());
            System.out.println(l.getInvestmentAmount());
        }

    }

}
