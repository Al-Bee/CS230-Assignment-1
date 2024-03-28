/**
 * ==========================================================================================
 *  AnimationPanel.java : Moves shapes around on the screen according to different paths.
 *  It is the main drawing area where shapes are added.
 *  YOUR UPI: abor022
 *  =========================================================================================
 */

import java.awt.*;
import java.util.ArrayList;

class AnimationViewer  {
    private ShapeType currentShapeType = Shape.DEFAULT_SHAPETYPE; // the current shape type,
    private PathType currentPathType= Shape.DEFAULT_PATHTYPE;  // the current path type

    private ArrayList<Shape> shapes = new ArrayList<Shape>(); //create the ArrayList to store shapes
    private Color currentColor=Shape.DEFAULT_COLOR;  // the current fill colour of a shape
    private Color currentBorderColor = Shape.DEFAULT_BORDER_COLOR;
    private int currentPanelWidth=Shape.DEFAULT_PANEL_WIDTH, currentPanelHeight = Shape.DEFAULT_PANEL_HEIGHT, currentWidth=Shape.DEFAULT_WIDTH, currentHeight=Shape.DEFAULT_HEIGHT;

	public AnimationViewer() {}
    
    public int getCurrentWidth() { return  currentWidth; }
	public int getCurrentHeight() { return currentHeight; }
	public void setCurrentWidth(int w) {currentWidth=w;}
    public void setCurrentHeight(int h) {currentHeight=h;}
    public ShapeType getCurrentShapeType() {return this.currentShapeType;}
    public PathType getCurrentPathType() {return this.currentPathType;}
    public void setCurrentShapeType(ShapeType s) {this.currentShapeType = s;}
    public void setCurrentPathType(PathType p) {this.currentPathType = p;}

    protected void createNewShape() {
        ShapeType currentShapeType = this.currentShapeType;
        int currentWidth = this.currentWidth;
        int currentHeight = this.currentHeight;
        int currentPanelWidth = this.currentPanelWidth;
        int currentPanelHeight = this.currentPanelHeight;
        Color currentColor = this.currentColor;
        Color currentBorderColor = this.currentBorderColor;
        PathType currentPathType = this.currentPathType;
        if (currentShapeType == ShapeType.RECTANGLE){
            shapes.add(new RectangleShape(0, 0, currentWidth, currentHeight, currentPanelWidth, currentPanelHeight, currentColor, currentBorderColor, currentPathType));
        } 
        else if (currentShapeType == ShapeType.SQUARE){
            int side = Math.min(currentWidth, currentHeight);
            shapes.add(new SquareShape(0, 0, side, currentPanelWidth, currentPanelHeight, currentColor, currentBorderColor, currentPathType));
        } 
        else {
            int side = Math.min(currentWidth, currentHeight);
            shapes.add(new PolygonShape(0, 0, side, currentPanelWidth, currentPanelHeight, currentColor, currentBorderColor, currentPathType, currentShapeType));
        }
	}
    public void paintComponent(Graphics g) {
		for (Shape currentShape: shapes) {
			currentShape.move();
			currentShape.draw(g);
		}
    }
}