package nl.erikruud;

import java.util.ArrayList;
import java.util.Calendar;
import java.util.List;

public class GesteldeVraag {
    private boolean isJuistAntwoord;
    private int volgnr;
    private VraagInKennistoets vraagInKennistoets;
    private GegevenAntwoord gegevenAntwoord;

    public int getScore(){
        return vraagInKennistoets.geefScore();
    }
    public void GesteldeVraag(Vraag v, boolean isOpenvraag){
        //TODO
    }
    public int krijgScoreVoorAntwoord(GegevenAntwoord antwoord){
        return vraagInKennistoets.krijgScoreVoorAntwoord(antwoord);
    }
    public List<AntwoordGeslotenVraag> getAntwoordMogelijkheden(){
        //TODO
        return new ArrayList<>();
    }

    /**
     * Controleerd of de vraag een open vraag is
     * @return True als de vraag een open vraag is
     */
    public boolean isOpenVraag() {
        return vraagInKennistoets.getVraag() instanceof OpenVraag;
    }
}
