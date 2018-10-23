package nl.erikruud;

public class VraagInKennistoets {
    private int volgnr;
    private Vraag vraag;

    public int krijgScoreVoorAntwoord (GegevenAntwoord antwoord){
        return vraag.krijgScoreVoorAntwoord(antwoord);
    }

    /**
     * Haalt de vraag op behorende bij deze instantie
     * @return een vraag die hoort bij een kennistoets
     */
    public Vraag getVraag() {
        return vraag;
    }

    /**
     * Geeft de score die behaald is voor de vraag
     * @return Score die door een speciefieke deelnemer is behaald voor deze gestelde vraag.
     */
    public int geefScore() {
        return vraag.geefScore();
    }
}
