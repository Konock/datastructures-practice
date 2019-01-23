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

    T dequeue() {
        if (priorityQueue.size() == 1) {
            return priorityQueue.remove(0).getKey();
        }

        Map.Entry<T, Integer> tmp = priorityQueue.get(0);
        priorityQueue.set(0, priorityQueue.remove(priorityQueue.size()-1));
        int index = 0;
        int left = 1;

        while(left < priorityQueue.size()) {
            int max = left;
            int right = left + 1;
            if(right < priorityQueue.size()) {
                if(compareEntries(priorityQueue.get(right), priorityQueue.get(left)) > 0) {
                    max = right;
                }
            }
            Map.Entry<T, Integer> child = priorityQueue.get(index);
            Map.Entry<T, Integer> parent = priorityQueue.get(max);

            if(compareEntries(parent, child) < 0) {
                priorityQueue.set(index, child);
                priorityQueue.set(max, parent);

                index = max;
                left = 2*index+1;
            }
            else {
                break;
            }
        }
        return tmp.getKey();
    }

    int count() {
        return priorityQueue.size();
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