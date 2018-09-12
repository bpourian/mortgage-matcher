package com.landbay.model;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static org.hamcrest.MatcherAssert.assertThat;
import static org.hamcrest.Matchers.instanceOf;

/**
 * Unit test for Loan class
 */
public class LoanTest {

    private Loan loan;

    @BeforeEach
    void init()
    {
        loan = new Loan();
    }

    @Test
    void LoanToBeDefined()
    {
        assertThat(loan, instanceOf(Loan.class));
    }
}
