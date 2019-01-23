import java.util.AbstractMap;
import java.util.Map;
import java.util.Queue;

public class PriorityQueue<T> {

    Queue<Map.Entry<T, Integer>> priorityQueue;

    PriorityQueue() {
        priorityQueue = new java.util.PriorityQueue<>((o1, o2) -> {
            if (o1.getValue() < o2.getValue())
                return 1;
            else if (o1.getValue() > o2.getValue())
                return -1;
            else
                return 0;
        });
    }

    void enqueue(T element, int priority) {
        Map.Entry<T, Integer> entry = new AbstractMap.SimpleEntry<>(element, priority);
        priorityQueue.offer(entry);
    }

    T dequeue() {
    }

    int count() {
        return priorityQueue.size();
    }

}
