package nl.erikruud;

import java.util.ArrayList;
import java.util.Calendar;
import java.util.List;

public class GesteldeVraag {
    private boolean isJuistAntwoord;
    private int volgnr;
    private VraagInKennistoets vraagInKennistoets;
    private GegevenAntwoord gegevenAntwoord;

    public int getBonus(Calendar tijd){
        //TODO
        return 0;
    }
    public void GesteldeVraag(Vraag v, boolean isOpenvraag){
        //TODO
    }
    public int krijgScoreVoorAntwoord(GegevenAntwoord antwoord){
        //TODO
        return 0;
    }
    public List<AntwoordGeslotenVraag> getAntwoordMogelijkheden(){
        //TODO
        return new ArrayList<>();
    }
}
