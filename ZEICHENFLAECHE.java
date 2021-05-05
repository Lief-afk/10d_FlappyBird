
import java.awt.*;
import java.awt.geom.*;
import java.awt.event.*;
import javax.swing.*;
import java.util.*;

/**
 * Die Klasse stellt ein Fenster mit einer Malfläche zur Verfügung,
 * auf der Objekte der Klassen Rechteck, Kreis und Dreieck dargestellt
 * werden können.
 * Die Zeichenfläche wird beim ersten Anlegen eines Zeichenobjekts automatisch
 * nach dem Muster Singleton angelegt.
 * 
 * @author Albert Wiedemann 
 * @version 1.0
 */
class ZEICHENFLAECHE
{
    /** Aufzählung der erzeugbaren Objektarten. */
    static enum SymbolArt {kreis, dreieck, rechteck;};
    
    /** Einziges Objekt der Zeichenfläche. */
    private static ZEICHENFLAECHE zeichenfläche = null;
    
    /** Fenster für die Zeichenfläche. */
    private JFrame fenster;
    /** Die eigentliche Darstellungskomponente. */
    private JComponent malfläche;
    /** Feld aller zu zeichnenden Objekte. */
    private ArrayList<GrafikSymbol> alleSymbole;

    /**
     * Legt das Fenster und die Malfläche an
     */
    private ZEICHENFLAECHE ()
    {
        alleSymbole = new ArrayList<GrafikSymbol>();
        fenster = new JFrame("Zeichenfläche");
        fenster.setLocation(50, 50);
        fenster.setSize(800, 600);
        
        malfläche = new JComponent()
        {
            public void paint (Graphics g)
            {
                g.setColor(new Color (230, 230, 230));
                g.fillRect(0, 0, getWidth() - 1, getHeight() - 1);
                synchronized (malfläche)
                {
                    for (GrafikSymbol s: alleSymbole)
                    {
                        if (s.sichtbar)
                        {
                            s.Zeichnen(g);
                        }
                    }
                }
            }
        };
        malfläche.setOpaque(true);
        
        fenster.add(malfläche, BorderLayout.CENTER);
        fenster.setVisible(true);
    }
    
    /**
     * Erzeugt ein neues darzustelledes Symbol.
     * Die möglichen Symbole sind im Aufzählungstyp SymbolArt beschrieben.
     * @param art Art des zu erzeugenden Symbols.
     * @return Referenz auf das Delegate-Objekt.
     */
    static Object SymbolErzeugen (SymbolArt art)
    {
        if (zeichenfläche == null)
        {
            zeichenfläche = new ZEICHENFLAECHE();
        }
        return zeichenfläche.SymbolAnlegen(art);
    }
    
    /**
     * Setzt die Position (der linken oberen Ecke) des Objekts.
     * @param obj das betroffene Objekt
     * @param x x-Position der linken oberen Ecke
     * @param y y-Position der linken oberen Ecke
     */
    static void PositionSetzen (Object obj, int x, int y)
    {
        ((GrafikSymbol) obj).PositionSetzen(x, y);
        zeichenfläche.malfläche.repaint();
    }
        
    /**
     * Setzt die Größe des Objekts.
     * @param obj das betroffene Objekt
     * @param breite (neue) Breite des Objekts
     * @param höhe (neue) Höhe des Objekts
     */
    static void GrößeSetzen (Object obj, int breite, int höhe)
    {
        ((GrafikSymbol) obj).GrößeSetzen(breite, höhe);
        zeichenfläche.malfläche.repaint();
    }
    
    /**
     * Setzt die Farbe des Objekts.
     * @param obj das betroffene Objekt
     * @param farbe (neue) Farbe des Objekts
     */
    static void FarbeSetzen (Object obj, String farbe)
    {
        farbe = farbe.toLowerCase();
        Color c = Color.BLACK;
        switch (farbe)
        {
            case "weiß":
            case "weiss":
                c = Color.WHITE;
                break;
            case "rot":
                c = Color.RED;
                break;
            case "grün":
            case "gruen":
                c = Color.GREEN;
                break;
            case "blau":
                c = Color.BLUE;
                break;
            case "gelb":
                c = Color.YELLOW;
                break;
            case "magenta":
                c = Color.MAGENTA;
                break;
            case "cyan":
                c = Color.CYAN;
                break;
            case "hellgelb":
                c = new Color(255,255,128);
                break;
            case "hellgrün":
            case "hellgruen":
                c = new Color(128,255,128);
                break;
            case "orange":
                c = new Color(255,128,0);
                break;
            case "braun":
                c = new Color(128,64,0);
                break;
            case "grau":
                c = Color.GRAY;
                break;
               case "schwarz":
                c = Color.BLACK;
                break;
            default:
                c = Color.BLACK;
        }
        ((GrafikSymbol) obj).FarbeSetzen(c);
        zeichenfläche.malfläche.repaint();
    }
    
