package com.landbay;

import com.landbay.dao.InvestorDaoImpl;
import com.landbay.dao.LoanDaoImpl;
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

        /* File path to investment and loan csv files along with column headings */
        String[] memberFieldsInv = {"investor", "investmentAmount", "productType", "term"};
        String pathInvestment = "src/main/resources/data/investmentRequests.csv";
        String[] memberFieldsLoan = {"loanId", "loanAmount", "product", "term", "completedDate"};
        String pathLoan = "src/main/resources/data/loans.csv";

        /* Read the files provided using the csv helper method */
        CsvHelper<Loan> csvHelperLoan = new CsvHelper<>(Loan.class, pathLoan, memberFieldsLoan);
        CsvHelper<Investor> csvHelperInvestor = new CsvHelper<>(Investor.class, pathInvestment, memberFieldsInv);

        /* Pass the value returned from csv helper to relevant DAO implementation */
        LoanDaoImpl loanCsvDao = new LoanDaoImpl();
        InvestorDaoImpl investorCsvDao = new InvestorDaoImpl();
        List<Loan> loans = loanCsvDao.listData(csvHelperLoan.csvToBeanIterator());
        List<Investor> investors = investorCsvDao.listData(csvHelperInvestor.csvToBeanIterator());

        /* Pass a new instance of matching rules to an instance of Match */
        MatchingRulesImpl matchingRules = new MatchingRulesImpl();

        Match match = new Match(matchingRules, loans, investors);

        match.startMatch();
    }
}
