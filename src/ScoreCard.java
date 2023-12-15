
public class ScoreCard {

    // Properties of the class //

    private int strike = 10;
    private int spare = 10;
    private int zero = 0;
    private String scoreCard;
    private int totalScore;
    private String pins = "-123456789";

    // Constructor //

    public ScoreCard() {
        this.scoreCard = "";
    }

    public ScoreCard(String scoreCard) {
        this.scoreCard = scoreCard;
    }

    // Setters and getters of the class //

    public String getScoreCard() {
        return scoreCard;
    }

    public int getTotalScore() {
        return totalScore;
    }

    // Behaviours //

    public boolean normalRoll(char roll) {
        if (roll != 'X' && roll != '/') {
            return true;
        } else {
            return false;
        }
    }

    public int computePins(char pin) {
        return pins.indexOf(pin);
    }

    public  boolean strike(char strike) {
        if (strike == 'X') {
            return true;
        } else {
            return false;
        }
    }

    public int computeStrike(char strike) {
        if (strike == 'X') {
            return this.strike;
        } else {
            return this.zero;
        }
    }

    public  boolean spare(char spare) {
        if (spare == '/') {
            return true;
        } else {
            return false;
        }
    }

    public int computeSpare(char spare) {
        if (spare == '/') {
            return this.spare;
        } else {
            return this.zero;
        }
    }

    public void sumTotalScore(int score) {
        totalScore = totalScore + score;
    }

    public int bowlingCardScore(String scoreCard) {

        for (int roll = 0; roll < scoreCard.length(); roll++) {
            char result = scoreCard.charAt(roll);

            try {
                // Here we check if the result of the actual roll are some normal pins.
                if (normalRoll(result)) {
                    if (roll == 20 && scoreCard.charAt(19) == '/') {
                        break;
                    } else if (roll == scoreCard.length() - 2 && scoreCard.charAt(roll - 1) == 'X') {
                        break;
                    } sumTotalScore(computePins(result));
                }
                // Here we check if the result of the actual roll is a Spare.
                if (spare(result)) {
                    char nextResult = scoreCard.charAt(roll + 1);
                    char previousResult = scoreCard.charAt(roll - 1);
                    if (!strike(nextResult)) {
                        sumTotalScore(computeSpare(result) + computePins(nextResult) - computePins(previousResult));
                    } else if (strike(nextResult)) {
                        sumTotalScore(computeSpare(result) + computeStrike(nextResult) - computePins(previousResult));
                    }
                }
                // Here we check if the result of the actual roll is a Strike.
                else if (strike(result)) {
                    char nextResult = scoreCard.charAt(roll + 1);
                    char nextResult2 = scoreCard.charAt(roll + 2);
                    if (strike(nextResult) && strike(nextResult2)) {
                        sumTotalScore(computeStrike(result) * 3);
                    }
                    else if (strike(nextResult) && !strike(nextResult2)) {
                        sumTotalScore((computeStrike(result) * 2) + computePins(nextResult2));
                    }
                    else if (normalRoll(nextResult) && strike(nextResult2)) {
                        sumTotalScore(computePins(nextResult) + computeStrike(result) * 2);
                    }
                    else if (normalRoll(nextResult) && spare(nextResult2)) {
                        sumTotalScore(computeStrike(result) + computeSpare(nextResult2));
                    }
                    else if (normalRoll(nextResult) && normalRoll(nextResult2)) {
                        sumTotalScore(computeStrike(result) + computePins(nextResult) + computePins(nextResult2));
                    }
                }
            } catch (IndexOutOfBoundsException e) {
                return totalScore;
            }
        } return totalScore;
    }
}
