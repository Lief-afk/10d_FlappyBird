
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
       xPosition = 1920;
       yPosition = 0;
       tube1 = new Square(50,450,xPosition,yPosition,"green");
       tube2 = new Square(50,450,xPosition,yPosition,"green");
       tube3 = new Square(50,450,xPosition,yPosition,"green");
       
    
   }
   public void draw()
   {
       tube1.draw();
       tube2.draw();
       tube3.draw();
   }
   
   
   public void bewegeNachLinks()
   {
       xPosition = xPosition - 5;
       tube1.moveHorizontal (-5);
       tube2.moveHorizontal (-5);
       tube3.moveHorizontal (-5);
       
       if (xPosition <-50)
       {
           xPosition = 1870;
           }
       }
   }

