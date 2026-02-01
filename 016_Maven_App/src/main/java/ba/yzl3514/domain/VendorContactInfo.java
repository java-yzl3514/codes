package ba.yzl3514.domain;

/**
 *
 *
 *
 * @author Onder Sahin
 *
 */
public class VendorContactInfo {
    private String firstName;
    private String lastName;

    public VendorContactInfo() {
    }

    public VendorContactInfo(String firstName, String lastName) {
        this.firstName = firstName;
        this.lastName = lastName;
    }

    public String getFirstName() {
        return firstName;
    }

    public void setFirstName(String firstName) {
        this.firstName = firstName;
    }

    public String getLastName() {
        return lastName;
    }

    public void setLastName(String lastName) {
        this.lastName = lastName;
    }
}
