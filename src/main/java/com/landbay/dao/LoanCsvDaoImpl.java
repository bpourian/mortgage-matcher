package com.landbay.dao;

import com.landbay.model.Loan;
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
 * This class implements LoanDao interface
 * and lists all loan requests from the csv file
 */
public class LoanCsvDaoImpl implements LoanDao
{
    private String CSV_FILE_PATH;

    public LoanCsvDaoImpl(String CSV_FILE_PATH)
    {
        this.CSV_FILE_PATH = CSV_FILE_PATH;
    }

    // default constructor
    public LoanCsvDaoImpl()
    {
        this("src/main/resources/data/loans.csv");
    }

    public List<Loan> listLoan() {
        Reader reader;
        try {
            reader = Files.newBufferedReader(Paths.get(CSV_FILE_PATH));
        } catch (IOException e) {
            throw new RuntimeException();
        }

        // Using below strategy to decouple
        // this library from the model and
        // avoid using annotations
        ColumnPositionMappingStrategy<Loan> strategy;
        strategy = new ColumnPositionMappingStrategy<>();
        strategy.setType(Loan.class);
        String[] memberFieldsToBindTo = {"loanId", "loanAmount", "product", "term", "completedDate"};
        strategy.setColumnMapping(memberFieldsToBindTo);

        CsvToBean<Loan> csvToBean; // creating a bean collection with type Loan
        csvToBean = new CsvToBeanBuilder<Loan>(reader)
                .withMappingStrategy(strategy)
                .withSkipLines(1)
                .withIgnoreLeadingWhiteSpace(true)
                .build();

        Iterator<Loan> investmentRequestIterator = csvToBean.iterator();

        List<Loan> list = new ArrayList<>();

        while (investmentRequestIterator.hasNext())
        {
            Loan loan = investmentRequestIterator.next();
            list.add(loan);
        }

//        System.out.println(list);
//
//        for (Loan ln : list)
//        {
//            System.out.println(ln.getCompletedDate());
//        }

        return list;

    }
}
