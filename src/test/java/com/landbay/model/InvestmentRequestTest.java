package com.landbay.model;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static org.hamcrest.MatcherAssert.assertThat;
import static org.hamcrest.Matchers.instanceOf;


/**
 * Unit tests for InvRequest class
 */
public class InvestmentRequestTest {

    private InvestmentRequest invRequest;

    @BeforeEach
    void init()
    {
        invRequest = new InvestmentRequest();
    }

    @Test
    void InvRequestToBeDefined()
    {
        assertThat(invRequest, instanceOf(InvestmentRequest.class));
    }
}
