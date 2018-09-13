package com.landbay.model;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static org.hamcrest.MatcherAssert.assertThat;
import static org.hamcrest.Matchers.instanceOf;
import static org.junit.jupiter.api.Assertions.assertEquals;


/**
 * Unit tests for InvRequest class
 */
public class InvestmentRequestTest {

    private InvestmentRequest invRequest;

    // test data
    private String investor = "Alex";
    private int investmentAmount = 10000;
    private String productType = "FIXED";
    private int term = 12;


    @BeforeEach
    public void init()
    {
        invRequest = new InvestmentRequest(investor, investmentAmount, productType, term);
    }

    @Test
    void InvestmentRequestToBeDefined()
    {
        assertThat(invRequest, instanceOf(InvestmentRequest.class));
    }

    @Test
    void InvestmentRequestToReturnInvestorName()
    {
        assertEquals("Alex", invRequest.getInvestor());
    }

    @Test
    void InvestmentRequestToReturnInvestmentAmount()
    {
        assertEquals(10000, invRequest.getInvestmentAmount());
    }

    @Test
    void InvestmentRequestToReturnProductType()
    {
        assertEquals("FIXED", invRequest.getProductType());
    }

    @Test
    void InvestmentRequestToReturnTerm() { assertEquals(12, invRequest.getTerm()); }
}
