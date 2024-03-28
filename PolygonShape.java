/*
 *	===============================================================================
 *	PolygonShape.java : A shape that is a polygon.
 *  YOUR UPI: abor022
 *	=============================================================================== */
import java.awt.*;
import java.util.ArrayList;

class PolygonShape extends SquareShape{
    private int radius = DEFAULT_HEIGHT/2;
    private int numberOfSides = 6;
    private Point centre = new Point(DEFAULT_HEIGHT/2, DEFAULT_HEIGHT/2);
    public PolygonShape(){
        super();
    }
    public PolygonShape(int x, int y, int s, int pw, int ph, Color c, Color bc, PathType pt, ShapeType st){
        super(x, y, s, pw, ph, c, bc, pt);
        this.radius = s/2;
        this.numberOfSides = st.getNumberOfSides();
        this.centre = new Point(x + s/2, y + s/2);
    }
    public void draw(Graphics g){
        this.centre = new Point(x + this.width/2, y + this.width/2);
        System.out.println(this.color);
        System.out.println(this.borderColor);
        System.out.println(this);
        ArrayList<Integer> xlist = new ArrayList<Integer>();
        ArrayList<Integer> ylist = new ArrayList<Integer>();
        for (int i = 0; i < this.numberOfSides; i++){
            Double curx = this.centre.x + this.radius * Math.cos((i * 2 * Math.PI) / this.numberOfSides);
            Double cury = this.centre.y + this.radius * Math.sin((i * 2 * Math.PI) / this.numberOfSides);
            xlist.add(curx.intValue());
            ylist.add(cury.intValue());
        }
        System.out.println(getClass().getName() + ":" + xlist.toString() + "," + ylist.toString());
    }
}