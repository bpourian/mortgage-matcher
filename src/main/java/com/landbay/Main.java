package com.landbay;

import com.landbay.dao.InvestmentRequestCsvDao;
import com.landbay.dao.LoanCsvDao;
import com.landbay.dao.LoanCsvDaoImpl;

import java.io.IOException;

/**
 * This main class will run the application and
 * output the list of loans that have been matched
 *
 */
public class Main
{
    public static void main( String[] args ) throws IOException {
        InvestmentRequestCsvDao investmentRequestCsvDao = new InvestmentRequestCsvDao();
        investmentRequestCsvDao.listInvestmentRequests();

        LoanCsvDao loanCsvDao = new LoanCsvDaoImpl();
        loanCsvDao.listLoan();

    }

}
