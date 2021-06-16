
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
        rumpf = new Ellipse(80,70,50,505,"red");
        auge = new Circle(20,95,520,"black");
        flügel = new Ellipse(43,26,43,528,"white");
        schnabel = new Triangle(24,24,150,540,"yellow");
    }
    
    public void draw()
    {
        rumpf.draw();
        flügel.draw();
        schnabel.draw();
        auge.draw();
    }
    
    public void move(int bewegung)
    {
        rumpf.moveVertical(3);
        auge.moveVertical(3);
        flügel.moveVertical(3);
        schnabel.moveVertical(3);
    }
}
