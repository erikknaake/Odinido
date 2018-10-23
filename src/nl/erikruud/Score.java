package nl.erikruud;

public class Score {
    private int score;


    public Score(int score) {
        this.score = score;
    }

    /**
     * Geeft een cijfer dat een score representeert
     * @return een score
     */
    public int getScore(){
        return score;
    }
}
