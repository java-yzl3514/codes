package com.ba.yzl3514.domain.pre.ecommerce.composition;


import static com.ba.yzl3514.domain.pre.ecommerce.composition.TransactionIDGenerator.generate;
/**
 *
 * @author Onder Sahin
 *
 */
public class Cart {

    //...

    public void checkout(PaymentMethod paymentMethod, double amount) {

        final String TX_ID = generate(paymentMethod);
        switch (paymentMethod) {
            case CREDIT_CARD -> {
                CreditCardProcessor creditCardProcessor = new CreditCardProcessor(TX_ID,amount);
                creditCardProcessor.processPayment();
            }
            case BANK_TRANSFER -> {
                BankTransferProcessor bankTransferProcessor = new BankTransferProcessor(TX_ID,amount);
                bankTransferProcessor.executePayment();
            }
        }

    }


}
