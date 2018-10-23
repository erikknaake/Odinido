package nl.erikruud;

import java.util.List;

/**
 * Een open vraag is een vraag zonder keuzemogelijkheden maar die mogelij meerdere goede antwoorden kent
 */
public class OpenVraag extends Vraag {

    private int antwoordMogelijkHeidIndex;
    private List<AntwoordOpenVraag> juisteAntwoorden;

    public OpenVraag(List<ScoreVoorVraag> scoresVoorVraag, String tekst, List<AntwoordOpenVraag> juisteAntwoorden) {
        super(scoresVoorVraag, tekst);
        resetAntwoordIndex();
        this.juisteAntwoorden = juisteAntwoorden;
    }


    public AntwoordOpenVraag getAntwoordMogelijkeheid(int antwoordIndex){
        return juisteAntwoorden.get(antwoordIndex);
    }

    public void resetAntwoordIndex(){
        antwoordMogelijkHeidIndex = 0;
    }

    public void verhoogAntwoordMogelijkheidIndex(){
        antwoordMogelijkHeidIndex++;
    }


    @Override
    public int krijgScoreVoorAntwoord(GegevenAntwoord ga) {
        resetAntwoordIndex();
        while (antwoordMogelijkHeidIndex < juisteAntwoorden.size()) {
            AntwoordOpenVraag aov = getAntwoordMogelijkeheid(antwoordMogelijkHeidIndex);
            verhoogAntwoordMogelijkheidIndex();
            if(aov.isAntwoordJuist(ga)) {
                ScoreVoorVraag svv = getHuidigeScoreModel();
                return svv.getScore();
            }
        }
        return 0;
    }

    @Override
    public List<AntwoordGeslotenVraag> getAntwoordMogelijkheden() {
        return null;
    }

}
