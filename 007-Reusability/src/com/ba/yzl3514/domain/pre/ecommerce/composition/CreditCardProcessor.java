package com.ba.yzl3514.domain.pre.ecommerce.composition;

/**
 *
 *
 *
 * @author Onder Sahin
 *
 */
public class CreditCardProcessor {

    private PaymentDetails paymentDetails;
    private String cardNumber;
    private String expiryDate;

    public CreditCardProcessor(String txId, double amount){
        paymentDetails = new PaymentDetails(txId, amount);
    }

    public PaymentDetails getPaymentDetails() {
        return paymentDetails;
    }

    public void processPayment(){
        // Logic to validate card
        // Connect payment gateway
        // etc ...
        System.out.println("Transaction successful with ID " + paymentDetails.getTransactionId());
        sendPaymentNotification();
    }

    public void sendPaymentNotification(){
        System.out.println("Notification sent for transaction " + paymentDetails.getTransactionId());
    }



}
