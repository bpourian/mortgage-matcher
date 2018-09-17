package com.landbay.rules;

import com.landbay.model.Investor;
import com.landbay.model.Loan;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Nested;
import org.junit.jupiter.api.Test;

import java.util.ArrayList;
import java.util.List;

import static org.junit.jupiter.api.Assertions.assertEquals;

@DisplayName("MatchRules class Unit Test")
class MatchingRulesImplTest {

    private MatchingRulesImpl matchingRules;

    @BeforeEach
    void beforeEach() {
        matchingRules = new MatchingRulesImpl();
    }

    @Test
    @DisplayName("Sort loans into order of oldest date first")
    void sortLoansByOldestFirst() {
        List<Loan> loans = matchingRules.sortLoansByOldestFirst(mockUnsortedLoans());

        int actualLoanId = loans.get(0).getLoanId();
        int expectedLoanId = 3;
        assertEquals(expectedLoanId, actualLoanId);
    }

    @Test
    @DisplayName("Filter terms of investors so they exceed loan term")
    void investorTermFilter() {
        Loan loan = new Loan(7, 1000, "FIXED", 12, "09/01/2015");
        List <Investor> investors = matchingRules.investorTermFilter(loan, mockInvestorList());
        List<String> actualInvestors = new ArrayList<>();

        List<String> expectedInvestors = new ArrayList<>();
        expectedInvestors.add("James");
        expectedInvestors.add("Jenny");

        for (Investor inv : investors)
                actualInvestors.add(inv.getInvestor());

        assertEquals(expectedInvestors, actualInvestors);
    }

    @Nested
    @DisplayName("Sort investors into FIXED and TRACKER lists")
    class sortProductTypesIntoLists
    {
        @BeforeEach
        void beforeEach() {
            matchingRules = new MatchingRulesImpl();

            /* apply method and pass param mockInvestorList */
            matchingRules.sortProductTypesIntoLists(mockInvestorList());
        }

        @Test
        @DisplayName("Returns a list of TRACKER investors")
        void getTrackerInvestors() {
            Investor investor = new Investor("Jenny", 300000, "TRACKER", 20);
            List<Investor> expectedInvestors = new ArrayList<>();
            expectedInvestors.add(investor);

            String invExpected = expectedInvestors.get(0).toString();
            String invActual = matchingRules.getTrackerInvestors().get(0).toString();

            assertEquals(invExpected, invActual);
        }

        @Test
        @DisplayName("Returns a list of FIXED investors")
        void getFixedInvestors() {
            Investor investor = new Investor("James", 100000, "FIXED", 18);
            List<Investor> expectedInvestors = new ArrayList<>();
            expectedInvestors.add(investor);

            String invExpected = expectedInvestors.get(0).toString();
            String invActual = matchingRules.getFixedInvestors().get(0).toString();

            assertEquals(invExpected, invActual);
        }
    }

    private List<Investor> mockInvestorList()
    {
        Investor investor1 = new Investor("James", 100000, "FIXED", 18);
        Investor investor2 = new Investor("Jenny", 300000, "TRACKER", 20);
        Investor investor3 = new Investor("Bob", 1000, "FIXED", 12);
        List<Investor> investors = new ArrayList<>();
        investors.add(investor1);
        investors.add(investor2);
        investors.add(investor3);
        return investors;
    }

    private List<Loan> mockUnsortedLoans()
    {
        Loan loan1 = new Loan(7, 1000, "FIXED", 12, "09/01/2015");
        Loan loan2 = new Loan(5, 1000, "FIXED", 12, "04/01/2015");
        Loan loan3 = new Loan(3, 1000, "FIXED", 12, "01/01/2015");

        List<Loan> loans = new ArrayList<>();
        loans.add(loan1);
        loans.add(loan2);
        loans.add(loan3);
        return loans;
    }
}