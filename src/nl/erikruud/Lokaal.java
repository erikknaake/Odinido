package nl.erikruud;

import java.util.Calendar;

/**
 * Een lokaal is een ruimte waarin een kennistoets is uit te voeren en behoort toe aan een enkele docent
 */
public class Lokaal {
    private int lokaalNummer;
    private Toetsuitvoering toetsuitvoering;

    /**
     * Maakt een nieuw lokaal aan op basis van de meegegeven informatie
     * @param lokaalNummer het lokaalnummer voor het lokaal
     */
    public Lokaal(int lokaalNummer){
        this.lokaalNummer = lokaalNummer;
    }

    /**
     * Het het uitslagoverzicht op dat behoort tot de toetsuitvoering die op het moment plaatsvindt in het lokaal
     * @return het uitslagoverzicht van de toetsuitvoering die op dit moment plaatsvindt
     */
    public String getUitslagOverzicht(){
        return toetsuitvoering.getUitslagOverzicht();
    }

    /**
     * Start de uitvoering van een kennistoets in het lokaal
     * @param k de kennistoets die gestart wordt in het lokaal
     * @param t1 de tijd dat de toets in dit lokaal open staat
     * @param t2 de tijd die een student krijt na aanmelding om de toets te maken
     */
    public void startKennistoets(Kennistoets k, Calendar t1, Calendar t2){
        Toetsuitvoering tu = new Toetsuitvoering(k, t1, t2);
        voegToetsuitvoeringToe(tu);
    }

    /**
     * Voegt een deelnemer toe aan de uitvoering van een kennistoets in dit lokaal
     * @param naam de naam van de student die deel wil nemen aan de toets in dit lokaal
     */
    public void voegDeelnemerToe(String naam) {
        if(toetsuitvoering != null)
            toetsuitvoering.voegDeelnemerToe(naam);
        else
            System.out.println("Lokaal staat niet open");
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
