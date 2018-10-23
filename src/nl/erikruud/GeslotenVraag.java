package nl.erikruud;

import java.util.ArrayList;
import java.util.List;

public class GeslotenVraag extends Vraag {
    private AntwoordGeslotenVraag goedAntwoordGeslotenVraag;
    private List<AntwoordGeslotenVraag> foutAntwoordGeslotenVraag;

    public AntwoordGeslotenVraag getJuistAntwoord(){
        return goedAntwoordGeslotenVraag;
    }

    public GeslotenVraag(List<ScoreVoorVraag> scoresVoorVraag, String tekst, AntwoordGeslotenVraag goedAntwoordGeslotenVraag, List<AntwoordGeslotenVraag> foutAntwoordGeslotenVraag) {
        super(scoresVoorVraag, tekst);
        this.goedAntwoordGeslotenVraag = goedAntwoordGeslotenVraag;
        this.foutAntwoordGeslotenVraag = foutAntwoordGeslotenVraag;
    }

    @Override
    public int krijgScoreVoorAntwoord(GegevenAntwoord ga) {
        AntwoordGeslotenVraag agv = getJuistAntwoord();
        if(agv.isAntwoordJuist(ga)) {
            return getHuidigeScoreModel().getScore();
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
        System.out.println(getAntwoordMogelijkheden());
    }
}
