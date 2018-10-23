package nl.erikruud;

/**
 * Een gegeven antwoord op een open vraag is een antwoord op een open vraag gegeven door een student
 */
public class GegevenAntwoordOpenVraag implements GegevenAntwoord {
    private String gegevenAntwoord;
    private AntwoordOpenVraag antwoordOpenVraag;

    @Override
    public void setGegevenAntwoord(String antwoord) {
        gegevenAntwoord = antwoord;
    }

    @Override
    public String getGegevenAntwoord() {
        return gegevenAntwoord;
    }
}
