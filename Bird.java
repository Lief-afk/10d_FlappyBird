
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
    Circle eyeweiss;
    public Bird()
    {
        rumpf = new Ellipse(80,70,50,505,"red");
        auge = new Circle(20,95,520,"black");
        flügel = new Ellipse(43,26,43,528,"white");
        schnabel = new Triangle(24,24,150,540,"yellow");
        eyeweiss = new Circle(5,97,522, "white");
    }
    
    public void draw()
    {
        rumpf.draw();
        flügel.draw();
        schnabel.draw();
        auge.draw();
        eyeweiss.draw();
    }
    
    public void move(int bewegung)
    {
        rumpf.moveVertical(bewegung);
        auge.moveVertical(bewegung);
        flügel.moveVertical(bewegung);
        schnabel.moveVertical(bewegung);
        eyeweiss.moveVertical(bewegung);
    }
}
