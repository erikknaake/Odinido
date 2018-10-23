package nl.erikruud;

public class AntwoordOpenVraag {

    private String tekst;

    public AntwoordOpenVraag(String tekst) {
        this.tekst = tekst;
    }

    /**
     * Controleert of het antwoord op een open vraag goed is
     * @param gv het gegeven antwoord
     * @return of het antwoord goed is
     */
    public boolean isAntwoordJuist(GegevenAntwoord gv){
        return tekst.equals(gv.getGegevenAntwoord());
    }
}
