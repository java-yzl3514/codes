package ba.yzl3514.domain;

import java.util.Arrays;

/**
 *
 *
 *
 * @author Onder Sahin
 *
 */
public class DynamicArray {
    private static final int DEFAULT_CAPACITY = 1;
    private Object[] data;
    private int size;

    public DynamicArray() {
        this(DEFAULT_CAPACITY);
    }

    public DynamicArray(int capacity) {
        if (capacity < DEFAULT_CAPACITY)
            capacity = DEFAULT_CAPACITY;
        // TODO : Implement Lazy Initialization : Gerçekten ihtiyaç duyulduğunda array oluşturulmalı
        data = new Object[capacity];
    }

    public void add(Object item){
        if(size == data.length){
            grow(size + 1);
        }
        data[size++] = item;
    }

    private Object[] grow(int minCapacity){
        int oldCapacity = data.length;
        int newCapacity = calculateNeedLength(oldCapacity, minCapacity - oldCapacity, oldCapacity >> 1 ); // x1.5 Altın Oran
        return data = Arrays.copyOf(data,newCapacity);
    }

    private int calculateNeedLength(int oldCapacity, int minCapacity, int prefCapacity){
        int newCapacity = oldCapacity + Math.max(minCapacity, prefCapacity);
        if(newCapacity > 0 && newCapacity <= Integer.MAX_VALUE - 8) // JVM Object Header implementation
            return newCapacity;
        else {
            // huge !!
            newCapacity = oldCapacity + minCapacity;
            if(newCapacity < 0) {
                // TODO : throw exception
            }else if(newCapacity < Integer.MAX_VALUE - 8){ // JVM Object Header implementation
                return Integer.MAX_VALUE - 8; // JVM Object Header implementation
            }
            return newCapacity;
        }
    }


    public Object get(int index){
        if(index < 0 || index >= size){  // ! can be use : Objects.checkIndex();
            // TODO throw illegal index : IndexOutOfBoundsException
            return null;
        }
        return data[index];
    }

    public int size() {
        return size;
    }


    public boolean contains(Object item){
        // TODO :
        return false;
    }

    @Override
    public String toString() {
        StringBuilder builder = new StringBuilder("[");
        for(int i = 0; i < size; i++){
            builder.append(data[i]);
            if(i < size - 1)
                builder.append(", ");
        }
        builder.append("]");
        return builder.toString();
    }
}
