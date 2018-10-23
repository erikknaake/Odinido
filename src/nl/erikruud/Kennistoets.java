package nl.erikruud;

import java.util.Calendar;
import java.util.List;

public class Kennistoets {
    private String toetsCode;
    private String toetsTitel;
    private TijdsbonusVoorKennistoets tijdsbonusVoorKennistoets;
    private List<VraagInKennistoets> vragenInKennistoets;

    public int getTijdsbonus(Calendar tijd){
        //TODO
        return 0;
    }

    /**
     * Geeft de toetscode behorende aan een kennistoets object
     * @return de toetscode behorende bij de kennistoets
     */
    public String getToetscode(){
        return toetsCode;
    }

    /**
     * Geeft de titel behorende aan een kennistoets object
     * @return de titel behorende bij de kennistoets
     */
    public String getTitel(){
        return toetsTitel;
    }

    /**
     *
     * @param vraagnr
     */
    public void stelVraag(int vraagnr){
        //TODO
        Vraag ov = vragenInKennistoets.get(vraagnr).getVraag();
    }

}
