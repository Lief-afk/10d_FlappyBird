
/**
 * Erstellen der Spielfigur aus verschiedenen Formen
 * 
 * 
 */
public class Bird
{
    Circle auge;
    Triangle schnabel;
    Ellipse flügel;
    Ellipse rumpf;
    public Bird()
    {
        auge = new Circle(10,50,50,"black");
        rumpf = new Ellipse(40,35,60,60,"red");
        schnabel = new Triangle(12,12,70,70,"yellow");
        flügel = new Ellipse(13,18,80,80,"white");
    }
    
    public void draw()
    {
        draw();
    }
}
