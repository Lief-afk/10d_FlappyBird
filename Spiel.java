
/**
 * Beschreiben Sie hier die Klasse Spiel.
 * 
 * @author (Ihr Name) 
 * @version (eine Versionsnummer oder ein Datum)
 */
public class Spiel
{
    Bird bird;
    
    /**
     * Konstruktor für Objekte der Klasse Spiel
     */
    public Spiel()
    {
        bird = new Bird();
        bird.draw();
    }

}

