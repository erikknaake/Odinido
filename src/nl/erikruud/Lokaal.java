package nl.erikruud;

import java.util.Calendar;

public class Lokaal {
    private int lokaalNummer;
    private Toetsuitvoering toetsuitvoering;

    public Lokaal(int lokaalNummer){
        this.lokaalNummer = lokaalNummer;
    }
    public String getUitslagOverzicht(){
        //TODO
        return new String();
    }
    public void startKennistoets(Kennistoets k, Calendar t1, Calendar t2){
        Toetsuitvoering tu = new Toetsuitvoering(k, t1, t2);
        voegToetsuitvoeringToe(tu);
    }

    /**
     * Voegt een deelnemer toe aan de uitvoering van een kennistoets in dit lokaal
     * @param naam de naam van de student die deel wil nemen aan de toets in dit lokaal
     */
    public void voegDeelnemerToe(String naam) {
        toetsuitvoering.voegDeelnemerToe(naam);
    }

    /**
     * Voegt een toetsuitvoering toe aan het lokaal
     * @param tu de toetsuitvoering om toe te voegen aan het lokaal
     */
    public void voegToetsuitvoeringToe(Toetsuitvoering tu){
        toetsuitvoering = tu;
    }

    /**
     * Haalt het lokaanummer op van het betreffende lokaal
     * @return het lokaalnummer behorende aan het lokaal
     */
    public int getLokaalNummer(){
        return lokaalNummer;
    }
}
