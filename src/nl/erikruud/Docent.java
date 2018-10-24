package nl.erikruud;


import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.*;

/**
 * Een docent is een actor binnen het systeem die kennistoetsen en lokalen beheerd en kennistoetsen kan starten in
 * lokalen die aan hem of haar toebehoren
 */
public class Docent {
    private String email;
    private String voornaam;
    private String achternaam;
    private String wachtwoord;
    private String docentCode;
    private boolean isPremiumDocent;
    private List<Lokaal> lokalen;
    private List<Kennistoets> kennistoetsen;

    /**
     * Maakt een nieuwe docent aan en initialiseert de benodigde variabelen
     */
    public Docent() {
        lokalen = new ArrayList<>();
        kennistoetsen = new ArrayList<>();
    }

//    public Docent(int lokaalNummer){
//        this();
//        Lokaal l = new Lokaal(lokaalNummer);
//        lokalen.add(l);
//    }

    /**
     * Maakt een nieuwe docent aan op basis van de verstrekte informatie
     * @param email het email adres van de docent
     * @param voornaam de voornaam van de docent
     * @param achternaam de achternaam van de docent
     * @param wachtwoord het wachtwoord van de dccent
     * @param docentCode de code van de docent
     * @param isPremiumDocent of de docent een premium account heeft of niet
     * @param lokalen een overzicht van lokalen dat aan de docent toebehoort
     * @param kennistoetsen een overzicht van kennistoetsen dat aan de docent toebehoort
     */
    public Docent(String email, String voornaam, String achternaam, String wachtwoord, String docentCode, boolean isPremiumDocent, List<Lokaal> lokalen, List<Kennistoets> kennistoetsen) {
        this();
        this.email = email;
        this.voornaam = voornaam;
        this.achternaam = achternaam;
        this.wachtwoord = wachtwoord;
        this.docentCode = docentCode;
        this.isPremiumDocent = isPremiumDocent;
        this.lokalen = lokalen;
        this.kennistoetsen = kennistoetsen;
    }

    /**
     * Stelt een docent in staat op elk gewenst moment een overzicht met uitslagen van een kennistoetsuitvoering op
     * te stellen
     * @param lokaalNummer nummer van het lokaal om het overzicht van op te halen
     * @return Overzicht in de vorm van een string
     */
    public String haalUitslagOverzichtOp(int lokaalNummer){
        Lokaal l = getLokaal(lokaalNummer);
        if(l == null) {
            return "";
        }
        return l.getUitslagOverzicht();
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
        int input = Integer.MAX_VALUE;
        do {
            System.out.println("Geef een lokaal op");
            for(Lokaal l : lokalen) {
                System.out.println(l.getLokaalNummer());
            }
            Scanner s = new Scanner(System.in);
            try {
                input = s.nextInt();
            }
            catch (InputMismatchException e) { }
        } while (input > lokalen.size());
        return lokalen.get(input - 1);
    }

    /**
     * Laat een docent de maximale tijd bepalen dat een student over een kennistoetsuitvoering mag doen.
     * @return de maximale tijd dat een student over de kennistoets mag doen
     */
    public Calendar selecteerMaximumDeelnameDuur(){
        System.out.println("Typ hoelang een student maximaal over de toets mag doen");
        return inputTijd();
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
        return lokalen.get(0);
    }

    /**
     * Stelt de docent in staat te bepalen hoe lang een kennistoetsuitvoering open staat
     * @return het moment waarop toegang tot de kennistoetsuitvoering wordt afgesloten
     */
    public Calendar selecteerTijdOpen(){
        System.out.println("Type de tijd dat de toets open blijft staan");
        return inputTijd();
    }

    /**
     * Vraagt een tijd op via console input
     * @return Calendar representatie van tijd
     */
    private Calendar inputTijd() {
        SimpleDateFormat dateFormat = new SimpleDateFormat("hh:mm:ss");
        Scanner s = new Scanner(System.in);
        Calendar cal = Calendar.getInstance();
        ParseException ex = null;
        do{
            ex = null;
            try {
                cal.setTime(dateFormat.parse(s.next()));
            } catch (ParseException e) {
                ex = e;
                System.out.println("Dat is geen correcte tijd");
            }
        }
        while(ex != null);
        return cal;
    }

    /**
     * Voegt een nieuw lokaal toe aan de lijst met beschikbare lokalen voor een docent met als lokaalnummner
     * het opgegeven lokaalnummer
     * @param lokaalNummer het lokaalnummer voor het nieuwe lokaal
     */
    public void registreerLokaal(int lokaalNummer) {
        Lokaal l = new Lokaal(lokaalNummer);
        addLokaal(l);
        System.out.println("Lokaal is toegevoegd");
    }

    /**
     * Voegt een lokaal toe aan de lijst met beschikbare lokalen van een docent
     * @param l het toe te voegen lokaal
     */
    public void addLokaal(Lokaal l){
        lokalen.add(l);
    }

    /**
     * Start een kennistoets in een van de lokalen van de docent
     * @param toetscode de code van de te starten kennistoets
     */
    public void startKennistoets(String toetscode){
        Kennistoets k = getKennistoets(toetscode);
        Lokaal l;
        if(isPremiumDocent) {
            l = selecteerLokaal();
        }
        else {
            l = getStandaardLokaal();
            System.out.println("Toets wordt geopend in lokaal: " + l.getLokaalNummer());
        }
        Calendar t1 = selecteerTijdOpen();
        Calendar t2 = selecteerMaximumDeelnameDuur();
        l.startKennistoets(k, t1, t2);
    }

    /**
     * Geeft de code behorende bij de betreffende instantie van een docent terug
     * @return de docentcode behorende aan de docent
     */
    public String getDocentcode(){
        return docentCode;
    }

    /**
     * Geeft inzage in de kennistoetsen die aan de docent toebehoren
     * @return de kennistoetsen van de docent
     */
    public List<Kennistoets> getKennistoetsen() {
        return kennistoetsen;
    }

    /**
     * Geeft inzage in de lokalen die aan de docent toebehoren
     * @return de lokalen van de docent
     */
    public List<Lokaal> getLokalen() {
        return lokalen;
    }

    public boolean isPremiumDocent() {
        return isPremiumDocent;
    }
}
