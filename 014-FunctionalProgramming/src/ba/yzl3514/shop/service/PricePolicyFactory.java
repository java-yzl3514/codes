package ba.yzl3514.shop.service;

/**
 *
 *
 *
 * @author Onder Sahin
 *
 */

import static ba.yzl3514.shop.service.PricePolicyCodes.*;

public final class PricePolicyFactory {

    public static PricePolicy getPolicyByCode(String code) {

        switch (code) {
            case AUTUMN_20:
                return total -> {
                    if (total >= 1000.) return total * 0.80;
                    return total * 0.90;
                };
            case BLACK_FRIDAY:
                return total -> total * 0.50;
            case MEMBER:
                return total ->{
                    if(total > 500.) return total - 100;
                    return total * 0.95;
                };
            default:
                return total -> total;
        }
    }
}
