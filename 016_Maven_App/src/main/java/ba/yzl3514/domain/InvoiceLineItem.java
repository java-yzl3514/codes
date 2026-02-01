package ba.yzl3514.domain;

import ba.yzl3514.data.AbstractEntity;

/**
 *
 *
 *
 * @author Onder Sahin
 *
 */
public class InvoiceLineItem extends AbstractEntity<Long> {
    private long invoiceSequence;
    private String accountNumber;
    private double lineItemAmount;
    private String description;

    public long getInvoiceSequence() {
        return invoiceSequence;
    }

    public void setInvoiceSequence(long invoiceSequence) {
        this.invoiceSequence = invoiceSequence;
    }

    public String getAccountNumber() {
        return accountNumber;
    }

    public void setAccountNumber(String accountNumber) {
        this.accountNumber = accountNumber;
    }

    public double getLineItemAmount() {
        return lineItemAmount;
    }

    public void setLineItemAmount(double lineItemAmount) {
        this.lineItemAmount = lineItemAmount;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }
}
