import java.awt.*;
import java.awt.geom.*;

/**
 * A ellipse that can be manipulated and that draws itself on a canvas.
 * 
 * 
 * 
 */

public class Ellipse
{
    private int d1;
    private int d2;
    private int xPos;
    private int yPos;
    private String color;
    private boolean isVisible;
    
    /**
     * Create a new circle at default position with default color.
     */
    public Ellipse(int d1, int d2, int xPos, int yPos, String color)
    {
        this.d1 = d1;
        this.d2 = d2;
        this.xPos = xPos;
        this.yPos = yPos;
        this.color = color;
        isVisible = true;
    }

    /**
     * Make this circle visible. If it was already visible, do nothing.
     */
    public void makeVisible()
    {
        isVisible = true;
        draw();
    }
    
    /**
     * Move the circle vertically by 'distance' pixels.
     */
    public void moveVertical(int distance)
    {
        erase();
        yPos += distance;
        draw();
    }

    /**
     * Change the color. Valid colors are "red", "yellow", "blue", "green",
     * "magenta" and "black".
     */
    public void changeColor(String newColor)
    {
        color = newColor;
        draw();
    }

    /*
     * Draw the circle with current specifications on screen.
     */
    public void draw()
    {
        if(isVisible) {
            Canvas canvas = Canvas.getCanvas();
            canvas.draw(this, color, new Ellipse2D.Double(xPos, yPos, 
                                                          d1, d2));
            canvas.wait(10);
        }
    }

    /*
     * Erase the circle on screen.
     */
    public void erase()
    {
        if(isVisible) {
            Canvas canvas = Canvas.getCanvas();
            canvas.erase(this);
        }
    }
}