package stack;
class ListNode {
    int val;
    ListNode next;

    ListNode(int val) {
        this.val = val;
    }
}
public class StackL {
    private ListNode head;
    private int size;
    public StackL() {
        this.head = new ListNode(-1);
    }

    // push time comp. = O(1)
    public void push(int val) {
        ListNode newTop = new ListNode(val);
        ListNode next = head.next;
        head.next = newTop;
        newTop.next = next;
        size++;
    }

    // is empty
    public boolean isEmpty() {
        return size == 0;
    }

    // peek/top TC=O(1)
    public int peek() {
        if (isEmpty()) return Integer.MIN_VALUE;
        return head.next.val;
    }

    // pop TC = O(1)
    public int pop() {
        if (isEmpty()) return Integer.MIN_VALUE;
        int val = head.next.val;
        size--;
        head.next = head.next.next;
        return val;
    }

    // size TC=O(1)
    public int size() {
        return size;
    }

    public void printStack() {
        if (isEmpty()) System.out.println("EMPTY");
        else for (ListNode replica = head.next; replica != null; replica = replica.next) System.out.print(replica.next == null ? replica.val : (replica.val + ", "));
        System.out.println();
    }
}
