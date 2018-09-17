package com.landbay.service;

import com.landbay.model.Investor;
import com.landbay.model.Loan;
import com.landbay.rules.MatchingRulesImpl;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import java.io.ByteArrayOutputStream;
import java.io.PrintStream;
import java.util.ArrayList;
import java.util.List;

import static org.hamcrest.MatcherAssert.assertThat;
import static org.hamcrest.Matchers.instanceOf;
import static org.junit.jupiter.api.Assertions.assertEquals;

@DisplayName("Match class Unit and End to End Test")
public class MatchTest
{
    private Match match;

    private static final ByteArrayOutputStream outContent = new ByteArrayOutputStream();
    private static final PrintStream originalOut = System.out;

    @BeforeEach
    void beforeEach()
    {
        System.setOut(new PrintStream(outContent));

        MatchingRulesImpl matchingRulesMock = new MatchingRulesImpl();

        Loan mockLoan = new Loan(2, 99000, "FIXED", 10, "02/01/2015");
        Investor fixedInvestor = new Investor("Ben", 100000, "FIXED", 12);
        Investor trackerInvestor = new Investor("Gary", 200000, "TRACKER", 14);

        List<Loan> loans = new ArrayList<>();
        List<Investor> investors = new ArrayList<>();

        loans.add(mockLoan);
        investors.add(fixedInvestor);
        investors.add(trackerInvestor);

        match = new Match(matchingRulesMock, loans, investors);
    }

    @AfterEach
    void afterEach(){
        System.setOut(originalOut);
    }

    @Test
    @DisplayName("Should create an instance of class Match")
    void MatchRequestsToBeDefined()
    {
        assertThat(match, instanceOf(Match.class));
    }

    @Test
    @DisplayName("Should print to terminal a list of qualified loans")
    void startMatch()
    {

        String expectedResult = "{\n" +
                "  \"loanId\": 2,\n" +
                "  \"product\": \"FIXED\",\n" +
                "  \"loanAmount\": 99000,\n" +
                "  \"completedDate\": \"02/01/2015\",\n" +
                "  \"amountUnfunded\": 0,\n" +
                "  \"fundedStatus\": true,\n" +
                "  \"term\": 10,\n" +
                "  \"investors\": {\n" +
                "    \"Ben\": 99000\n" +
                "  }\n" +
                "}\n";

        match.startMatch();
        assertEquals(expectedResult, outContent.toString());
    }

}

