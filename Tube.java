
/**
 * Beschreiben Sie hier die Klasse Tube.
 * 
 * @author (Jakob, Armin) 
 * @version (1. Version, 16.06.21)
 */
public class Tube
{
   Square tube1;
   Square tube2;
   int xPosition;
   int yPosition;
   
   Tube()
   {
       tube1 = new Square(50,450,300,0,"green");
       tube2 = new Square(50,450,50,0,"green");
       xPosition = 0;
       yPosition = 0;
       
       
    
   }
   public void draw()
   {
       tube1.draw();
       tube2.draw();
   }
   
   
   public void bewegeNachLinks()
   {
       
   }
}
