package com.vodafone.bowling.tool;

import com.vodafone.bowling.model.FinalScore;
import com.vodafone.bowling.model.FrameScore;
import org.junit.Test;

import java.util.ArrayList;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertNull;

public class BowlingScoreParserTest {
    @Test
    public void shouldReturnTenFrameScoresAndFinalScoreGivenCompleteBowlingScoreString() {
        ArrayList result = BowlingScoreParser.parse("10 10 10 10 10 10 10 10 10 10 10 10");

        assertEquals(2, result.size());
        assertEquals(10, ((FrameScore[]) result.get(0)).length);
        assertEquals(10, ((FinalScore) result.get(1)).firstScore());
        assertEquals(20, ((FinalScore) result.get(1)).score());
    }

    @Test
    public void shouldReturnTenFrameScoresAndFinalScoreGivenCompleteBowlingButNotAllTensScoreString() {
        ArrayList result = BowlingScoreParser.parse("7 2 10 8 1 10 4 4 10 10 10 10 10 10 10");

        assertEquals(2, result.size());
        assertEquals(10, ((FrameScore[]) result.get(0)).length);
        assertEquals(10, ((FinalScore) result.get(1)).firstScore());
        assertEquals(20, ((FinalScore) result.get(1)).score());
    }

    @Test
    public void shouldReturnTenFrameScoresAndFinalScoreGivenCompleteBowlingWithOneAdditionalFinalScore() {
        ArrayList result = BowlingScoreParser.parse("7 2 10 8 1 10 4 4 10 10 10 10 10 9");

        assertEquals(2, result.size());
        assertEquals(10, ((FrameScore[]) result.get(0)).length);
        assertEquals(9, ((FinalScore) result.get(1)).firstScore());
        assertEquals(9, ((FinalScore) result.get(1)).score());
    }

    @Test
    public void shouldReturnTenFrameScoresAndFinalScoreGivenCompleteBowlingWithoutFinalScore() {
        ArrayList result = BowlingScoreParser.parse("7 2 10 8 1 4 4 10");

        assertEquals(2, result.size());
        assertEquals(5, ((FrameScore[]) result.get(0)).length);
        assertNull(result.get(1));
    }
}