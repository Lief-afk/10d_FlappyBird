
/**
 * Beschreiben Sie hier die Klasse Spiel.
 * 
 * @author (Ihr Name) 
 * @version (eine Versionsnummer oder ein Datum)
 */
public class Spiel
{
    Bird bird;
    Tube tube1;
    Tube tube2;
    /**
     * Konstruktor für Objekte der Klasse Spiel
     */
    public Spiel()
    {
        bird = new Bird();
        bird.draw();
        tube1 = new Tube();
        tube1.draw();
        tube2 = new Tube();
        tube2.draw();
        bird.move(50);
    }    
}

