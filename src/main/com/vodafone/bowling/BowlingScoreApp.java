package com.vodafone.bowling;

import com.vodafone.bowling.model.FinalScore;
import com.vodafone.bowling.model.FrameScore;

import java.io.IOException;
import java.util.ArrayList;
import java.util.Scanner;

import static com.vodafone.bowling.tool.BowlingScoreParser.parse;
import static java.util.Arrays.copyOf;

public class BowlingScoreApp {

    public static void main(String[] args) throws IOException {
        Scanner in = new Scanner(System.in);
        System.out.println("Enter a string of space separated numbers (Note: each number is between 0 and 10)");
        String bowlingScoreString = in.nextLine();
        in.close();

        ArrayList result = parse(bowlingScoreString);
        Object[] frameScoreObjects = (Object[]) result.get(0);
        FrameScore[] frameScores = copyOf(frameScoreObjects, frameScoreObjects.length, FrameScore[].class);

        BowlingScoring bowlingScoring = (result.get(1) == null) ?
                new BowlingScoring(frameScores) :
                new BowlingScoring(frameScores, (FinalScore) result.get(1));

        System.out.println(bowlingScoring.accumulateScores());
    }
}
