package nl.erikruud;

import java.util.List;

public class GeslotenVraag implements Vraag {
    private String tekst;
    private AntwoordGeslotenVraag goedAntwoordGeslotenVraag;
    private List<AntwoordGeslotenVraag> foutAntwoordGeslotenVraag;

    public AntwoordGeslotenVraag getJuistAntwoord(){
        //TODO
        return new AntwoordGeslotenVraag();
    }

    @Override
    public ScoreVoorVraag getHuidigeScoreModel() {
        return null;
    }

    @Override
    public int krijgScoreVoorAntwoord(GegevenAntwoord ga) {
        return 0;
    }

    @Override
    public Score geefScore() {
        return null;
    }
}
