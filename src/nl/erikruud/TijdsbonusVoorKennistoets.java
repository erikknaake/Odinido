package nl.erikruud;

import java.util.Calendar;

public class TijdsbonusVoorKennistoets {
    private Calendar van;
    private Calendar tot;
    private Tijdsbonus tijdsbonus;

    public boolean isHuidigeTijdsBonnus() {
        return Calendar.getInstance().compareTo(van) > 0 && Calendar.getInstance().compareTo(tot) < 0;
    }

    public int getbonus(Calendar tijdOver){
        return tijdsbonus.getTijdsBonus(tijdOver);
    }
}