    /**
     * Setzt die Sichtbarkeit des Objekts.
     * @param obj das betroffene Objekt
     * @param sichtbar (neue) Sichtbarkeit des Objekts
     */
    static void SichtbarkeitSetzen (Object obj, boolean sichtbar)
    {
        ((GrafikSymbol) obj).SichtbarkeitSetzen(sichtbar);
        zeichenfläche.malfläche.repaint();
    }
    
    /**
     * Bringt das Objekt eine Ebene nach vorn.
     * @param obj das betroffene Objekt
     */
    static void NachVornBringen (Object obj)
    {
        synchronized (zeichenfläche.malfläche)
        {
            int index = zeichenfläche.alleSymbole.indexOf((GrafikSymbol)obj);
            if (index < zeichenfläche.alleSymbole.size() - 1)
            {
                zeichenfläche.alleSymbole.set(index, zeichenfläche.alleSymbole.get(index + 1));
                zeichenfläche.alleSymbole.set(index + 1, (GrafikSymbol)obj);
                zeichenfläche.malfläche.repaint();
            }
        }
    }
    
    /**
     * Bringt das Objekt in die vorderste Ebene.
     * @param obj das betroffene Objekt
     */
    static void GanzNachVornBringen (Object obj)
    {
        synchronized (zeichenfläche.malfläche)
        {
            int index = zeichenfläche.alleSymbole.indexOf((GrafikSymbol)obj);
            if (index < zeichenfläche.alleSymbole.size() - 1)
            {
                zeichenfläche.alleSymbole.remove(index);
                zeichenfläche.alleSymbole.add((GrafikSymbol)obj);
                zeichenfläche.malfläche.repaint();
            }
        }
    }
    
    /**
     * Bringt das Objekt eine Ebene nach hinten.
     * @param obj das betroffene Objekt
     */
    static void NachHintenBringen (Object obj)
    {
        synchronized (zeichenfläche.malfläche)
        {
            int index = zeichenfläche.alleSymbole.indexOf((GrafikSymbol)obj);
            if (index > 0)
            {
                zeichenfläche.alleSymbole.set(index, zeichenfläche.alleSymbole.get(index - 1));
                zeichenfläche.alleSymbole.set(index - 1, (GrafikSymbol)obj);
                zeichenfläche.malfläche.repaint();
            }
        }
    }
    
    /**
     * Bringt das Objekt in die hinterste Ebene.
     * @param obj das betroffene Objekt
     */
    static void GanzNachHintenBringen (Object obj)
    {
        synchronized (zeichenfläche.malfläche)
        {
            int index = zeichenfläche.alleSymbole.indexOf((GrafikSymbol)obj);
            if (index > 0)
            {
                zeichenfläche.alleSymbole.remove(index);
                zeichenfläche.alleSymbole.add(0, (GrafikSymbol)obj);
                zeichenfläche.malfläche.repaint();
            }
        }
    }
        
    /**
     * Setzt den Drehwinkel des Objekts.
     * @param obj das betroffene Objekt
     * @param winkel der (neue) Drehwinkel des Objekts
     */
    static void WinkelSetzen (Object obj, int winkel)
    {
        ((GrafikSymbol) obj).WinkelSetzen(winkel);
        zeichenfläche.malfläche.repaint();
    }
    
    /**
     * Meldet den Keylistener am Fenster an.
     * @param listener der anzumeldende Keylistener
     */
    static void KeyListenerAnmelden (KeyListener listener)
    {
        if (zeichenfläche == null)
        {
            zeichenfläche = new ZEICHENFLAECHE();
        }
        zeichenfläche.fenster.addKeyListener(listener);
    }
    
    /**
     * Meldet den Mouselistener an der Malfläche an.
     * @param listener der anzumeldende Mouselistener
     */
    static void MouseListenerAnmelden (MouseListener listener)
    {
        if (zeichenfläche == null)
        {
            zeichenfläche = new ZEICHENFLAECHE();
        }
        zeichenfläche.malfläche.addMouseListener(listener);
    }
    
    /**
     * Erzeugt das neue Symbol tatsächlich.
     * @param art Art des zu erzeugenden Symbols.
     * @return Referenz auf das Delegate-Objekt.
     */
    private Object SymbolAnlegen (SymbolArt art)
    {
        GrafikSymbol neu = null;
        switch (art)
        {
            case rechteck:
                neu = new Rechteck();
                break;
            case kreis:
                neu = new Ellipse();
                break;
            case dreieck:
                neu = new Dreieck();
                break;
        }
        synchronized (zeichenfläche.malfläche)
        {
            zeichenfläche.alleSymbole.add(neu);
        }
        malfläche.repaint();
        return neu;
    }
    
