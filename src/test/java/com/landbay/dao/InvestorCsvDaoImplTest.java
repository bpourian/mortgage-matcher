package com.landbay.dao;

import com.landbay.model.Investor;
import com.landbay.util.CsvHelper;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.MockitoAnnotations;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

import static org.hamcrest.MatcherAssert.assertThat;
import static org.hamcrest.Matchers.is;
import static org.mockito.Mockito.when;

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
    void getInvestors()
    {
        Investor inv = new Investor("Jeff", 100, "FIXED", 12);
        List<Investor> investors = new ArrayList<Investor>();
        investors.add(inv);

        Iterator<Investor> investorIterator = investors.iterator();

        when(csvHelperMock.csvToBeanIterator()).thenReturn(investorIterator);

        List<Investor> actual = new ArrayList<Investor>();
        actual.add(investorCsvDao.getInvestors(csvHelperMock).get(0));
        System.out.println(actual.get(0));
        System.out.println(investors.get(0));


        Investor act = actual.get(0);
        Investor exp = investors.get(0);
//        assertEquals(exp,act);
        assertThat(actual, is(investors));
//        assertThat(actual, IsIterableContainingInAnyOrder.containsInAnyOrder(test));
    }
}
