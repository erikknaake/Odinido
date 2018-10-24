package nl.erikruud;

import java.util.List;

/**
 * Een vraag in een kennistoets betreft een vraag die deel uitmaakt van de verzameling vragen die gezamelijk een
 * kennistoets vormen
 */
public class VraagInKennistoets {
    private int volgnr;
    private Vraag vraag;

    /**
     * Maakt een nieuwe vraag aan in een kennistoets op basis van de meegeleverde informatie
     * @param volgnr het volgnummer van de vraag binnen de kennistoets
     * @param vraag de vraag die het betreft
     */
    public VraagInKennistoets(int volgnr, Vraag vraag) {
        this.volgnr = volgnr;
        this.vraag = vraag;
    }

    /**
     * Haalt de score op die hoort bij een gegeven antwoord op een vraag
     * @param antwoord het gegeven antwoord
     * @return de behaalde score
     */
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

    /**
     * Haalt de mogelijke antwoorden op de vraag op
     * @return de mogelijke antwoorden
     */
    public List<AntwoordGeslotenVraag> getAntwoordMogelijkheden() {
        return vraag.getAntwoordMogelijkheden();
    }


    public GesteldeVraag maakGesteldeVraag() {
        return new GesteldeVraag(this);
    }
}
