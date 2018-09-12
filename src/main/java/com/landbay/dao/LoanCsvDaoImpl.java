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
 * This class parses data from a loan CSV file
 */
public class LoanCsvDaoImpl implements LoanCsvDao
{
    private static final String CSV_FILE_PATH = "src/main/resources/data/loans.csv";

    public List<Loan> listLoan() {
        Reader reader;
        try {
            reader = Files.newBufferedReader(Paths.get(CSV_FILE_PATH));
        } catch (IOException e) {
            throw new RuntimeException();
        }

        ColumnPositionMappingStrategy<Loan> strategy = new ColumnPositionMappingStrategy<>();
        strategy.setType(Loan.class);
        String[] memberFieldsToBindTo = {"loanId", "loanAmount", "product", "term", "completedDate"};
        strategy.setColumnMapping(memberFieldsToBindTo);

        CsvToBean<Loan> csvToBean = new CsvToBeanBuilder<Loan>(reader)
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

        for (Loan ln : list)
        {
            System.out.println(ln.getCompletedDate());
        }

        return list;

    }
}
