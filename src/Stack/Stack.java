package Stack;

/*
 * Stack implementation using resizing arrays
 */

public class Stack<Item> {
    @SuppressWarnings({"unused", "unchecked"})
    private Item[] stack = (Item[]) new Object[1];
    private int top = 0;
    private int size = 0;

    @SuppressWarnings("unused")
    public void resize(int capacity) {
        @SuppressWarnings("unchecked")
        Item[] copy = (Item[]) new Object[capacity];
        for (int i = 0; i < size; i++) {
            copy[i] = stack[i];
        }
        stack = copy;
    }

    /*
     * Checks if the stack is currently empty
     */
    public boolean isEmpty() {
        return this.size == 0;
    }

    /*
     * Returns the current size of the stack (the number of items in the stack)
     */
    public int size() {
        return this.size;
    }

    /*
     * Adds an item on top of the stack
     */
    public void push(Item item) {
        if (stack.length == size) {
            resize(2 * stack.length);
        }
        if (top == 0 && size == 0) {
            stack[top] = item;
            size++;
        } else {
            top++;
            stack[top] = item;
            size++;
        }

    }

    /*
     * Removes an item located at the top of the stack
     */
    public Item pop() throws Exception {
        if (size == 0) {
            throw new Exception("There is nothing in the stack!");
        }

        Item item = stack[top];
        stack[top] = null;

        if (top > 0) {
            top--;
        }


        if (size > 0 && size == stack.length / 4) {
            resize(stack.length / 2);
        }

        size--;
        return item;
    }
}
