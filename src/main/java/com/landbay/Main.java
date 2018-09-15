package com.landbay;

import com.landbay.dao.InvestorCsvDaoImpl;
import com.landbay.dao.LoanCsvDaoImpl;
import com.landbay.model.Investor;
import com.landbay.model.Loan;
import com.landbay.util.CsvHelper;

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
        String[] memberFieldsLoa = {"loanId", "loanAmount", "product", "term", "completedDate"};
        String pathLoan = "src/main/resources/data/loans.csv";
        InvestorCsvDaoImpl investorCsvDao = new InvestorCsvDaoImpl();
        CsvHelper<Investor> csvHelper = new CsvHelper<>(Investor.class, pathInvestment, memberFieldsInv );

        LoanCsvDaoImpl loanCsvDao = new LoanCsvDaoImpl();
        CsvHelper<Loan> csvHelper2 = new CsvHelper<>(Loan.class, pathLoan, memberFieldsLoa );


        for (Investor in : investorCsvDao.getInvestors(csvHelper))
            System.out.println(in);

        for (Loan in : loanCsvDao.getLoans(csvHelper2))
            System.out.println(in);
    }
}
