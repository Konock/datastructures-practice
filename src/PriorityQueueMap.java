import java.util.Map;
import java.util.TreeMap;

public class PriorityQueueMap<T> {

    TreeMap<Integer, T> priorityQueue;

    PriorityQueueMap() {
        priorityQueue = new TreeMap<>(new PrioComparator());
    }

    void enqueue(T element, int priority) {
        priorityQueue.put(priority, element);
    }

    void dequeue() {
    }

    int count() {
        return priorityQueue.size();
    }

    @Override
    public String toString() {
        String text = "";
        for (Map.Entry entry : priorityQueue.entrySet()) {
            text += "Task: " + entry.getValue().toString() + ", Prio: " + entry.getKey() + "\n";
        }
        return text;
    }
}
