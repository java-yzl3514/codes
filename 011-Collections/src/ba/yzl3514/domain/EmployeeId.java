package ba.yzl3514.domain;

/**
 *
 *
 *
 * @author Onder Sahin
 *
 */
public class EmployeeId {

    private int id;

    public EmployeeId(int id){
        this.id = id;
    }

    public int getId() {
        return id;
    }

    @Override
    public int hashCode() {
        System.out.println("EmployeeId Hash");
        return Integer.hashCode(id);
    }

    @Override
    public boolean equals(Object o) {
        System.out.println("EmployeeId Equals");
        if (o == null || getClass() != o.getClass()) return false;
        EmployeeId that = (EmployeeId) o;
        return id == that.id;
    }

    @Override
    public String toString() {
        return "EmployeeId{" +
                "id=" + id +
                '}';
    }
}
