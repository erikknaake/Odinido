package nl.erikruud;

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
