package nl.erikruud;

import java.util.ArrayList;
import java.util.Calendar;
import java.util.List;
import java.util.Scanner;

public class Odinido {
    private List<Docent> docenten;

    public Odinido() {
        List<Lokaal> lokalen1 = new ArrayList<>();
        lokalen1.add(new Lokaal(1));
        lokalen1.add(new Lokaal(2));
        List<TijdsbonusVoorKennistoets> tijdsbonussenVoorKennistoets = new ArrayList<>();
        Calendar cal1 = Calendar.getInstance(), cal2 = Calendar.getInstance();
        cal1.set(2018, Calendar.OCTOBER, 23, 16, 34);
        cal2.set(2018, Calendar.OCTOBER, 23, 16, 40);
        tijdsbonussenVoorKennistoets.add(new TijdsbonusVoorKennistoets(cal1, cal2, new Tijdsbonus(2)));
        List<Vraag> vragen = new ArrayList<>();
        List<ScoreVoorVraag> scoresVoorVraag = new ArrayList<>();
        scoresVoorVraag.add(new ScoreVoorVraag(cal1, cal2, new Score(2)));
        List<AntwoordOpenVraag> juisteAntwoorden = new ArrayList<>();
        juisteAntwoorden.add(new AntwoordOpenVraag("Om mensen bezig te houden"));
        vragen.add(new OpenVraag(scoresVoorVraag, "Waarom wordt er zoveel gemockt?", juisteAntwoorden));
        List<AntwoordGeslotenVraag> onjuisteAntwoorden = new ArrayList<>();
        onjuisteAntwoorden.add(new AntwoordGeslotenVraag("Nee"));
        onjuisteAntwoorden.add(new AntwoordGeslotenVraag("Het is heel weinig"));
        vragen.add(new GeslotenVraag(scoresVoorVraag, "Is dit te veel werk?", new AntwoordGeslotenVraag("Ja"), onjuisteAntwoorden));
        List<VraagInKennistoets> vragenInKennistoets1 = new ArrayList<>();
        vragenInKennistoets1.add(new VraagInKennistoets(1, vragen.get(0)));
        List<Kennistoets> kennistoetsen1 = new ArrayList<>();
        kennistoetsen1.add(new Kennistoets("dea", "programmeeropdracht", tijdsbonussenVoorKennistoets, vragenInKennistoets1));
        docenten = new ArrayList<>();
        Docent docent1 = new Docent("e.knaake@student.han.nl", "Erik", "Knaake", "P@ssword1", "ek", true, lokalen1, kennistoetsen1);
        docenten.add(docent1);
//        Docent docent2 = new Docent("r.hermans@student.han.nl", "Ruud", "Hermans", "root", "rh", false);
//        docenten.add(docent2);
    }

    /**
     * Stelt een kennistoets beschikbaar voor studenten
     * @param toetscode de code van de toets die moet worden open gesteld
     * @param docentCode de docent die de kennistoets open wil stellen
     */
    public void openKennistoets(String toetscode, String docentCode){
        Docent d = getDocent(docentCode);
        if(d != null)
            d.startKennistoets(toetscode);
    }

    /**
     * Voegt een nieuw lokaal toe aan een docent
     * @param lokaalNummer het nummer van het toe te voegen lokaal
     * @param docentCode de docent waaraan het lokaal moet worden toegevoegd
     */
    public void registreerLokaal(int lokaalNummer, String docentCode){
        Docent d = getDocent(docentCode);
        addDocent(d);
        d.registreerLokaal(lokaalNummer);
    }

    /**
     * Voegt een docent toe aan de lijst van docenten.
     * @param d Docent om toe te voegen
     */
    private void addDocent(Docent d) {
        docenten.add(d);
    }


    /**
     * Zoekt een docent op, op basis van een docentcode
     * @param docentCode de code van de docent die opgezocht moet worden
     * @return de gevonden docent
     */
    private Docent getDocent(String docentCode){
        for(Docent d : docenten) {
            if(d.getDocentcode().equals(docentCode))
                return d;
        }
        return null;
    }

    /**
     * Laat een student deelnemen aan een kennistoets
     * @param lokaalNummer het lokaal waar de student aan deel wil nemen
     * @param naam de naam van de student die wil deelnemen aan de kennistoets
     */
    public void neemDeelAanKennistoets(int lokaalNummer, String naam){
        Lokaal l = null;
        for(Docent d : docenten) {
            l = d.getLokaal(lokaalNummer);
            if(d.getLokaal(lokaalNummer) != null) {
                break;
            }
        }
        if(l == null) {
            System.out.println("Kon lokaal niet vinden");
            return;
        }
        l.voegDeelnemerToe(naam);
        //TODO: check of het lokaal wel open staat
    }

    public void haalUitslagOverzichtOp(int lokaalNummer, String docentCode) {
        Docent d = getDocent(docentCode);
        System.out.println(d.haalUitslagOverzichtOp(lokaalNummer));
    }

    public void wachtOpInput() {
        while(true) {
            System.out.println("Voer h in om een uitslagoverzicht op te halen, n om deel te nemen aan een kennistoets, r om een lokaal te registeren, o om een kennistoets te openen, q om te stoppen");
            Scanner s = new Scanner(System.in);
            String input = s.next();
            if (input.equals("h")) {
                System.out.println("Voer het lokaalnummer in");
                int lokaalNummer = s.nextInt();
                System.out.println("Voer uw docentcode in");
                String code = s.next();
                haalUitslagOverzichtOp(lokaalNummer, code);
            } else if (input.equals("n")) {
                System.out.println("Voer het lokaalnummer in");
                int lokaalNummer = s.nextInt();
                System.out.println("Voer je naam in");
                String naam = s.next();
                neemDeelAanKennistoets(lokaalNummer, naam);
            } else if (input.equals("r")) {
                System.out.println("Voer het lokaalnummer in");
                int lokaalNummer = s.nextInt();
                System.out.println("Voer uw docentcode in");
                String code = s.next();
                registreerLokaal(lokaalNummer, code);
            } else if (input.equals("o")) {
                System.out.println("Voer de toetscode in");
                String toetsCode = s.next();
                System.out.println("Voer uw docentcode in");
                String code = s.next();
                openKennistoets(toetsCode, code);
            } else if (input.equals("q")) {
                return;
            }
        }
    }
}
