package com.ba.yzl3514.domain.pre.ecommerce.composition;

/**
 *
 * @author Onder Sahin
 *
 */
public class TransactionIDGenerator {

    public static String generate(PaymentMethod paymentMethod){
        final String TRANSACTION_ID_PREFIX = "txn";
        return  TRANSACTION_ID_PREFIX + switch (paymentMethod) {
            case CREDIT_CARD -> "_credit_card_";
            case BANK_TRANSFER -> "_bank_transfer_";
        } + System.currentTimeMillis();
    }
}
