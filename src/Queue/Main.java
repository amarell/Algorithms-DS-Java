package Queue;

public class Main {

    public static void main(String[] args) throws Exception {
        Queue<Integer> numbers = new Queue<Integer>();

        numbers.enqueue(1);
        numbers.enqueue(66);
        numbers.enqueue(777);
        numbers.enqueue(99);


        System.out.println(numbers.dequeue());
        System.out.println(numbers.dequeue());
        System.out.println(numbers.dequeue());
        System.out.println(numbers.dequeue());
        System.out.println(numbers.dequeue());
    }

}
