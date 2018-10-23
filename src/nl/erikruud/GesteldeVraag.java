package nl.erikruud;

import java.util.List;

/**
 * Een gestelde vraag is een vraag die aan een deelnemer van een kennistoets gesteld wordt
 */
public class GesteldeVraag {
    private boolean isJuistAntwoord;
    private int volgnr;
    private VraagInKennistoets vraagInKennistoets;
    private GegevenAntwoord gegevenAntwoord;

    /**
     * Maakt een nieuwe gestelde vraag aan op basis van de meegegeven informatie
     * @param vik de vraag die gesteld wordt
     */
    public GesteldeVraag(VraagInKennistoets vik){
        vraagInKennistoets = vik;
    }

    /**
     * Haalt de score op die hoort bij een vraag in een kennistoets
     * @return de score die hoort bij een vraag
     */
    public int getScore(){
        return vraagInKennistoets.geefScore();
    }

    /**
     * Haalt de score op die behoort bij een gegeven antwoord op een vraag
     * @param antwoord het gegeven antwoord
     * @return de score die hoort bij het gegeven antwoord
     */
    public int krijgScoreVoorAntwoord(GegevenAntwoord antwoord){
        return vraagInKennistoets.krijgScoreVoorAntwoord(antwoord);
    }

    /**
     * Haalt de anwoordmogelijkheden op behorende bij een gesloten vraag
     * @return de antwoordmogelijkheden bij een gesloten vraag
     */
    public List<AntwoordGeslotenVraag> getAntwoordMogelijkheden(){
        return vraagInKennistoets.getAntwoordMogelijkheden();
    }

    /**
     * Controleerd of de vraag een open vraag is
     * @return True als de vraag een open vraag is
     */
    public boolean isOpenVraag() {
        return vraagInKennistoets.getVraag() instanceof OpenVraag;
    }

    /**
     * Haalt een vraag op behorende bij een kennistoets en toont die op het scherm
     */
    public void stelVraag() {
        vraagInKennistoets.getVraag().print();
    }
}
