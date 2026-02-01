package ba.yzl3514.domain;

import ba.yzl3514.data.AbstractEntity;

/**
 *
 *
 *
 * @author Onder Sahin
 *
 */
public class Vendor extends AbstractEntity<Long> {
    private String name;
    private VendorAddress vendorAddress;
    private String phone;
    private VendorContactInfo vendorContactInfo;

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public VendorAddress getVendorAddress() {
        return vendorAddress;
    }

    public void setVendorAddress(VendorAddress vendorAddress) {
        this.vendorAddress = vendorAddress;
    }

    public String getPhone() {
        return phone;
    }

    public void setPhone(String phone) {
        this.phone = phone;
    }

    public VendorContactInfo getVendorContactInfo() {
        return vendorContactInfo;
    }

    public void setVendorContactInfo(VendorContactInfo vendorContactInfo) {
        this.vendorContactInfo = vendorContactInfo;
    }
}
