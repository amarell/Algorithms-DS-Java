package DoubleLinkedList;

public class Main {

    public static void main(String[] args) throws Exception {
        // TODO Auto-generated method stub
        DoublyLinkedList<Integer> numbers = new DoublyLinkedList<Integer>();

        numbers.addToFront(1);
        numbers.addToFront(5);



        numbers.addToRear(666);



        System.out.println("\nBefore removing: ");
        for(Integer i: numbers) {
            System.out.println(i);
        }

        numbers.removeFromFront();
        numbers.removeFromRear();

        System.out.println("\nAfter removing one node from the rear and one from the front: ");
        for(Integer i: numbers) {
            System.out.println(i);
        }


        System.out.println("\nThe size of the linked list: ");
        System.out.println(numbers.count());
    }

}

