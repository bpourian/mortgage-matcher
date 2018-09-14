package com.landbay;

import com.landbay.dao.InvestorCsvDaoImpl;
import com.landbay.dao.LoanCsvDaoImpl;
import com.landbay.rules.MatchingRulesImpl;
import com.landbay.service.Match;

/**
 * This main class will run the application and
 * output the list of loans that have been matched
 *
 */
public class Main
{
    public static void main( String[] args )
    {
        MatchingRulesImpl rules = new MatchingRulesImpl();
        LoanCsvDaoImpl loan = new LoanCsvDaoImpl();
        InvestorCsvDaoImpl inv = new InvestorCsvDaoImpl();



        Match match = new Match(rules, loan.listLoan(), inv.listInvestmentRequests() );

        match.startMatch();
    }

}
