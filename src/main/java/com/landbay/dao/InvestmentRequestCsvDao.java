package com.landbay.dao;

import com.landbay.model.InvestmentRequest;
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

public class InvestmentRequestCsvDao implements InvestmentRequestDao {
    private static final String CSV_FILE_PATH = "src/main/resources/data/investmentRequests.csv";

    @Override
    public List<InvestmentRequest> listInvestmentRequests() {
        Reader reader;
        try {
            reader = Files.newBufferedReader(Paths.get(CSV_FILE_PATH));
        } catch (IOException e) {
            throw new RuntimeException();
        }

        ColumnPositionMappingStrategy<InvestmentRequest> strategy = new ColumnPositionMappingStrategy<>();
        strategy.setType(InvestmentRequest.class);
        String[] memberFieldsToBindTo = {"investor", "investmentAmount", "productType", "term"};
        strategy.setColumnMapping(memberFieldsToBindTo);

        CsvToBean csvToBean = new CsvToBeanBuilder(reader)
                .withMappingStrategy(strategy)
                .withSkipLines(1)
                .withIgnoreLeadingWhiteSpace(true)
                .build();

        Iterator<InvestmentRequest> investmentRequestIterator = csvToBean.iterator();

        List<InvestmentRequest> list = new ArrayList<>();

        while (investmentRequestIterator.hasNext()) {
            InvestmentRequest investmentRequest = investmentRequestIterator.next();
            list.add(investmentRequest);
        }

        for (InvestmentRequest ir : list) {
            System.out.println(ir.getProductType());
        }

        return list;
    }
}