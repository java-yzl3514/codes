package ba.yzl3514.domain;

import ba.yzl3514.domain.exceptions.DynamicFieldsException;

/**
 *
 *
 *
 * @author Onder Sahin
 *
 */
public class DynamicFields {

    private Object[][] fields;

    public DynamicFields(int initialSize) {
        fields = new Object[initialSize][2];
        for (int i = 0; i < initialSize; i++) {
            fields[i] = new Object[]{null, null};
        }
    }

    @Override
    public String toString() {
        // TODO : implement this method
        return "";
    }


    private String getKeyAtIndex(int index) {
        return (String) fields[index][0];
    }

    private Object getValueAtIndex(int index) {
        return fields[index][1];
    }

    private int findField(String id) {
        for (int i = 0; i < fields.length; i++) {
            if (id.equals(getKeyAtIndex(i))) {
                return i;
            }
        }
        return -1;
    }

    public Object getField(String id) throws NoSuchFieldException {
        int index = findField(id);
        if (index == -1) throw new NoSuchFieldException();
        return getValueAtIndex(index);
    }

    private void setKeyAtIndex(int index, String id) {
        fields[index][0] = id;
    }

    private void setValueAtIndex(int index, Object value) {
        fields[index][1] = value;
    }


    /**
     *
     * @param size
     */
    private void growBySize(int size) {
        // TODO : integer overflow
        Object[][] tmp = new Object[fields.length + size][2];
        for (int i = 0; i < fields.length; i++)
            tmp[i] = fields[i];

        for (int i = fields.length; i < tmp.length; i++)
            tmp[i] = new Object[]{null, null};
        fields = tmp;
    }

    /**
     *
     * @param id
     * @return
     */
    private int makeField(String id) {
        for (int i = 0; i < fields.length; i++) {
            if (getKeyAtIndex(i) == null) {
                setKeyAtIndex(i, id);
                return i;
            }
        }
        growBySize(1);
        return makeField(id); // recursive call
        /*int nextIndex = fields.length;
        growBySize(1);
        setKeyAtIndex(nextIndex, id);
        return nextIndex;
        */
    }

    public Object setField(String id, Object value) throws DynamicFieldsException {
        if (value == null) {
            DynamicFieldsException exception = new DynamicFieldsException();
            exception.initCause(new NullPointerException());
            throw exception;
        }

        int index = findField(id);
        if(index == -1){
            index = makeField(id);
        }

        Object oldValue = null;
        try {
            oldValue = getField(id);
        } catch (NoSuchFieldException e) {
            throw new RuntimeException(e);
        }
        setValueAtIndex(index, value);
        return oldValue;

        /*
        int index = findField(id);
        if (index != -1) {
            Object oldValue = getValueAtIndex(index);
            setValueAtIndex(index, value);
            return oldValue;
        }
        index = makeField(id);
        Object oldValue = null;
        setValueAtIndex(index, value);
        return oldValue;
         */
    }


}
