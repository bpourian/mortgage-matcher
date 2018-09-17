package com.landbay;

import com.landbay.dao.InvestorCsvDaoImpl;
import com.landbay.dao.LoanCsvDaoImpl;
import com.landbay.model.Investor;
import com.landbay.model.Loan;
import com.landbay.rules.MatchingRulesImpl;
import com.landbay.service.Match;
import com.landbay.util.CsvHelper;

import java.util.List;

/**
 * This main class will run the application and
 * output the list of loans that have been matched
 *
 */
public class Main
{
    public static void main( String[] args )
    {


        String[] memberFieldsInv = {"investor", "investmentAmount", "productType", "term"};
        String pathInvestment = "src/main/resources/data/investmentRequests.csv";

        String[] memberFieldsLoan = {"loanId", "loanAmount", "product", "term", "completedDate"};
        String pathLoan = "src/main/resources/data/loans.csv";

       MatchingRulesImpl matchingRules = new MatchingRulesImpl();
       LoanCsvDaoImpl loanCsvDao = new LoanCsvDaoImpl();
       InvestorCsvDaoImpl investorCsvDao = new InvestorCsvDaoImpl();

        CsvHelper<Loan> csvHelperLoan = new CsvHelper<>(Loan.class, pathLoan, memberFieldsLoan);
        CsvHelper<Investor> csvHelperInvestor = new CsvHelper<>(Investor.class, pathInvestment, memberFieldsInv);

        List<Loan> loans = loanCsvDao.getLoans(csvHelperLoan);
        List<Investor> investors = investorCsvDao.getInvestors(csvHelperInvestor);

        Match match = new Match(matchingRules, loans, investors);

        match.startMatch();
    }
}
