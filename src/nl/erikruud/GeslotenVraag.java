package nl.erikruud;

import java.util.List;

public class GeslotenVraag extends Vraag {
    private AntwoordGeslotenVraag goedAntwoordGeslotenVraag;
    private List<AntwoordGeslotenVraag> foutAntwoordGeslotenVraag;

    public AntwoordGeslotenVraag getJuistAntwoord(){
        //TODO
        return new AntwoordGeslotenVraag();
    }

    @Override
    public int krijgScoreVoorAntwoord(GegevenAntwoord ga) {
        AntwoordGeslotenVraag agv = getJuistAntwoord();
        if(agv.isAntwoordJuist(ga)) {
            return getHuidigeScoreModel().getScore();
        }
        return 0;
    }
}
