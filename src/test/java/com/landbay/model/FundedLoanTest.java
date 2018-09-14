package com.landbay.model;

import org.hamcrest.collection.IsMapContaining;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static org.hamcrest.MatcherAssert.assertThat;
import static org.hamcrest.Matchers.instanceOf;
import static org.junit.jupiter.api.Assertions.assertEquals;

class FundedLoanTest {

    private FundedLoan fundedLoan;

    @BeforeEach
    void setUp() {
        fundedLoan = new FundedLoan(4, 1000, "01/01/2001");
        fundedLoan.setInvestors("James", 1000);
        fundedLoan.setInvestors("Alex", 200);

    }

    @Test
    void InvestorToBeDefined()
    {
        assertThat(fundedLoan, instanceOf(FundedLoan.class));
    }


    @Test
    void getLoanId() {
        assertEquals(4, fundedLoan.getLoanId());
    }

    @Test
    void getLoanAmount() {
        assertEquals(1000, fundedLoan.getLoanAmount());
    }

    @Test
    void getCompletedDate() {
        assertEquals("01/01/2001", fundedLoan.getCompletedDate());
    }

    @Test
    void getInvestors() {
        assertThat(fundedLoan.getInvestors(), IsMapContaining.hasEntry("Alex", 200));
    }

    @Test
    void getFundedStatus() {
        assertEquals(false, fundedLoan.getFundedStatus());
    }

    @Test
    void getAmountUnfunded() {
        assertEquals(1000, fundedLoan.getAmountUnfunded());
    }
}