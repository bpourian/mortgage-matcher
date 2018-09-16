package com.landbay.rules;

import com.landbay.model.Investor;
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

    private Investor investor;

    @BeforeEach
    void beforeEach() {
    }

    @Test
    @DisplayName("Sorts investors into FIXED and TRACKER lists")
    void sortProductTypesIntoLists() {
    }

    @Test
    @DisplayName("Filters terms of investors so they exceed loan term")
    void investorTermFilter() {
    }

    @Nested
    @DisplayName("Sort investors into FIXED and TRACKER lists")
    class sortLoansByOldestFirst
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

    List<Investor> mockInvestorList()
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
}