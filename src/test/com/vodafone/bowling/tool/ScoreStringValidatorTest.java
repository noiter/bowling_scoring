package com.vodafone.bowling.tool;

import com.vodafone.bowling.exception.InvalidInputException;
import org.junit.Test;

public class ScoreStringValidatorTest {

    @Test(expected = InvalidInputException.class)
    public void shouldThrowExceptionGivenInvalidCharacterScoringString() throws InvalidInputException {
        ScoreStringValidator.validate("a 6 5 7");
    }

    @Test(expected = InvalidInputException.class)
    public void shouldThrowExceptionGivenInvalidDigitInScoringString() throws InvalidInputException {
        ScoreStringValidator.validate("11 6 5 7");
    }
}