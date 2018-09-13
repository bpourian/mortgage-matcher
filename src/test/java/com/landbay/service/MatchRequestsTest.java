package com.landbay.service;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static org.hamcrest.MatcherAssert.assertThat;
import static org.hamcrest.Matchers.instanceOf;

/**
 * Unit test for the MatchRequest class
 */
public class MatchRequestsTest
{
    private MatchRequests matchRequests;

    @BeforeEach
    public void init()
    {
        matchRequests = new MatchRequests();
    }

    @Test
    void InvestmentRequestToBeDefined()
    {
        assertThat(matchRequests, instanceOf(MatchRequests.class));
    }

}
