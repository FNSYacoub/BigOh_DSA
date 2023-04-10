package linkedlists;

public class SinglyLinkedList {
    public SinglyNode head;
    public int size;

    public SinglyLinkedList() {
        head = new SinglyNode(-1); // dummy node
    } 

    public void insertAtHead(int val) {
        SinglyNode newNode = new SinglyNode(val);
//        if (head == null) head = newNode;
        newNode.next = head.next;
        head.next = newNode;
        size++;
    }

    public void insertAtIndex(int i, int val) {
        if (i > size || i < 0) return;

        SinglyNode newNode = new SinglyNode(val);
        SinglyNode beforeIndex = head;
        for (int count = 0; count < i; count++) {
            beforeIndex = beforeIndex.next;
        }

        SinglyNode onIndex = beforeIndex.next;
        newNode.next = onIndex;
        beforeIndex.next = newNode;

        size++;
    }

    public void insertAtTail(int val) {
        this.insertAtIndex(size, val);
    }

    public int deleteHead() {
        if (size == 0) return -1;
        SinglyNode trueHead = head.next; // dummy.next
        head.next = trueHead.next;
        trueHead.next = null;
        size--;
        return trueHead.val;
    }

    public int deleteAtIndex(int i) {
        if (size == 0 || i >= size) return -1;
        SinglyNode beforeIndex = head;
        for (int count = 0; count < i; count++) {
            beforeIndex = beforeIndex.next;
        }
        size--;
        SinglyNode deleteIt = beforeIndex.next;
//        if (deleteIt == null) return -1;

        beforeIndex.next = deleteIt.next;
        return deleteIt.val;
    }

    public int deleteTail() {
        return this.deleteAtIndex(size - 1);
    }

    public void printList() {
        SinglyNode replica = head.next;
        if (size == 0 || replica == null) {
            System.out.println("EMPTY");
            return;
        }


        while (replica != null && replica.next != null) {
            System.out.print(replica.val + "->");
            replica = replica.next;
        }
        System.out.println(replica.val);
    }
}
