package com.landbay.dao;

import com.landbay.model.Investor;
import com.landbay.util.CsvHelper;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;


/**
 * This class implements InvestorDao interface
 * and lists all investment requests from the csv file
 */
public class InvestorCsvDaoImpl implements InvestorDao
{
    private String CSV_FILE_PATH;

    public InvestorCsvDaoImpl(String CSV_FILE_PATH)
    {
        this.CSV_FILE_PATH = CSV_FILE_PATH;
    }

    // default constructor
    public InvestorCsvDaoImpl()
    {
        this("src/main/resources/data/investmentRequests.csv");
    }

    @Override
    public List<Investor> getInvestors(CsvHelper csvHelper)
    {
        Iterator<Investor> investorIterator = csvHelper.csvToBeanIterator();
        List<Investor> list = new ArrayList<>();
        while (investorIterator.hasNext())
        {
            Investor investor = investorIterator.next();
            Investor newInvestor = new Investor(investor.getInvestor(),
                    investor.getInvestmentAmount(),
                    investor.getProductType(),
                    investor.getTerm());
            list.add(newInvestor);
        }
        return list;
    }
}