package com.landbay.dao;

import com.landbay.model.Investor;
import com.opencsv.bean.ColumnPositionMappingStrategy;
import com.opencsv.bean.CsvToBean;
import com.opencsv.bean.CsvToBeanBuilder;

import java.io.IOException;
import java.io.Reader;
import java.nio.file.Files;
import java.nio.file.Paths;
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

    public List<Investor> getInvestors()
    {
        Reader reader;
        try {
            reader = Files.newBufferedReader(Paths.get(CSV_FILE_PATH));
        } catch (IOException e) {
            throw new RuntimeException();
        }

        // Using below strategy to decouple
        // this library from the model and
        // avoid using annotations
        ColumnPositionMappingStrategy<Investor> strategy;
        strategy = new ColumnPositionMappingStrategy<>();

        strategy.setType(Investor.class);
        String[] memberFieldsToBindTo = {"investor", "investmentAmount", "productType", "term"};
        strategy.setColumnMapping(memberFieldsToBindTo);

        CsvToBean<Investor> csvToBean; // creating a bean collection with type Investor
        csvToBean = new CsvToBeanBuilder<Investor>(reader)
                .withMappingStrategy(strategy)
                .withSkipLines(1)
                .withIgnoreLeadingWhiteSpace(true)
                .build();

        Iterator<Investor> investorIterator = csvToBean.iterator();

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