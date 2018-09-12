package com.landbay.model;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static org.hamcrest.MatcherAssert.assertThat;
import static org.hamcrest.Matchers.instanceOf;


/**
 * Unit tests for InvRequest class
 */
public class InvRequestTest {

    private InvRequest invRequest;

    @BeforeEach
    void init()
    {
        invRequest = new InvRequest();
    }


    // The method returns boolean true if
    // the stack is empty else it returns false
    @Test
    void InvRequestToBeDefined()
    {
        assertThat(invRequest, instanceOf(InvRequest.class));
    }

    @Test
    void InvRequestHasMethodgetInvestor()
    {
        assertThat(invRequest.getInvestor(), true);
    }

    @Test
    void InvRequestHasMethodgetInvestmentAmount()
    {
        assertThat(invRequest.getInvestmentAmount(), true);
    }

    @Test
    void InvRequestHasMethodgetProductType()
    {
        assertThat(invRequest.getProductType(), true);
    }

    @Test
    void InvRequestHasMethodgetTerm()
    {
        assertThat(invRequest.getTerm(), true);
    }
}
