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
    protected List<Lokaal> lokalen;

    public Docent(){
        isPremiumDocent = false;
        lokalen = new ArrayList<>();
    }

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
    public Lokaal selecteerLokaal(){
        //TODO
        return new Lokaal(0);
    }
    public Calendar selecteerMaximumDeelnameDuur(){
        //TODO
        return Calendar.getInstance();
    }
    public Kennistoets getKennistoets(String toetscode){
        //TODO
        return new Kennistoets();
    }
    public Lokaal getStandaardLokaal(){
        //TODO
        return new Lokaal(0);
    }
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
     public String getDocentcode(){
        //TODO
         return new String();
     }
}
