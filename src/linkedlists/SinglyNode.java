package linkedlists;

public class SinglyNode {
    int val;
    SinglyNode next;

    SinglyNode(int val) {
        this.val = val;
    }

    SinglyNode(int val, SinglyNode next) {
        this.val = val;
        this.next = next;
    }

    public String toString() {
        return "[" + this.val + "] -> " + (next != null ? next.toString() : "NULL");
    }
}
