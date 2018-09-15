package com.landbay;

import com.landbay.dao.InvestorCsvDaoImpl;
import com.landbay.model.Investor;
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
        String[] memberFields = {"investor", "investmentAmount", "productType", "term"};
        String path = "src/main/resources/data/investmentRequests.csv";
        InvestorCsvDaoImpl investorCsvDao = new InvestorCsvDaoImpl();
        CsvHelper<Investor> csvHelper = new CsvHelper<>(Investor.class, path, memberFields );


        for (Investor in : investorCsvDao.getInvestors(csvHelper))
            System.out.println(in);
    }
}
