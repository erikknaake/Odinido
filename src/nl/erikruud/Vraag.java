package nl.erikruud;

import java.util.List;

public abstract class Vraag {
    private List<ScoreVoorVraag> scoresVoorVraag;
    private String tekst;


    public Vraag(List<ScoreVoorVraag> scoresVoorVraag, String tekst) {
        this.scoresVoorVraag = scoresVoorVraag;
        this.tekst = tekst;
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
        ScoreVoorVraag dvv = getHuidigeScoreModel();
        if(getHuidigeScoreModel() != null)
            return getHuidigeScoreModel().getScore();
        else {
            System.out.println("Kon geen beoordelingsmodel vinden");
            return 0;
        }
    }

    public abstract List<AntwoordGeslotenVraag> getAntwoordMogelijkheden();

    public void print() {
        System.out.println(tekst);
        printExtra();
    }

    public void printExtra() {}
}
