package ba.yzl3514.exercises.solution_0;

/**
 *
 *
 *
 * @author Onder Sahin
 * bknz : CircleRecord
 */
public class ImmutableCircle {

    // what if it is public !!
    private final double radius;


    public ImmutableCircle(double radius) {
        this.radius = radius;
    }

    public double getRadius() {
        return radius;
    }

    /*
    private void setRadius(double radius) {
        this.radius = radius;
    }
     */
}
