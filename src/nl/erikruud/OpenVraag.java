package nl.erikruud;

import java.util.ArrayList;
import java.util.List;

public class OpenVraag implements Vraag {
    private String tekst;
    private int antwoordMogelijkHeidIndex;

    public OpenVraag(){
        this.antwoordMogelijkHeidIndex = 0;
    }

    public List<AntwoordOpenVraag> getAntwoordMogelijkehid(int antwoordIndex){
        //TODO
        return new ArrayList<>();
    }

    public void resetAntwoordIndex(){
        //TODO
    }

    public void verhoogAntwoordMogelijkheidIndex(){
        //TODO
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
