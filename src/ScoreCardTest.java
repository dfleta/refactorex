

public class ScoreCardTest {

    private ScoreCard scoreCard = null;


    /* -------------- TESTING BEHAVIOURS -------------------*/

    @BeforeEach
    public void init() {
        scoreCard = new ScoreCard();
    }

    @Test
    public void getScoreCardTest() {
        ScoreCard scoreCard = new ScoreCard("XXXXXXXXXXXX");
        assertEquals("XXXXXXXXXXXX", scoreCard.getScoreCard());
    }

    @Test
    public void computeStrikeTest() {
        assertEquals(10, scoreCard.computeStrike('X'));
        assertEquals(0, scoreCard.computeStrike('9'));
    }

    @Test
    public void computeSpareTest() {
        assertEquals(10, scoreCard.computeSpare('/'));
        assertEquals(10, scoreCard.computeSpare('/'));
    }

    @Test
    public void computePinsTest() {
        assertEquals(0, scoreCard.computePins('-'));
        assertEquals(5, scoreCard.computePins('5'));
        assertEquals(9, scoreCard.computePins('9'));
        /*for (Integer i = 1; i <= 9; i++) {
            assertEquals(i.intValue(), scoreCard.computePins(i));*/
    }

    @Test
    public void calculateScoreTest() {
        String punctuation = "XXXXXXXXXXXX";
        int totalScore = scoreCard.bowlingCardScore(punctuation);
        assertEquals(300, totalScore);
    }

    @Test
    public void calculateScoreTest2() {
        String punctuation = "12345123451234512345";
        int totalScore = scoreCard.bowlingCardScore(punctuation);
        assertEquals(60, totalScore);
    }

    @Test
    public void calculateScoreTest3() {
        String punctuation = "5/5/5/5/5/5/5/5/5/5/5";
        int totalScore = scoreCard.bowlingCardScore(punctuation);
        assertEquals(150, totalScore);
    }

    @Test
    public void calculateScoreTest4() {
        String punctuation = "9-9-9-9-9-9-9-9-9-9-";
        int totalScore = scoreCard.bowlingCardScore(punctuation);
        assertEquals(90, totalScore);
    }

    @Test
    public void calculateScoreTest5() {
        String punctuation = "XXX454/9/1-XX5/X";
        int totalScore = scoreCard.bowlingCardScore(punctuation);
        assertEquals(178, totalScore);
    }

    @Test
    public void calculateScoreTest6() {
        String punctuation = "4/XX5/9-7/X5/8/1/X";
        int totalScore = scoreCard.bowlingCardScore(punctuation);
        assertEquals(182, totalScore);
    }

    @Test
    public void calculateScoreTest7() {
        String punctuation = "XXXX81-/9/5/XX5X";
        int totalScore = scoreCard.bowlingCardScore(punctuation);
        assertEquals(220, totalScore);
    }

    @Test
    public void calculateScoreTest8() {
        String punctuation = "5/9-719/XX9/271/XX9";
        int totalScore = scoreCard.bowlingCardScore(punctuation);
        assertEquals(175, totalScore);
    }

    @Test
    // ESTE CASO TEST FALLA
    public void calculateScoreTest9() {
        String punctuation = "1/27XXX-/X3/X11";
        int totalScore = scoreCard.bowlingCardScore(punctuation);
        assertEquals(165, totalScore);
    }
}
