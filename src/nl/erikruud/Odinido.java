package nl.erikruud;

import java.util.*;

/**
 * Odinido functioneert als een controller die alle inkomende verzoeken afhandeld en interactie over een command
 * line interface mogelijk maakt
 */
public class Odinido {
    private List<Docent> docenten;

    public Odinido() {
        List<Lokaal> lokalen1 = new ArrayList<>();
        lokalen1.add(new Lokaal(1));
        lokalen1.add(new Lokaal(2));
        List<TijdsbonusVoorKennistoets> tijdsbonussenVoorKennistoets = new ArrayList<>();
        Calendar cal1 = Calendar.getInstance(), cal2 = Calendar.getInstance();
        cal1.set(2018, Calendar.OCTOBER, 23, 16, 34);
        cal2.set(2018, Calendar.OCTOBER, 24, 16, 40);
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
        vragenInKennistoets1.add(new VraagInKennistoets(2, vragen.get(1)));
        List<Kennistoets> kennistoetsen1 = new ArrayList<>();
        kennistoetsen1.add(new Kennistoets("dea", "programmeeropdracht", tijdsbonussenVoorKennistoets, vragenInKennistoets1));
        docenten = new ArrayList<>();
        Docent docent1 = new Docent("e.knaake@student.han.nl", "Erik", "Knaake", "P@ssword1", "ek", false, lokalen1, kennistoetsen1);
        docenten.add(docent1);
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
        if(d != null) {
            if(d.isPremiumDocent()) {
                Lokaal l = getLokaal(lokaalNummer);
                if (l == null)
                    d.registreerLokaal(lokaalNummer);
                else
                    System.out.println("Dit lokaal bestaat al");
            }
            else
                System.out.println("U bent geen premium docent");
        }
        else
            System.out.println("Deze docent bestaat niet");
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
        Lokaal l = getLokaal(lokaalNummer);
//        for(Docent d : docenten) {
//            l = d.getLokaal(lokaalNummer);
//            if(d.getLokaal(lokaalNummer) != null) {
//                break;
//            }
//        }
        if(l == null) {
            System.out.println("Kon lokaal niet vinden");
            return;
        }
        l.voegDeelnemerToe(naam);
    }

    private Lokaal getLokaal(int lokaalNummer) {
        for(Docent d : docenten) {
            Lokaal l = d.getLokaal(lokaalNummer);
            if(l != null)
                return l;
        }
        return null;
    }

    /**
     * Stelt een docent in staat om een uitslagoverzicht op de halen van een toetsuitvoering die plaatsvindt in een lokaal
     * @param lokaalNummer het lokaalnummer waar de uitvoering van de kennistoets plaatsvindt
     * @param docentCode de docentcode van de docent aan wie het lokaal toebehoort
     */
    public void haalUitslagOverzichtOp(int lokaalNummer, String docentCode) {
        Docent d = getDocent(docentCode);
        System.out.println(d.haalUitslagOverzichtOp(lokaalNummer));
    }

    /**
     * Verwerkt communicatie met de eindgebruiker over een command line interface
     */
    public void wachtOpInput() {
        while(true) {
            System.out.println("Voer h in om een uitslagoverzicht op te halen, n om deel te nemen aan een kennistoets, r om een lokaal te registeren, o om een kennistoets te openen, q om te stoppen");
            Scanner s = new Scanner(System.in);
            String input = s.next();
            if (input.equals("h")) {
                haalUitslagOverzichtOpMetInput(s);
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
                openKennisToetsMetInput(s);
            } else if (input.equals("q")) {
                return;
            }
        }
    }

    /**
     * Stelt een docent in staat om een uitslagoverzicht op de halen van een toetsuitvoering die plaatsvindt in een lokaal
     * via een command line interface
     * @param s de te gebruker scanner instantie
     */
    private void haalUitslagOverzichtOpMetInput(Scanner s) {
        System.out.println("Voer uw docentcode in");
        Docent d = inputDocent(s);
        System.out.println("Voer het lokaalnummer in");
        List<Lokaal> lokalen = d.getLokalen();
        System.out.println("Beschikbare lokalen: ");
        for(Lokaal l : lokalen) {
            System.out.println(l.getLokaalNummer());
        }

        int lokaalNummer = Integer.MAX_VALUE;
        do {
            try {
                lokaalNummer = s.nextInt();
            }
            catch (InputMismatchException e) {
                System.out.println("Dat is geen nummer");
            }
        } while(!lokaalnummerInLijst(lokaalNummer, lokalen));

        haalUitslagOverzichtOp(lokaalNummer, d.getDocentcode());
    }

    /**
     * Stelt een docent in staat om een kennistoets te starten in een lokaal via een command line interface
     * @param s de te gebruiken scanner instantie
     */
    private void openKennisToetsMetInput(Scanner s) {
        System.out.println("Voer uw docentcode in");
        Docent d = inputDocent(s);
        List<Kennistoets> kennistoetsen = d.getKennistoetsen();
        System.out.println("Beschikbare toetsen: ");
        for(Kennistoets k : kennistoetsen) {
            System.out.println(k.getToetscode());
        }

        String toetsCode = inputToetsCode(s, kennistoetsen);
        openKennistoets(toetsCode, d.getDocentcode());
    }

    private String inputToetsCode(Scanner s, List<Kennistoets> kennistoetsen) {
        String toetsCode = "";
        do {
            System.out.println("Voer de toetscode in");
            toetsCode = s.next();
        }
        while (!kennisToetscodeIsInLijst(toetsCode, kennistoetsen));
        return toetsCode;
    }

    private Docent inputDocent(Scanner s) {
        Docent d = null;
        while(d == null) {
            String code = s.next();
            d = getDocent(code);
        }
        return d;
    }

    private boolean kennisToetscodeIsInLijst(String toetsCode, List<Kennistoets> kennistoetsen) {
        for(Kennistoets k : kennistoetsen) {
            if(toetsCode.equals(k.getToetscode()))
                return true;
        }
        return false;
    }

    private boolean lokaalnummerInLijst(int lokaalnummer, List<Lokaal> lokalen) {
        for(Lokaal l : lokalen) {
            if(l.getLokaalNummer() == lokaalnummer)
                return true;
        }
        return false;
    }
}
