package nl.erikruud;

/**
 * Een antwoord op een open vraag is een antwoord dat behoort bij een open vraag
 */
public class AntwoordOpenVraag {

    private String tekst;

    /**
     * Maakt een nieuwe aantwoord op een open vraag op basis van de meegeleverde informatie
     * @param tekst het antwoord op een open vraag
     */
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
