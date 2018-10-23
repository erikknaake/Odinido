package nl.erikruud;

import java.util.ArrayList;
import java.util.List;

/**
 * Een gesloten vraag is een vraag met een vastgesteld aantal antwoordmogelijkheden
 */
public class GeslotenVraag extends Vraag {
    private AntwoordGeslotenVraag goedAntwoordGeslotenVraag;
    private List<AntwoordGeslotenVraag> foutAntwoordGeslotenVraag;

    /**
     * Maakt een nieuwe gesloten vraag aan op basis van de meegegeven informatie
     * @param scoresVoorVraag de score die wordt toegekend bij het goed beantwoorden van de vraag
     * @param tekst de tekst van de vraag
     * @param goedAntwoordGeslotenVraag het juiste antwoord op de vraag
     * @param foutAntwoordGeslotenVraag een verzameling met foute anwoorden
     */
    public GeslotenVraag(List<ScoreVoorVraag> scoresVoorVraag, String tekst, AntwoordGeslotenVraag goedAntwoordGeslotenVraag, List<AntwoordGeslotenVraag> foutAntwoordGeslotenVraag) {
        super(scoresVoorVraag, tekst);
        this.goedAntwoordGeslotenVraag = goedAntwoordGeslotenVraag;
        this.foutAntwoordGeslotenVraag = foutAntwoordGeslotenVraag;
    }

    /**
     * Geeft het juiste antwoord op een gesloten vraag
     * @return het juiste antwoord
     */
    public AntwoordGeslotenVraag getJuistAntwoord(){
        return goedAntwoordGeslotenVraag;
    }

    @Override
    public int krijgScoreVoorAntwoord(GegevenAntwoord ga) {
        AntwoordGeslotenVraag agv = getJuistAntwoord();
        if(agv.isAntwoordJuist(ga)) {
            ScoreVoorVraag svv = getHuidigeScoreModel();
            if(getHuidigeScoreModel() != null)
                return getHuidigeScoreModel().getScore();
            else
                System.out.println("Kon geen score model laden");
        }
        return 0;
    }

    @Override
    public List<AntwoordGeslotenVraag> getAntwoordMogelijkheden() {
        List<AntwoordGeslotenVraag> mogelijkheden = new ArrayList<>(foutAntwoordGeslotenVraag);
        mogelijkheden.add(goedAntwoordGeslotenVraag);
        return mogelijkheden;
    }

    @Override
    public void printExtra() {
        int i = 0;
        for(AntwoordGeslotenVraag mogelijkheid : getAntwoordMogelijkheden()) {
            System.out.println(i + ": " + mogelijkheid.getTekst());
            i++;
        }
    }
}
