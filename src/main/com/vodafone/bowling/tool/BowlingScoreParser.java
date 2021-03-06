package com.vodafone.bowling.tool;

import com.vodafone.bowling.exception.InvalidInputException;
import com.vodafone.bowling.model.FinalScore;
import com.vodafone.bowling.model.FrameScore;

import java.util.ArrayList;

import static com.vodafone.bowling.model.Score.MAX_SCORE_PER_FRAME;
import static com.vodafone.bowling.tool.ScoreStringValidator.validate;
import static java.lang.Integer.valueOf;

public class BowlingScoreParser {

    public static final int NUMBER_OF_FRAMES = 10;
    public static final String SPACE_SEPARATED = "\\s+";

    public static ArrayList<Object> parse(String bowlingScoreString) {
        ArrayList<Object> result = new ArrayList<>();

        ArrayList<FrameScore> frameScores = new ArrayList<>();
        FinalScore finalScore = null;

        try {
            validate(bowlingScoreString);
        } catch (InvalidInputException e) {
            System.out.println(e.getMessage());
        }

        String[] scores = bowlingScoreString.split(SPACE_SEPARATED);

        for (int i = 0, j = 0; i < scores.length; j++) {
            if (j > NUMBER_OF_FRAMES - 1) {
                finalScore = (i > scores.length - 2) ?
                        new FinalScore(valueOf(scores[i])) :
                        new FinalScore(valueOf(scores[i]), valueOf(scores[i + 1]));
                break;
            }
            if (valueOf(scores[i]) == MAX_SCORE_PER_FRAME) {
                frameScores.add(new FrameScore(valueOf(scores[i])));
                i++;
                continue;
            }
            frameScores.add(new FrameScore(valueOf(scores[i]), valueOf(scores[i + 1])));
            i += 2;
        }

        result.add(frameScores.toArray());
        result.add(finalScore);

        return result;
    }
}
