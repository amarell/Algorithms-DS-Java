package QuickSort;

import java.util.Random;

public class Main {

    public static void main(String[] args) {
        int[] elements = new int[5];

        Random generator = new Random();

        for (int i = 0; i < elements.length; i++) {
            elements[i] = generator.nextInt(100);
        }

        long s = System.currentTimeMillis();
        QuickSort.sort(elements);
        System.out.println(System.currentTimeMillis() - s);

    }

}
