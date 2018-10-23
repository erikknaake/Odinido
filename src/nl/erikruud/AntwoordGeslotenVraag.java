package nl.erikruud;

/**
 * Een antwoord op een gesloten vraag is een antwoord dat behoort bij een gesloten vraag
 */
public class AntwoordGeslotenVraag {

    private String tekst;

    /**
     * Maakt een nieuw antwoord op een gesloten vraag aan op basis van de meegegeven informatie
     * @param tekst het antwoord op de gesloten vraag
     */
    public AntwoordGeslotenVraag(String tekst) {
        this.tekst = tekst;
    }

    /**
     * Controleert of het antwoord op een gesloten vraag goed is
     * @param gv het gegeven antwoord
     * @return of het antwoord goed is
     */
    public boolean isAntwoordJuist(GegevenAntwoord gv){
        return tekst.equals(gv.getGegevenAntwoord());
    }

    /**
     * Haalt het antwoord op van een gesloten vraag
     * @return het antwoord op een gesloten vraag
     */
    public String getTekst() {
        return tekst;
    }


}
