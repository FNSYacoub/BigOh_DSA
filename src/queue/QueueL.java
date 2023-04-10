package queue;

class ListNode {
    int val;
    ListNode next;
    ListNode prev;

    ListNode(int val) {
        this.val = val;
    }
}

public class QueueL {
    ListNode head, tail;

    int size;

    public QueueL() {
        head = new ListNode(-1);
        tail = new ListNode(-1);
        head.next = tail;
        tail.prev = head;
    }

    // enqueue = push/insertion/add -> O(1)
    public void enqueue(int val) {
        size++;
        ListNode back = new ListNode(val);
        ListNode prevOfTail = tail.prev;
        tail.prev = back;
        back.next = tail;
        prevOfTail.next = back;
        back.prev = prevOfTail;
    }

    // is Empty O(1)
    public boolean isEmpty() {
        return size == 0;
    }

    // dequeue = remove/pop O(1)
    public int dequeue() {
        if (isEmpty()) return Integer.MAX_VALUE;
        size--;
        ListNode front = head.next;
        ListNode nextToFront = front.next;
        head.next = nextToFront;
        nextToFront.prev = head;
        front.next = front.prev = null;

        return front.val;
    }

    // front = peek O(1)
    public int front() {
        if (isEmpty()) return Integer.MAX_VALUE;
        ListNode front = head.next;
        return front.val;
    }

    public void printQueue() {
        if (isEmpty()) System.out.println("EMPTY");
        else for (ListNode replica = head.next; replica.next != null; replica = replica.next) System.out.print(replica.next == null ? replica.val : (replica.val + ", "));
        System.out.println();
    }
}
