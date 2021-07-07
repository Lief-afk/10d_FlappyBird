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
public class Spiel extends JFrame implements KeyListener 
{
    Bird bird;
    Tube tube1;
    Tube tube2;
    Tube tube3;
    Boolean gameover;
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
        bird.move(50); 
        beschleunigung = 1;
        this.setLayout(new BorderLayout());
        JTextField field = new JTextField();
        field.addKeyListener(this);
        this.add(field, BorderLayout.CENTER);
        this.pack();
        this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        this.setLocationRelativeTo(null);
        this.setVisible(true);
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
         


    

