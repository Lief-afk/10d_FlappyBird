
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
   Square tube3;
   int xPosition;
   int yPosition;
   
   Tube()
   {
       tube1 = new Square(50,450,200,0,"green");
       tube2 = new Square(50,450,50,0,"green");
       tube3 = new Square(50,450,300,-60,"green");
       xPosition = 0;
       yPosition = 0;
       
       
    
   }
   public void draw()
   {
       tube1.draw();
       tube2.draw();
       tube3.draw();
   }
   
   
   public void bewegeNachLinks()
   {
       
   }
}
