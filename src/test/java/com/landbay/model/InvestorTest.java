package com.landbay.model;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import static org.hamcrest.MatcherAssert.assertThat;
import static org.hamcrest.Matchers.instanceOf;
import static org.junit.jupiter.api.Assertions.assertEquals;

public class InvestorTest {

    private Investor invRequest;

    @BeforeEach
    void setUp()
    {
        // test data
        int investmentAmount = 10000;
        String investor = "Alex";
        String productType = "FIXED";
        int term = 12;
        invRequest = new Investor(investor, investmentAmount, productType, term);
    }

    @Test
    @DisplayName("Creates an instance of Investor class")
    void investorToBeDefined()
    {
        assertThat(invRequest, instanceOf(Investor.class));
    }

    @Test
    @DisplayName("Get investor name")
    void getInvestor()
    {
        assertEquals("Alex", invRequest.getInvestor());
    }

    @Test
    @DisplayName("Get investment amount")
    void getInvestmentAmount()
    {
        assertEquals(10000, invRequest.getInvestmentAmount());
    }

    @Test
    @DisplayName("Get product type")
    void getProductType()
    {
        assertEquals("FIXED", invRequest.getProductType());
    }

    @Test
    @DisplayName("Get term of investment")
    void getTerm() { assertEquals(12, invRequest.getTerm()); }

    @Test
    @DisplayName("Get amount of fund remaining")
    void getFundRemaining() { assertEquals(10000, invRequest.getFundRemaining()); }
}
