package com.ba.yzl3514.domain.pre.ecommerce.problem;

/**
 *
 *
 *
 * @author Onder Sahin
 *
 */
public class CreditCardProcessor {
    private String transactionId;
    private double amount;
    private String cardNumber;
    private String expiryDate;

    public void processPayment(double paymentAmount){
        amount = paymentAmount;
        //this.transactionId = UUID.randomUUID().toString();
        transactionId = "txn_creditCard_" + System.currentTimeMillis();
        // Logic to validate card
        // Connect payment gateway
        // etc ...
        System.out.println("Transaction successful with ID " + transactionId);
        sendPaymentNotification();
    }

    public void sendPaymentNotification(){
        System.out.println("Notification sent for transaction " + transactionId);
    }



}
