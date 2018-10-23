package nl.erikruud;

/**
 * Een score is een cijfer waaraan prestatiewaarde wordt toegekend
 */
public class Score {
    private int score;

    /**
     * Maakt een nieuwe score aan
     * @param score het cijfer dat toebehoort aan de score
     */
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
