package stack;

public class StackA {

    private int[] array;
    private int top;

    public StackA(int stackSize) {
        top = 0;
        array = new int[stackSize];
    }

    public StackA() {
        this(1000);
    }

    public boolean isFull() {
        return top == array.length;
    }

    public void push(int val) {
        if (isFull()) return;
        array[top] = val;
        top++;
    }

    public boolean isEmpty() {
        return top == 0;
    }

    public int pop() {
        if (isEmpty()) return Integer.MIN_VALUE;
        int val = array[top - 1];
        top--;
        return val;
    }

    public int peek() {
        if (isEmpty()) return Integer.MIN_VALUE;
        return array[top - 1];
    }

    public void printStack() {
        if (isEmpty()) System.out.println("EMPTY");
        else if (isFull()) System.out.println("FULL!");
        else for (int i = 0; i < top; i++)System.out.print(array[i] + (i == top - 1 ? "\n" : ", "));
    }
}
