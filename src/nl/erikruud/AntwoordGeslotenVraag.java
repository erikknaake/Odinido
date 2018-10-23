package nl.erikruud;

public class AntwoordGeslotenVraag {

    private String tekst;

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

    public String getTekst() {
        return tekst;
    }


}
