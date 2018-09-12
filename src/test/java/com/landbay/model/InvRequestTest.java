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

    @Test
    void InvRequestToBeDefined()
    {
        assertThat(invRequest, instanceOf(InvRequest.class));
    }
}
