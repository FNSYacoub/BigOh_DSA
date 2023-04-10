package queue;

public class QueueA {
    int[] array;
    int size, front, rear;

    public QueueA(int size) {
        this.array = new int[size];
    }

    public QueueA() {
        this(1000);
    }

    public void enqueue(int val) {
        if (isFull()) return;
        array[rear] = val;
        rear = (rear + 1) % array.length; // circular array
        size++;
    }

    public boolean isFull() {
        return size == array.length;
    }

    public int dequeue() {
        if (isEmpty()) return Integer.MIN_VALUE;
        size--;
        int val = array[front];
        front = (front + 1) % array.length;
        return val;
    }

    public boolean isEmpty() {
        return size == 0;
    }

    public void printQueue() {
        if (isEmpty()) System.out.println("EMPTY");
        else for (int i = front; i < rear; i++) System.out.print(array[i] + (i == rear - 1 ? "\n" : ", "));
    }
}