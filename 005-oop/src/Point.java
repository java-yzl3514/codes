/**
 *
 *
 *
 * @author Onder Sahin
 *
 */
public class Point {
    public double x; // instance variable
    public double y; // instance variable

    public Point(int xCoordinate, int yCoordinate){
        this((double) xCoordinate,yCoordinate);
    }

    public Point(double xCoordinate, double yCoordinate){
        x = xCoordinate;
        y = yCoordinate;
    }
}
