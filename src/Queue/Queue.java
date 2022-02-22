package Queue;

/*
 * Queue implementation using linked list approach
 */

public class Queue<Item> {
    private int size = 0;
    private Node<Item> head = null;
    private Node<Item> tail = null;

    /*
     * Returns the current size of the Queue
     */
    public int size() {
        return this.size;
    }

    /*
     * Checks if the Queue is empty or not
     */
    public boolean isEmpty() {
        return this.size == 0;
    }

    /*
     * Appends an item to the end of the Queue
     */
    public void enqueue(Item item) {
        Node<Item> newNode = new Node<Item>();
        newNode.data = item;
        if (head == null) {
            head = newNode;
            tail = newNode;
        } else {
            newNode.next = tail;
            tail = newNode;
        }
        size++;
    }

    /*
     * Removes an item from the front of the queue
     */
    public Item dequeue() throws Exception {
        if (size == 0) {
            throw new Exception("Queue is empty!");
        }

        if (size == 1) {
            Item item = head.data;
            head = null;
            tail = null;
            size--;
            return item;
        }

        Item item = head.data;
        Node<Item> current = tail;

        while (current.next.next != null) {
            current = current.next;
        }

        current.next = null;
        head = current;
        size--;
        return item;
    }

}
