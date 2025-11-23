package ba.yzl3514.main;

import java.util.LinkedList;
import java.util.Map;
import java.util.PriorityQueue;
import java.util.Queue;

/**
 *
 *
 *
 * @author Onder Sahin
 *
 */
public class QueueDriver {

    public static void main(String[] args) {

        Queue<Integer> queue = new LinkedList<>();

        queue.offer(1);
        queue.offer(1100);
        queue.offer(120);
        System.out.println(queue);

        System.out.println(queue.poll());

        PriorityQueue<Integer> integers = new PriorityQueue<>();
        integers.offer(1);
        integers.offer(1100);
        integers.offer(120);

        System.out.println(integers);
    }
}
