import java.awt.BorderLayout;
import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;

import javax.swing.JFrame;
import javax.swing.JTextField;
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
    Tube tube3;
    Boolean gameover;
    KeyEventClass tastatur;
    int beschleunigung;
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
        tube3 = new Tube();
        tube3.draw();
        tastatur = new KeyEventClass();
        bird.move(50); 
        beschleunigung = 1;
    }    
    
    public void starteSpiel()
    {
        while (gameover == false)
        {
            if (tastatur.e.getKeyEvent == Zeichen.VK_SPACE);
            {
                bird.move(-20);
                tube1.bewegeNachLinks();
                tube2.bewegeNachLinks();
                tube3.bewegeNachLinks();
            }
            }
            }
            }
         


    

