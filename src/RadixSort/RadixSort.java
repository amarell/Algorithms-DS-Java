package RadixSort;

public class RadixSort {
    public static void sort(int[] elements) {
        int max = getMax(elements);


        // 451
        // exp = 1; 451/1; 10            -- first iteration
        // exp = 10; 451/10; 100         -- second iteration
        // exp = 100; 451/100; 1000      -- third iteration
        // exp = 1000; 451/1000; - this is not greater than zero so loop terminates


        for (int exp = 1; max / exp > 0; exp *= 10) {
            sort(elements, exp);
        }
    }

    public static int getMax(int[] elements) {
        int max = elements[0];

        for (int i = 1; i < elements.length; i++) {
            if (elements[i] > max) {
                max = elements[i];
            }
        }

        return max;
    }

    private static void sort(int[] elements, int exp) {
        int[] helper = new int[elements.length];
        int[] frequency = {0, 0, 0, 0, 0, 0, 0, 0, 0, 0};

        for (int i = 0; i < elements.length; i++) {
            int digit = (elements[i] / exp) % 10;
            frequency[digit]++;
        }

        for (int i = 1; i < 10; i++) {
            frequency[i] += frequency[i - 1];
        }

        for (int i = elements.length - 1; i >= 0; i--) {
            int digit = (elements[i] / exp) % 10;
            helper[frequency[digit] - 1] = elements[i];
            frequency[digit]--;
        }

        for (int i = 0; i < elements.length; i++) {
            elements[i] = helper[i];
        }
    }
}
