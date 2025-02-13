/**
 *    ===============================================================================
 *    ShapeType.java : Defines types of shapes.
 *    YOUR UPI: abor022
 *    ===============================================================================
 */

enum ShapeType{
    RECTANGLE(4), SQUARE(4), HEXAGON(6), HEPTAGON(7),
    OCTAGON(8);
    private int numberOfSides;
    private ShapeType(int numberOfSides) {this.numberOfSides = numberOfSides;}
    public int getNumberOfSides() {return this.numberOfSides;}
}