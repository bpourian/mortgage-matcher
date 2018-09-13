package com.landbay;

import com.landbay.rules.MatchRequestRulesImpl;

import java.io.IOException;

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

        MatchRequestRulesImpl matchRequestRules = new MatchRequestRulesImpl();
        matchRequestRules.sortLoansByOldestFirst();


    }

}
