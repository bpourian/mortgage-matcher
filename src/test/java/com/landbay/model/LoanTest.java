package com.landbay.model;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import static org.hamcrest.MatcherAssert.assertThat;
import static org.hamcrest.Matchers.instanceOf;
import static org.junit.jupiter.api.Assertions.assertEquals;

/**
 * Unit test for Loan class
 */
public class LoanTest {

    private Loan loan;

    @BeforeEach
    void setUp()
    {
        // test data
        int loanId = 2;
        int loanAmount = 20000;
        String product = "TRACKER";
        int term = 25;
        String completedDate = "01/01/2018";

        loan = new Loan(loanId, loanAmount, product, term, completedDate);
    }

    @Test
    @DisplayName("Create an instance of Loan class")
    void LoanToBeDefined()
    {
        assertThat(loan, instanceOf(Loan.class));
    }

    @Test
    @DisplayName("Get loan ID")
    void getLoanId()
    {
        assertEquals(2, loan.getLoanId());
    }

    @Test
    @DisplayName("Get loan amount")
    void getLoanAmount()
    {
        assertEquals(20000, loan.getLoanAmount());
    }

    @Test
    @DisplayName("Get product type")
    void getProduct()
    {
        assertEquals("TRACKER", loan.getProduct());
    }

    @Test
    @DisplayName("Get term of loan")
    void getTerm()
    {
        assertEquals(25, loan.getTerm());
    }

    @Test
    @DisplayName("Get completed date for loan")
    void getCompletedDate()
    {
        assertEquals("01/01/2018", loan.getCompletedDate());
    }
}
