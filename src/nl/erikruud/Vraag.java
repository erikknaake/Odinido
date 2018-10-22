package nl.erikruud;

public interface Vraag {
    ScoreVoorVraag getHuidigeScoreModel();
    int krijgScoreVoorAntwoord(GegevenAntwoord ga);
    Score geefScore();
}
