package com.landbay.model;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static org.hamcrest.MatcherAssert.assertThat;
import static org.hamcrest.Matchers.instanceOf;
import static org.junit.jupiter.api.Assertions.assertEquals;

/**
 * Unit test for Loan class
 */
public class LoanTest {

    private Loan loan;

    // test data
    private int loanId = 2;
    private int loanAmount = 20000;
    private String product = "TRACKER";
    private int term = 25;
    private String completedDate = "01/01/2018";

    @BeforeEach
    void init()
    {
        loan = new Loan(loanId, loanAmount, product, term, completedDate);
    }

    @Test
    void LoanToBeDefined()
    {
        assertThat(loan, instanceOf(Loan.class));
    }

    @Test
    void LoanToReturnLoanId()
    {
        assertEquals(2, loan.getLoanId());
    }

    @Test
    void LoanToReturnLoanAmount()
    {
        assertEquals(20000, loan.getLoandAmount());
    }

    @Test
    void LoanToReturnProduct()
    {
        assertEquals("TRACKER", loan.getProduct());
    }

    @Test
    void LoanToReturnTerm()
    {
        assertEquals(25, loan.getTerm());
    }

    @Test
    void LoanToReturnCompletedDate()
    {
        assertEquals("01/01/2018", loan.getCompletedDate());
    }
}
