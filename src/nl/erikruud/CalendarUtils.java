package nl.erikruud;

import java.util.Calendar;
import java.util.Date;

public class CalendarUtils {
    /**
     * Kijkt of de Calendar groter is dan 1 jan 1970, waarbij ervan uit wordt gegaan dat maanden en kleiner niet van belang zijn
     * @param cal Calendar om naar te kijken
     * @return True als de Calendar groter is dan 1970
     */
    @SuppressWarnings("deprecation")
    static public boolean isCalGroterDanEpoch(Calendar cal) {
        return cal.getTime().getYear() > 69;
    }

    /**
     * Trekt 2 calendars van elkaar af
     * @param cal1 calender om cal2 vanaf te trekken
     * @param cal2 Calender om van cal1 af te trekken
     * @return Verschil tussen de opgegeven calenders
     */
    static public Calendar substractCalendars(Calendar cal1, Calendar cal2) {
        Calendar cal3 = Calendar.getInstance();
        Date dif = new Date(cal1.getTime().getTime() - cal2.getTime().getTime());
        cal3.setTime(dif);
        return cal3;
    }
}
