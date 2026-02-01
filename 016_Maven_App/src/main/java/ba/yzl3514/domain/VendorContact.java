package ba.yzl3514.domain;

import ba.yzl3514.data.AbstractEntity;

/**
 *
 *
 *
 * @author Onder Sahin
 *
 */
public class VendorContact extends AbstractEntity<Long> {
    private String firstName;
    private String lastName;

    public VendorContact() {
    }

    public VendorContact(String firstName, String lastName) {
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
