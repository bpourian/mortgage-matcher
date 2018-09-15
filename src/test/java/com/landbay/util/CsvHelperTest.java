package com.landbay.util;

import com.landbay.model.Investor;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.util.Iterator;

import static org.junit.jupiter.api.Assertions.assertEquals;

class CsvHelperTest {

    CsvHelper<Investor> csvHelper;

    @BeforeEach
    void setUp() {
        String filePath = "src/main/resources/data/investmentRequests.csv";
        String[] memberFields = {"investor", "investmentAmount", "productType", "term"};

        csvHelper = new CsvHelper<>(Investor.class, filePath, memberFields);
    }

    @Test
    void csvToBeanIterator() {

        Iterator<Investor> investorIterator = csvHelper.csvToBeanIterator();
        while (investorIterator.hasNext()) {
            Investor investor = investorIterator.next();
            Investor newInvestor = new Investor(investor.getInvestor(),
                    investor.getInvestmentAmount(),
                    investor.getProductType(),
                    investor.getTerm());

            System.out.println(newInvestor);
        }

        assertEquals("Investor", "Investor");
    }
}