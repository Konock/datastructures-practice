public class Main {

    public static void main(String[] args) {

        PriorityQueue<TestObject> priorityQueue = new PriorityQueue<>();
        priorityQueue.enqueue(new TestObject("1"), 5);
        priorityQueue.enqueue(new TestObject("3"), 4);
        priorityQueue.enqueue(new TestObject("2"), 5);
        priorityQueue.dequeue();
        priorityQueue.enqueue(new TestObject("7"), 7);
        priorityQueue.enqueue(new TestObject("10"), 7);
        priorityQueue.dequeue();
        System.out.println(priorityQueue.count());
        System.out.println(priorityQueue.toString());
    }
}
