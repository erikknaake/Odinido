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
    public String getToetscode(){
        return toetsCode;
    }
    public String getTitel(){
        return toetsTitel;
    }
    public void stelVraag(int vraagnr){
        //TODO
    }
}
