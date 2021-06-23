import java.awt.*;
import javax.swing.*;
import java.awt.event.*;
import javax.swing. *;
public class Tastatur
{
    Tastatur t;
    /**
     * Konstruktor für Objekte der Klasse Tastatur
     */
    public Tastatur()
    {
        t = new Tastatur();
        t.addKeyListener (new KeyAdapter()
        {
        public void KeyPressed(KeyEvent e)
        {
            TasteGedrueckt((char)e.getKeyCode());
        }
    
       });
    }
    void TasteGedrueckt()
    {
        System.out.pirntIn("Zeichen:" + key);
    }
}
