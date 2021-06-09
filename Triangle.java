
import java.awt.*;

/**
 * A triangle that can be manipulated and that draws itself on a canvas.
 * 
 * @author    Michael Kolling and David J. Barnes
 * (altered to fit needs)
 */

public class Triangle
{
    private int height;
    private int width;
    private int xPos;
    private int yPos;
    private String color;
    private boolean isVisible;

    /**
     * Create a new triangle at default position with default color.
     */
    public Triangle(int width, int height, int xPos, int yPos, String color)
    {
        this.width = width;
        this.height = height;
        this.xPos = xPos;
        this.yPos = yPos;
        this.color = color;
    }

    /**
     * Make this triangle visible. If it was already visible, do nothing.
     */
    public void makeVisible()
    {
        isVisible = true;
        draw();
    }

    /**
     * Move the triangle vertically by 'distance' pixels.
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
     * Draw the triangle with current specifications on screen.
     */
        private void draw()
    {
        if(isVisible) {
            Canvas canvas = Canvas.getCanvas();
            int[] xpoints = { xPos , xPos - width, xPos - width };
            int[] ypoints = { yPos, yPos +(height/2), yPos - (height/2) };
            canvas.draw(this, color, new Polygon(xpoints, ypoints, 3));
            canvas.wait(10);
        }
    }

    /*
     * Erase the triangle on screen.
     */
    private void erase()
    {
        if(isVisible) {
            Canvas canvas = Canvas.getCanvas();
            canvas.erase(this);
        }
    }
}
