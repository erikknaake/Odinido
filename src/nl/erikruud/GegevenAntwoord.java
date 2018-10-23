package nl.erikruud;

/**
 * Een gegeven antwoord is het antwoord dat is gegeven op een vraag
 */
public interface GegevenAntwoord {
    /**
     * Slaat het gegeven antwoord op
     * @param antwoord het door de student gegeven antwoord
     */
    void setGegevenAntwoord(String antwoord);

    /**
     * Haalt het antwoord op dat is gegeven op een vraag
     * @return het gegeven antwoord op een vraag
     */
    String getGegevenAntwoord();
}
