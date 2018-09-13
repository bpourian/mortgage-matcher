package com.landbay.service;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static org.hamcrest.MatcherAssert.assertThat;
import static org.hamcrest.Matchers.instanceOf;

/**
 * Unit test for the MatchRequest class
 */
public class MatchRequestTest
{
    private MatchRequest matchRequest;

    @BeforeEach
    public void init()
    {
        matchRequest = new MatchRequest();
    }

    @Test
    void MatchRequestsToBeDefined()
    {
        assertThat(matchRequest, instanceOf(MatchRequest.class));
    }

}
