import java.awt.BorderLayout;
import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;

import javax.swing.JFrame;
import javax.swing.JTextField;

public class KeyEventClass extends JFrame implements KeyListener 
{
    public KeyEventClass()
    {
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
        System.out.println("KeyTyped: ");
        if(e.getKeyChar() == KeyEvent.CHAR_UNDEFINED)
        {
            System.out.println("Keine gültige Taste");
        }
        else
        {
            System.out.println(e.getKeyChar());
        }
        System.out.println("---");
    }
    
    public void keyPressed(KeyEvent e) 
    {
        System.out.println("Zeichen." + e.getKeyChar());
    }

    public void keyReleased(KeyEvent e) 
    {
        System.out.println("KeyReleased: ");
        if(e.getKeyCode() == KeyEvent.VK_ESCAPE)
        {
            System.out.println("Programmstopp");
        }    
    }
    
    public static void main(String[] args) {
        new KeyEventClass();
    }
}
