package com.ba.yzl3514.domain.pre.ecommerce.composition;

/**
 *
 *
 *
 * @author Onder Sahin
 *
 */
public class BankTransferProcessor {

    private PaymentDetails paymentDetails;
    private String iban;

    public BankTransferProcessor(String txId, double amount){
        paymentDetails = new PaymentDetails(txId, amount);
    }

    public void executePayment(){
        System.out.println("Processing bank transfer of $ " + paymentDetails.getAmount());
        // Other logic etc..
        System.out.println("Transaction successful with ID: " + paymentDetails.getTransactionId());
        sendPaymentNotification();
    }

    public PaymentDetails getPaymentDetails() {
        return paymentDetails;
    }

    private void sendPaymentNotification() {
        System.out.println("Notification sent for transaction: " + paymentDetails.getTransactionId());
    }
}
