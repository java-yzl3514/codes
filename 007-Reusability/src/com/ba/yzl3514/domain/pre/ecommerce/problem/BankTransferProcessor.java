package com.ba.yzl3514.domain.pre.ecommerce.problem;

/**
 *
 *
 *
 * @author Onder Sahin
 *
 */
public class BankTransferProcessor {

    private String transactionId;
    private double amount;
    private String iban;

    public void executePayment(double paymentAmount){
        amount = paymentAmount;
        transactionId = "txn_bank_" + System.currentTimeMillis();
        System.out.println("Processing bank transfer of $ " + amount);
        // Other logic etc..
        System.out.println("Transaction successful with ID: " + transactionId);
        sendPaymentNotification();
    }

    private void sendPaymentNotification() {
        System.out.println("Notification sent for transaction: " + transactionId);
    }
}
