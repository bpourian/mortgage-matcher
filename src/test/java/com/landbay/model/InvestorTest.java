package com.landbay.model;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static org.hamcrest.MatcherAssert.assertThat;
import static org.hamcrest.Matchers.instanceOf;
import static org.junit.jupiter.api.Assertions.assertEquals;


/**
 * Unit tests for InvRequest class
 */
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
        invRequest.setFundRemaining(10000);
    }

    @Test
    void InvestorToBeDefined()
    {
        assertThat(invRequest, instanceOf(Investor.class));
    }

    @Test
    void getInvestor()
    {
        assertEquals("Alex", invRequest.getInvestor());
    }

    @Test
    void getInvestmentAmount()
    {
        assertEquals(10000, invRequest.getInvestmentAmount());
    }

    @Test
    void getProductType()
    {
        assertEquals("FIXED", invRequest.getProductType());
    }

    @Test
    void getTerm() { assertEquals(12, invRequest.getTerm()); }

    @Test
    void getFundRemaining() { assertEquals(10000, invRequest.getFundRemaining()); }
}
