package com.ba.yzl3514.domain.pre.ecommerce.composition;

/**
 * Aşağıdaki sınıfta transactionId için setter metodunun yazılmadığına
 * dikkat ediniz.
 *
 *
 * @author Onder Sahin
 *
 */
public class PaymentDetails {
    private String transactionId;
    private double amount;

    public PaymentDetails(String transactionId, double amount){
        this.amount = amount;
        this.transactionId = transactionId;
    }

    public void setAmount(double amount) {
        this.amount = amount;
    }

    public double getAmount() {
        return amount;
    }

    public String getTransactionId() {
        return transactionId;
    }
}
