Write a java application that takes a string of space separated numbers from 0 to 10 and calculates what that would be as a score in ten pin bowling.  
 
If a final score cannot be determined from the input then method should return the "current" score (i.e. assumes any remaining bowls scored 0).  
Include unit tests and post code to a publicly accessible code repository.
 
Example inputs and outputs
    "1 2 3 4" -> 10
    "9 1 9 1" -> 29
    "1 1 1 1 10 1 1" -> 18
    "10 10 10 10 10 10 10 10 10 10 10 10" -> 300

For more information, go to  http://www.bowling2u.com/trivia/game/scoring.asp


Run Application:

1 ./gradlew build

2 ./gradlew calculateScore (When executing process pauses, input score string. e.g. 1 2 3 4)