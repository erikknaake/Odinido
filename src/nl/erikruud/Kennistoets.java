package nl.erikruud;

import java.util.Calendar;
import java.util.List;

public class Kennistoets {
    private String toetsCode;
    private String toetsTitel;
    private List<TijdsbonusVoorKennistoets> tijdsbonussenVoorKennistoets;
    private List<VraagInKennistoets> vragenInKennistoets;

    public Kennistoets() {
    }

    public Kennistoets(String toetsCode, String toetsTitel, List<TijdsbonusVoorKennistoets> tijdsbonussenVoorKennistoets, List<VraagInKennistoets> vragenInKennistoets) {
        this.toetsCode = toetsCode;
        this.toetsTitel = toetsTitel;
        this.tijdsbonussenVoorKennistoets = tijdsbonussenVoorKennistoets;
        this.vragenInKennistoets = vragenInKennistoets;
    }

    public int getTijdsbonus(Calendar tijdOver){
        for(TijdsbonusVoorKennistoets tbvk : tijdsbonussenVoorKennistoets) {
            if(tbvk.isHuidigeTijdsBonnus())
                return tbvk.getbonus(tijdOver);
        }
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
        Vraag ov = vragenInKennistoets.get(vraagnr).getVraag();
        ov.print();
    }

    public List<VraagInKennistoets> getVragenInKennistoets() {
        return vragenInKennistoets;
    }

}
