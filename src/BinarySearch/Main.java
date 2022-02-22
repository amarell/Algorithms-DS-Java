package BinarySearch;

public class Main {

    public static void main(String[] args) {
        int[] elements = new int[]{1, 2, 3, 4, 5, 6, 7, 98};


        int search = 98;

        int lo = 0;
        int hi = elements.length - 1;

        while (hi >= lo) {
            int middle = ((hi - lo) / 2) + lo;

            if (elements[middle] == search) {
                System.out.println("Found at position " + middle);
                break;
            } else if (elements[middle] > search) {
                hi = middle - 1;
            } else if (elements[middle] < search) {
                lo = middle + 1;
            }
        }

        System.out.println("Not found?");
    }

}
