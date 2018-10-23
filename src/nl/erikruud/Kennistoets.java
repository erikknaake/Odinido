package nl.erikruud;

import java.util.Calendar;
import java.util.List;

/**
 * Een kennistoets is een toets die door een docent gemaakt is en vormt een verzameling van vragen die in een
 * uitvoering van een kennistoets kunnen worden gesteld
 */
public class Kennistoets {
    private String toetsCode;
    private String toetsTitel;
    private List<TijdsbonusVoorKennistoets> tijdsbonussenVoorKennistoets;
    private List<VraagInKennistoets> vragenInKennistoets;

    /**
     * Maakt een nieuwe kennistoets aan op basis van de aangeleverde informatie
     * @param toetsCode de toetscode behorende bij de kennistoets
     * @param toetsTitel de titel behorende bij de kennistoets
     * @param tijdsbonussenVoorKennistoets de tijdsbonussen behorende bij de kennistoets
     * @param vragenInKennistoets de vragen behorende bij de kennistoets
     */
    public Kennistoets(String toetsCode, String toetsTitel, List<TijdsbonusVoorKennistoets> tijdsbonussenVoorKennistoets, List<VraagInKennistoets> vragenInKennistoets) {
        this.toetsCode = toetsCode;
        this.toetsTitel = toetsTitel;
        this.tijdsbonussenVoorKennistoets = tijdsbonussenVoorKennistoets;
        this.vragenInKennistoets = vragenInKennistoets;
    }

    /**
     * Bepaald de bonus die gegeven wordt als er tijd over is tijdens de uitvoering van de kennistoets
     * @param tijdOver de tijd die over is
     * @return de bonus
     */
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
     * Toont een vraag die behoort aan de kennistoets op het scherm
     * @param vraagnr het nummer van de vraag in de verzameling met vragen
     */
    public void stelVraag(int vraagnr){
        Vraag ov = vragenInKennistoets.get(vraagnr).getVraag();
        ov.print();
    }

    /**
     * Haalt de vragen op die deel uitmaken van een kennistoets
     * @return de vragen die deel uitmaken van de kennistoets
     */
    public List<VraagInKennistoets> getVragenInKennistoets() {
        return vragenInKennistoets;
    }

}
