package DoubleLinkedList;

import java.util.Iterator;

public class DoublyLinkedList<Item> implements Iterable<Item>{
    Node<Item> head;
    Node<Item> tail;
    private int size = 0;


    /*
     * Adding nodes to the beginning of the doubly linked list
     */
    public void addToFront(Item item) {
        Node<Item> newNode = new Node<Item>();
        newNode.data = item;
        if(head == null) {
            tail = newNode;
            head = tail;
        }
        else {
            head.prev = newNode;
            newNode.next = head;
            head = newNode;
        }
        size++;
    }

    /*
     * Adding nodes to the end of the doubly linked list
     */
    public void addToRear(Item item) {
        Node<Item> newNode = new Node<Item>();
        newNode.data = item;
        if(head == null) {
            tail = newNode;
            head = tail;
        }
        else {
            tail.next = newNode;
            newNode.prev = tail;
            tail = newNode;
        }
        size++;
    }

    /*
     * Removing nodes from the front of the doubly linked list
     */
    public void removeFromFront() throws Exception {
        if(head == null) {
            throw new Exception("The linked list is empty, so there is nothing to remove!");
        }
        head = head.next;
        head.prev = null;
        size--;
    }

    /*
     * Removing nodes from the end of the doubly linked list
     */
    public void removeFromRear() throws Exception {
        if(head == null) {
            throw new Exception("The linked list is empty, so there is nothing to remove!");
        }
        tail = tail.prev;
        tail.next = null;
        size--;
    }

    /*
     * Returns the current number of nodes in the doubly linked list
     */
    public int count() {
        return this.size;
    }

    private class DoublyLinkedListIterator implements Iterator<Item>{
        Node<Item> current = head;


        @Override
        public boolean hasNext() {
            return current != null;
        }

        @Override
        public Item next() {
            Item item = current.data;
            current = current.next;
            return item;
        }

    }

    @Override
    public Iterator<Item> iterator() {
        return new DoublyLinkedListIterator();
    }
}
