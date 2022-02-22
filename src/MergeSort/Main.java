package MergeSort;

import java.util.Random;

public class Main {

    public static void main(String[] args) {
        int[] elements = new int[10000000];

        Random rand = new Random();
        for (int i = 0; i < elements.length; i++) {
            elements[i] = rand.nextInt(10000000);
        }

        long s = System.currentTimeMillis();
        BottomUpMergeSort.sort(elements);
        System.out.println(System.currentTimeMillis() - s);


    }

}
