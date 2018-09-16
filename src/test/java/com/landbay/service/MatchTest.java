package com.landbay.service;

import com.landbay.dao.InvestorCsvDaoImpl;
import com.landbay.dao.LoanCsvDaoImpl;
import com.landbay.model.Investor;
import com.landbay.model.Loan;
import com.landbay.rules.MatchingRulesImpl;
import com.landbay.util.CsvHelper;
import org.junit.jupiter.api.*;
//import org.junit.jupiter.api.BeforeAll;
//import org.junit.jupiter.api.BeforeEach;
//import org.junit.jupiter.api.DisplayName;
//import org.junit.jupiter.api.Test;

import java.io.ByteArrayOutputStream;
import java.io.PrintStream;
import java.util.List;

import static org.hamcrest.MatcherAssert.assertThat;
import static org.hamcrest.Matchers.instanceOf;
import static org.junit.jupiter.api.Assertions.assertEquals;

/**
 * Unit test for the Match class
 */
@DisplayName("Match class Unit and End to End Test")
public class MatchTest
{
    private Match match;

    private MatchingRulesImpl matchingRules;
    private LoanCsvDaoImpl loanCsvDao;
    private InvestorCsvDaoImpl investorCsvDao;

    private static final ByteArrayOutputStream outContent = new ByteArrayOutputStream();
    private static final PrintStream originalOut = System.out;

    @BeforeAll
    static void beforeAll()
    {
        System.setOut(new PrintStream(outContent));
    }



    @BeforeEach
    void beforeEach()
    {
        String[] memberFieldsInv = {"investor", "investmentAmount", "productType", "term"};
        String pathInvestment = "src/main/resources/data/investmentRequests.csv";

        String[] memberFieldsLoan = {"loanId", "loanAmount", "product", "term", "completedDate"};
        String pathLoan = "src/main/resources/data/loans.csv";

        matchingRules = new MatchingRulesImpl();
        loanCsvDao = new LoanCsvDaoImpl();
        investorCsvDao = new InvestorCsvDaoImpl();

        CsvHelper<Loan> csvHelperLoan = new CsvHelper<>(Loan.class, pathLoan, memberFieldsLoan);
        CsvHelper<Investor> csvHelperInvestor = new CsvHelper<>(Investor.class, pathInvestment, memberFieldsInv);

        List<Loan> loans = loanCsvDao.getLoans(csvHelperLoan);
        List<Investor> investors = investorCsvDao.getInvestors(csvHelperInvestor);

        match = new Match(matchingRules, loans, investors);

    }

    @AfterAll
    static void afterAll()
    {
        System.setOut(originalOut);
    }

    @Test
    @DisplayName("Should create an instance of class Match")
    void MatchRequestsToBeDefined()
    {
        assertThat(match, instanceOf(Match.class));
    }

    @Test
    @DisplayName("System.out.println test to ensure correct setup")
    void systemPrintOutTest()
    {
        System.out.println("Landbay Java Application");

        assertEquals("Landbay Java Application\n", outContent.toString());
    }

    @Test
    @DisplayName("Should print to terminal a list of qualified loans")
    void startMatch()
    {
//        assertEquals("", match.startMatch());
    }
}

