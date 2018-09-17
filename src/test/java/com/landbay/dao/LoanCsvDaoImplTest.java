package com.landbay.dao;

import com.landbay.model.Loan;
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

@DisplayName("Testing the Loan DAO for CSV files")
class LoanCsvDaoImplTest {

    @Mock
    private CsvHelper csvHelperMock;

    @InjectMocks
    private LoanCsvDaoImpl loanCsvDao;

    @BeforeEach
    void setUp() {
        loanCsvDao = new LoanCsvDaoImpl();
        MockitoAnnotations.initMocks(this);
    }

    @Test
    @DisplayName("Returns a list of loans from a given CSV file")
    void listLoan() {
        setUpCsvMockInstance();
        List<Loan> actualInvestorList = loanCsvDao.getLoans(csvHelperMock);
        int actualLoanId = actualInvestorList.get(0).getLoanId();

        assertEquals(3 ,actualLoanId);
    }

    private void setUpCsvMockInstance(){
        Loan loan = new Loan(3, 100, "FIXED", 12, "01/01/2001");
        List<Loan> csvMockList = new ArrayList<Loan>();
        csvMockList.add(loan);
        Iterator<Loan> csvHelperMockReturn = csvMockList.iterator();
        when(csvHelperMock.csvToBeanIterator()).thenReturn(csvHelperMockReturn);
    }
}