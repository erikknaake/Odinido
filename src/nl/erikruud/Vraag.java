package nl.erikruud;

import java.util.ArrayList;
import java.util.List;

public abstract class Vraag {
    private List<ScoreVoorVraag> scoresVoorVraag;
    private String tekst;
    public Vraag() {
        scoresVoorVraag = new ArrayList<>();
    }

    public ScoreVoorVraag getHuidigeScoreModel() {
        for(ScoreVoorVraag svv : scoresVoorVraag) {
            if(svv.isHuidigeScoreBijVraag()) {
                return svv;
            }
        }
        return null;
    }

    public abstract int krijgScoreVoorAntwoord(GegevenAntwoord ga);

    public int geefScore() {
        return getHuidigeScoreModel().getScore();
    }
}
