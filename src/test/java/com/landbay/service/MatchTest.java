package com.landbay.service;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static org.hamcrest.MatcherAssert.assertThat;
import static org.hamcrest.Matchers.instanceOf;

/**
 * Unit test for the Match class
 */
public class MatchTest
{
    private Match match;

    @BeforeEach
    public void init()
    {
        match = new Match();
    }

    @Test
    void MatchRequestsToBeDefined()
    {
        assertThat(match, instanceOf(Match.class));
    }

}
