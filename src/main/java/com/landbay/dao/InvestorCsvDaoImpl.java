package com.landbay.dao;

import com.landbay.model.Investor;
import com.landbay.util.CsvHelper;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

public class InvestorCsvDaoImpl implements InvestorDao
{
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