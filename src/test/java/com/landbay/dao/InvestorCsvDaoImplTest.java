package com.landbay.dao;

import com.landbay.model.Investor;
import com.landbay.util.CsvHelper;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.MockitoAnnotations;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.mockito.Mockito.when;

@DisplayName("Testing the Investor DAO for CSV files")
class InvestorCsvDaoImplTest {

    @Mock
    private CsvHelper csvHelperMock;

    @InjectMocks
    private InvestorCsvDaoImpl investorCsvDao;

    @BeforeEach
    void setUp()
    {
        investorCsvDao = new InvestorCsvDaoImpl();
        MockitoAnnotations.initMocks(this);
    }

    @Test
    @DisplayName("Returns a list of investors from a given CSV file")
    void getInvestors()
    {
        setUpCsvMockInstance();
        List<Investor> actualInvestorList = investorCsvDao.getInvestors(csvHelperMock);
        String actualInvestorName = actualInvestorList.get(0).getInvestor();

        assertEquals("Jeff" ,actualInvestorName);
    }

    private void setUpCsvMockInstance(){
        Investor investor = new Investor("Jeff", 100, "FIXED", 12);
        List<Investor> csvMockList = new ArrayList<Investor>();
        csvMockList.add(investor);
        Iterator<Investor> csvHelperMockReturn = csvMockList.iterator();
        when(csvHelperMock.csvToBeanIterator()).thenReturn(csvHelperMockReturn);
    }
}
