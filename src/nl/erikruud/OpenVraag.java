package nl.erikruud;

import java.util.ArrayList;
import java.util.List;

public class OpenVraag extends Vraag {

    private int antwoordMogelijkHeidIndex;
    private List<AntwoordOpenVraag> juisteAntwoorden;

    public OpenVraag(){
        resetAntwoordIndex();
        juisteAntwoorden = new ArrayList<>();
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
