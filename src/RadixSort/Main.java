package RadixSort;

import java.util.Random;

public class Main {

    public static void main(String[] args) {
        // TODO Auto-generated method stub
        int[] elements = new int[10];
        Random generator = new Random();

        for (int i = 0; i < elements.length; i++) {
            elements[i] = generator.nextInt(100);
        }

        long s = System.currentTimeMillis();

        RadixSort.sort(elements);

        System.out.println(System.currentTimeMillis() - s);
		
		/*
		for(int i: elements) {
			System.out.println(i);
		}
		*/
    }

}
