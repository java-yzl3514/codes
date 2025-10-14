package com.ba.yzl3514.domain.pre.ecommerce.problem;

/**
 *
 *
 *
 * @author Onder Sahin
 *
 */
public class Cart {

    //...


    public void checkout(PaymentMethod paymentMethod, double amount) {

        switch (paymentMethod) {
            case CREDIT_CARD -> {
                CreditCardProcessor creditCardProcessor = new CreditCardProcessor();
                creditCardProcessor.processPayment(amount);
            }
            case BANK_TRANSFER -> {
                BankTransferProcessor bankTransferProcessor = new BankTransferProcessor();
                bankTransferProcessor.executePayment(amount);
            }
        }

    }


}
