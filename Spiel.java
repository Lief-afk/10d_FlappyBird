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
public class Spiel implements KeyListener 
{
    Bird bird;
    Tube tube1;
    Tube tube2;
    Tube tube3;
    Boolean gameover;
    int beschleunigung;
    JFrame f;
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
        bird.move(50); 
        beschleunigung = 1;
        f = new JFrame();
        f.setVisible(true);
        f.setSize(0,0);
        f.addKeyListener(this);
        gameover = false;
        
    }    
    
    public void keyTyped(KeyEvent e) 
    {
    }
    
    public void keyPressed(KeyEvent e) 
    {
        switch (e.getKeyChar())
        {
            case KeyEvent.VK_SPACE:
            bird.move(-20);
            break;
        }
    }

    public void keyReleased(KeyEvent e) 
    {
    }
    
    public void starteSpiel()
    {
        while (gameover == false)
        {
            tube1.bewegeNachLinks();
            tube2.bewegeNachLinks();
            tube3.bewegeNachLinks();
            bird.move(20);
            }
            }
   }
         


    

