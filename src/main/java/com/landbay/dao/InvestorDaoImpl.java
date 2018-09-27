package com.landbay.dao;

import com.landbay.model.Investor;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

public class InvestorDaoImpl implements Dao<Investor> {

    @Override
    public List<Investor> listData(Iterator<Investor> investorIterator) {

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
