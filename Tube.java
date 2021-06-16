
/**
 * Beschreiben Sie hier die Klasse Tube.
 * 
 * @author (Jakob, Armin) 
 * @version (1. Version, 16.06.21)
 */
public class Tube
{
   Square rechteck1;
   Square rechteck2;
   int xPosition;
   int yPosition;
   
   Tube()
   {
       rechteck1 = new Square(50,450,300,0,"green");
       rechteck2 = new Square(50,450,50,0,"green");
       xPosition = 0;
       yPosition = 0;
       
       
    
   }
   public void draw()
   {
       rechteck1.draw();
       rechteck2.draw();
   }
   
   
   public void bewegeNachLinks()
   {
       
   }
}
