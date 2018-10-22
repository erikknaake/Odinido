package nl.erikruud;


import java.util.ArrayList;
import java.util.Calendar;
import java.util.List;

public class Docent {
    private String email;
    private String voornaam;
    private String achternaam;
    private String wachtwoord;
    private String docentCode;
    private boolean isPremiumDocent;
    private List<Lokaal> lokalen;
    private List<Kennistoets> kennistoetsen;

    public Docent(){
        isPremiumDocent = false;
        lokalen = new ArrayList<>();
        kennistoetsen = new ArrayList<>();
    }

    /**
     * Stelt een docent in staat op elk gewenst moment een overzicht met uitslagen van een kennistoetsuitvoering op
     * te stellen
     */
    public void haalUitslagOverzichtOp(){
        //TODO
    }

    /**
     * Haalt een lokaal op, op basis van een lokaalnummer
     * @param lokaalNummer het nummer van het op te halen lokaal
     * @return het opgehaalde lokaal
     */
    public Lokaal getLokaal(int lokaalNummer){
        for(Lokaal l : lokalen){
            if(l.getLokaalNummer() == lokaalNummer){
                return l;
            }
        }
        return null;
    }

    /**
     * Laat een docent een lokaal selecteren
     * @return het geselecteerde lokaal
     */
    public Lokaal selecteerLokaal(){
        //TODO
        return new Lokaal(0);
    }

    /**
     * Laat een docent de maximale tijd bepalen dat een student over een kennistoetsuitvoering mag doen.
     * @return de maximale tijd dat een student over de kennistoets mag doen
     */
    public Calendar selecteerMaximumDeelnameDuur(){
        //TODO
        return Calendar.getInstance();
    }

    /**
     * Haalt een kennistoets op, op basis van een toetscode
     * @param toetscode de op te halen kennistoets zijn toetscode
     * @return de opgehaalde kennistoets
     */
    public Kennistoets getKennistoets(String toetscode){
        for(Kennistoets k : kennistoetsen){
            if(k.getToetscode().equals(toetscode)){
                return k;
            }
        }
        return null;
    }

    /**
     * Geeft een standaard lokaal terug voor een basic docent
     * @return een lokaal
     */
    public Lokaal getStandaardLokaal(){
        //TODO
        return new Lokaal(0);
    }

    /**
     * Stelt de docent in staat te bepalen hoe lang een kennistoetsuitvoering open staat
     * @return het moment waarop toegang tot de kennistoetsuitvoering wordt afgesloten
     */
    public Calendar selecteerTijdOpen(){
        //TODO
        return Calendar.getInstance();
    }

    public void registreerLokaal(int lokaalNummer){
        //TODO
    }
    public void addLokaal(Lokaal l){
        //TODO
    }
    public String haalUitslagOverzichtOp(int lokaalNummer){
        //TODO
        return new String();
    }
    public void startKennistoets(String docentcode,String toetscode){
        //TODO
    }

    /**
     * Geeft de code behorende bij de betreffende instantie van een docent terug
     * @return de docentcode behorende aan de docent
     */
    public String getDocentcode(){
        return docentCode;
    }
}
