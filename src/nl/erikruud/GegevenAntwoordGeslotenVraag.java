package nl.erikruud;

/**
 * Een gegeven antwoord op een gesloten vraag is een antwoord op een gesloten vraag gegeven door een student
 */
public class GegevenAntwoordGeslotenVraag implements GegevenAntwoord {
    private String gegevenAntwoord;
    private AntwoordGeslotenVraag antwoordGeslotenVraag;

    @Override
    public void setGegevenAntwoord(String antwoord) {
        gegevenAntwoord = antwoord;
    }

    @Override
    public String getGegevenAntwoord() {
        return gegevenAntwoord;
    }


}
