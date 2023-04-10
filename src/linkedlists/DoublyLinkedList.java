package linkedlists;

public class DoublyLinkedList {
    DoublyNode head, tail;
    private int size;

    public DoublyLinkedList() {
        head = new DoublyNode(-1);
        tail = new DoublyNode(-1);
        head.next = tail;
        tail.prev = head;
    }

    // insert at head O(1)
    public void insertAtHead(int val) {
        DoublyNode newNode = new DoublyNode(val);
        DoublyNode nextToHead = head.next;
        head.next = newNode;
        newNode.prev = head;

        newNode.next = nextToHead;
        nextToHead.prev = newNode;
        size++;
    }

    // insert at tail O(1)
    public void insertAtTail(int val) {
        DoublyNode newNode = new DoublyNode(val);
        DoublyNode prevToTail = tail.prev;

        newNode.next = tail;
        tail.prev = newNode;

        prevToTail.next = newNode;
        newNode.prev = prevToTail;
        size++;
    }
    // insert at index O(n)

    public void insertAtIndex(int index, int val) {
        if (index < 0 && index >= size) return;
        DoublyNode newNode = new DoublyNode(val);
        DoublyNode replica = head;
        for (int i = 0; i <= index; i++) replica = replica.next;
        DoublyNode nextToReplica = replica.next;
        replica.next = newNode;
        newNode.prev = replica;

        newNode.next = nextToReplica;
        nextToReplica.prev = newNode;
        size++;
    }

    // delete head O(1)
    public int deleteHead() {
        if (isEmpty()) return Integer.MIN_VALUE;
        DoublyNode deleteIt = head.next;
        DoublyNode nextToDelete = deleteIt.next;
        DoublyNode prevToDelete = deleteIt.prev; // head but added for illustration.

        prevToDelete.next = nextToDelete;
        nextToDelete.prev = prevToDelete;
        deleteIt.next = deleteIt.prev = null;
        size--;
        return deleteIt.val;
    }

    // delete tail O(1)
    public int deleteTail() {
        if (isEmpty()) return Integer.MIN_VALUE;
        DoublyNode deleteIt = tail.prev;
        DoublyNode nextToDelete = deleteIt.next; // tail, but added for illustration.
        DoublyNode prevToDelete = deleteIt.prev;

        nextToDelete.prev = prevToDelete;
        prevToDelete.next = nextToDelete;

        deleteIt.next = deleteIt.prev = null;
        size--;
        return deleteIt.val;
    }

    // delete index O(n) where n is # number of node / size

    public int deleteAtIndex(int index) {
        if (isEmpty() || index < 0 || index >= size) return Integer.MIN_VALUE;
        DoublyNode replica = head;
        for (int i = 0; i <= index; i++) replica = replica.next;
        DoublyNode next = replica.next;
        DoublyNode prev = replica.prev;
        next.prev = prev;
        prev.next = next;
        replica.next = replica.prev = null;
        size--;
        return replica.val;
    }


    // isEmpty
    public boolean isEmpty() {
        return size == 0;
    }


    // get size
    public int getSize() {
        return size;
    }

    // retrieval at head O(1)
    public int getHeadVal() {
        if (isEmpty()) return Integer.MIN_VALUE;
        return head.next.val;
    }

    // retrieval at tail

    public int getTailVal() {
        if (isEmpty()) return Integer.MIN_VALUE;
        return tail.prev.val;
    }

    // retrieval at index

    public int getIndex(int index) {
        if (isEmpty() || index < 0 || index >= size) return Integer.MIN_VALUE;
        DoublyNode replica = head;
        for (int i = 0; i <= index; i++) replica = replica.next;

        return replica.val;
    }

    public void printList() {
        DoublyNode replica = head.next;
        if (size == 0 || replica == null) {
            System.out.println("EMPTY");
            return;
        }


        while (replica != null && replica.next != tail) {
            System.out.print(replica.val + "->");
            replica = replica.next;
        }
        System.out.println(replica.val);
    }

    // extras...
}

