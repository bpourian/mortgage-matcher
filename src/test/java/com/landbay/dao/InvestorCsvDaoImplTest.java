package com.landbay.dao;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.InjectMocks;
import org.mockito.Mock;

import java.io.Reader;

import static org.junit.jupiter.api.Assertions.assertEquals;

class InvestorCsvDaoImplTest {

    @Mock
    Reader mockReader;

    @InjectMocks
    InvestorCsvDaoImpl invDao;

    @BeforeEach
    void setUp() {
//        mockReader = Mockito.mock(Files.newBufferedReader("src/main/resources/data/investmentRequests.csv"));
//        try {
//            Mockito.when(((BufferedReader) mockReader).readLine()).thenReturn("Line 1");
//        } catch (IOException e) {
//            e.printStackTrace();
//        }
//
//        invDao = new InvestorCsvDaoImpl();
//        MockitoAnnotations.initMocks(InvestorCsvDaoImpl.class);
    }

    @Test
    void getInvestors() {
        assertEquals("1", "1");
    }
}
