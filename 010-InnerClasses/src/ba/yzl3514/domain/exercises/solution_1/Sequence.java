package ba.yzl3514.domain.exercises.solution_1;

import java.util.Arrays;

/**
 *
 *
 *
 * @author Onder Sahin
 *
 */
public class Sequence {

    private Object[] items;
    private int next;

    public Sequence(int capacity){
        items = new Object[capacity];
    }

    public void add(Object item){
        items[next++] = item;
    }

    public int size(){
        return next;
    }


    private class SequenceSelector implements Selector{

        private int index;

        @Override
        public boolean end() {
            return index == next;
        }

        @Override
        public Object current() {
            return items[index];
        }

        @Override
        public void next() {
            if(index < next)
                index++;
        }
    }

    public Selector selector(){
        return new SequenceSelector();
    }

    @Override
    public String toString() {
        StringBuilder builder = new StringBuilder();
        builder.append("[");
        for(int i = 0; i < next; i++){
            builder.append(items[i]);
            if(i < next - 1)
                builder.append(", ");
        }
        builder.append("]");
        return builder.toString();
    }

    /*
     Aşağıdaki metodu programcı konuşlandıracaksa
     eğer, items referansının gösterdiği diziyi
     doğrudan dışarıya açmamalı. Dizinin eğer uygun
     şartlar varsa(bellek kısıtlaması vb) koyasına
     geri dönmeli.
      // Hints: System.arraycopy();
      //     Arrays.copyOf();
    public Object[] getItems() {
        return items;
    }
     */




}
