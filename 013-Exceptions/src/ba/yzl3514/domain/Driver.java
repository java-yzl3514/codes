package ba.yzl3514.domain;

import ba.yzl3514.domain.exceptions.DynamicFieldsException;

import java.util.logging.Logger;

/**
 *
 *
 *
 * @author Onder Sahin
 *
 */
public class Driver {

    private static final Logger log = Logger.getLogger(Driver.class.getName());

    public static void main(String[] args) {
        DynamicFields dynamicFields = new DynamicFields(3);
        try {
            dynamicFields.setField("key-1", 1);
            dynamicFields.setField("key-2", 2);
            dynamicFields.setField("key-3", 3);
            dynamicFields.setField("key-4", 4);
            System.out.println(dynamicFields.getField("key-4"));
        } catch (DynamicFieldsException | NoSuchFieldException e) {
            log.severe(e.getMessage());
        }
    }
}
