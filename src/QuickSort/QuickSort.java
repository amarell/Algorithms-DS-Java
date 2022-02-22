package QuickSort;

import java.util.Random;

public class QuickSort extends AbstractSort {

    public static void sort(int[] elements) {
        shuffle(elements);  //Knuth shuffle
        sort(elements, 0, elements.length - 1);
    }

    private static void shuffle(int[] elements) {
        Random generator = new Random();
        for (int i = 0; i < elements.length; i++) {
            int r = i + generator.nextInt(elements.length - i);
            swap(elements, i, r);
        }
    }

    private static void sort(int[] elements, int low, int high) {
        if (high <= low) {
            return;
        }

        int j = partition(elements, low, high);
        sort(elements, low, j - 1);
        sort(elements, j + 1, high);
    }

    private static int partition(int[] elements, int low, int high) {
        int i = low;
        int j = high + 1;

        while (true) {
            while (less(elements[++i], elements[low])) {
                if (i == high) {
                    break;
                }
            }

            while (less(elements[low], elements[--j])) {
                if (j == low) {
                    break;
                }
            }

            if (i >= j) {
                break;
            }

            swap(elements, i, j);
        }

        swap(elements, low, j);

        return j;
    }


}