    /**
     * Oberklasse für alle verfügbaren Grafiksymbole.
     * Alle Grafiksymbole werden über ihr umgebendes Rechteck beschrieben.
     */
    private abstract class GrafikSymbol
    {
        /** x-Position der linken oberen Ecke. */
        protected int x;
        /** y-Position der linken oberen Ecke. */
        protected int y;
        /** Breite des umgebenden Rechtecks. */
        protected int b;
        /** Höhe des umgebenden Rechtecks. */
        protected int h;
        /** Farbe des Symbols. */
        protected Color c;
        /** Sichtbatkeit des Symbols. */
        protected boolean sichtbar;
        /** Drehwinkel des Symbols. */
        protected int winkel;
        
        /**
         * Der Konstruktor erzeugt ein rotes Symbol in der linken oberen Ecke des Fensters.
         */
        GrafikSymbol()
        {
            x = 10;
            y = 10;
            b = 100;
            h = 100;
            c = Color.RED;
            sichtbar = true;
            winkel = 0;
        }
        
        /**
         * Setzt die Position (der linken oberen Ecke) des Objekts.
         * @param x x-Position der linken oberen Ecke
         * @param y y-Position der linken oberen Ecke
         */
        void PositionSetzen (int x, int y)
        {
            this.x = x;
            this.y = y;
        }
        
        /**
         * Setzt die Größe des Objekts.
         * @param breite (neue) Breite des Objekts
         * @param höhe (neue) Höhe des Objekts
         */
        void GrößeSetzen (int breite, int höhe)
        {
            b = breite;
            h = höhe;
        }
        
        /**
         * Setzt die Farbe des Objekts.
         * @param c (neue) Farbe des Objekts
         */
        void FarbeSetzen (Color c)
        {
            this.c = c;
        }
        
        /**
         * Setzt die Sichtbarkeit des Objekts.
         * @param sichtbar (neue) Sichtbarkeit des Objekts
         */
        void SichtbarkeitSetzen (boolean sichtbar)
        {
            this.sichtbar = sichtbar;
        }
        
        /**
         * Setzt den Drehwinkel des Objekts.
         * @param winkel der (neue) Drehwinkel des Objekts
         */
        void WinkelSetzen (int winkel)
        {
            this.winkel = winkel;
        }
        
        /**
         * Zeichnet das Objekt
         * @param g das Grafikobjekt zum Zeichnen
         */
        abstract void Zeichnen(Graphics g);
    }
    
    /**
     * Objekte dieser Klasse verwalten ein Rechteck.
     */
    private class Rechteck extends GrafikSymbol
    {
        /**
         * Zeichnet das Objekt als Rechteck in der gegebenen Farbe.
         * @param g das Grafikobjekt zum Zeichnen
         */
        void Zeichnen(Graphics g)
        {
            g.setColor(c);
            if (winkel == 0)
            {
                g.fillRect(x, y, b, h);
            }
            else
            {
                Graphics2D g2 = (Graphics2D) g;
                AffineTransform alt = g2.getTransform();
                g2.rotate(Math.PI * winkel / 180.0, x + b / 2, y + h / 2);
                g.fillRect(x, y, b, h);
                g2.setTransform(alt);
            }
        }
    }
    
    /**
     * Objekte dieser Klasse verwalten eine Ellipse.
     */
    private class Ellipse extends GrafikSymbol
    {
        /**
         * Zeichnet das Objekt als Ellipse in der gegebenen Farbe.
         * @param g das Grafikobjekt zum Zeichnen
         */
        void Zeichnen(Graphics g)
        {
            g.setColor(c);
            if (winkel == 0)
            {
                g.fillOval(x, y, b, h);
            }
            else
            {
                Graphics2D g2 = (Graphics2D) g;
                AffineTransform alt = g2.getTransform();
                g2.rotate(Math.PI * winkel / 180.0, x + b / 2, y + h / 2);
                g.fillOval(x, y, b, h);
                g2.setTransform(alt);
            }
        }
    }
    
    /**
     * Objekte dieser Klasse verwalten ein Dreieck.
     */
    private class Dreieck extends GrafikSymbol
    {
        /**
         * Zeichnet das Objekt als Dreieck in der gegebenen Farbe.
         * @param g das Grafikobjekt zum Zeichnen
         */
        void Zeichnen(Graphics g)
        {
            g.setColor(c);
            Polygon rand = new Polygon (new int [] {x + b / 2, x + b, x, x + b / 2},
                                        new int [] {y, y + h, y + h, y}, 4);
            if (winkel == 0)
            {
                g.fillPolygon(rand);
            }
            else
            {
                Graphics2D g2 = (Graphics2D) g;
                AffineTransform alt = g2.getTransform();
                g2.rotate(Math.PI * winkel / 180.0, x + b / 2, y + h / 2);
                g.fillPolygon(rand);
                g2.setTransform(alt);
            }
        }
    }
}
