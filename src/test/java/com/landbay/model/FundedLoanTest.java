package com.landbay.model;

import org.hamcrest.collection.IsMapContaining;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import static org.hamcrest.MatcherAssert.assertThat;
import static org.hamcrest.Matchers.instanceOf;
import static org.junit.jupiter.api.Assertions.assertEquals;

class FundedLoanTest {

    private FundedLoan fundedLoan;

    @BeforeEach
    void setUp() {
        fundedLoan = new FundedLoan(4, "TRACKER", 1000, 12, "01/01/2001");
        fundedLoan.setInvestors("James", 1000);
        fundedLoan.setInvestors("Alex", 200);
    }

    @Test
    @DisplayName("Create an instance of FundedLoan class")
    void fundedLoanToBeDefined()
    {
        assertThat(fundedLoan, instanceOf(FundedLoan.class));
    }

    @Test
    @DisplayName("Get loan ID")
    void getLoanId() {
        assertEquals(4, fundedLoan.getLoanId());
    }

    @Test
    @DisplayName("Get Loan amount")
    void getLoanAmount() {
        assertEquals(1000, fundedLoan.getLoanAmount());
    }

    @Test
    @DisplayName("Get completed date")
    void getCompletedDate() {
        assertEquals("01/01/2001", fundedLoan.getCompletedDate());
    }

    @Test
    @DisplayName("Get list of investors")
    void getInvestors() {
        assertThat(fundedLoan.getInvestors(), IsMapContaining.hasEntry("Alex", 200));
    }

    @Test
    @DisplayName("Get funding status of loan")
    void getFundedStatus() {
        assertEquals(false, fundedLoan.getFundedStatus());
    }

    @Test
    @DisplayName("Get amount of loan unfunded")
    void getAmountUnfunded() {
        assertEquals(1000, fundedLoan.getAmountUnfunded());
    }
}