import java.util.ArrayList;
import java.util.List;
import java.util.Map;
import java.util.TreeMap;

public class PriorityQueueMap<T> {

    TreeMap<Integer, T> priorityQueue;
    PrioComparator comparator = new PrioComparator();

    PriorityQueueMap() {
        priorityQueue = new TreeMap<>(comparator);
    }

    void enqueue(T element, int priority) {
        priorityQueue.put(priority, element);
    }

    T dequeue() {
        TreeMap<Integer, T> newPriorityQueue = new TreeMap<>(comparator);
        List<Map.Entry<Integer, T>> entries = new ArrayList<>(priorityQueue.entrySet());
        for (int i = 1; i < entries.size(); i++) {
            newPriorityQueue.put(entries.get(i).getKey(), entries.get(i).getValue());
        }
        priorityQueue = newPriorityQueue;
        return entries.get(0).getValue();
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
