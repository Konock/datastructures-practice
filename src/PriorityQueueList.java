import java.util.*;

public class PriorityQueueList<T> {

    List<Map.Entry<T, Integer>> priorityQueue;
    PrioComparator comparator;

    PriorityQueueList() {
        priorityQueue = new ArrayList<>();
        comparator = new PrioComparator();
    }

    void enqueue(T element, int priority) {
        Map.Entry<T, Integer> entry = new AbstractMap.SimpleEntry<>(element, priority);
        priorityQueue.add(entry);
        int index = priorityQueue.size() - 1;
        int parentIndex = (index - 1) / 2;
        while (index > 0) {
            Map.Entry<T, Integer> child = priorityQueue.get(index);
            Map.Entry<T, Integer> parent = priorityQueue.get(parentIndex);

            if (compareEntries(child, parent) > 0) {
                priorityQueue.set(index, parent);
                priorityQueue.set(parentIndex, child);

                index = parentIndex;
            } else {
                break;
            }
        }
    }

    @Override
    public String toString() {
        String text = "";
        for (Map.Entry entry : priorityQueue) {
            text += "Task: " + entry.getKey() + ", Prio: " + entry.getValue() + "\n";
        }
        return text;
    }

    int compareEntries(Map.Entry<T, Integer> entry1, Map.Entry<T, Integer> entry2) {
        return entry1.getValue().compareTo(entry2.getValue());
    }

}
