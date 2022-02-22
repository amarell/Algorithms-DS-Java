package MergeSort;

public class BottomUpMergeSort extends AbstractSort {

    public static void sort(int[] elements) {
        int[] helper = new int[elements.length];

        for (int size = 1; size < elements.length; size *= 2) {
            for (int low = 0; low < elements.length - size; low += 2 * size) {
                int mid = low + size - 1;
                int high = Math.min(mid + size, elements.length - 1); //low + 2 * size -1
                merge(elements, helper, low, mid, high);
            }
        }
    }

    private static void merge(int[] elements, int[] helper, int low, int mid, int high) {
        for (int k = low; k <= high; k++) {
            helper[k] = elements[k];
        }

        int i = low;
        int j = mid + 1;

        for (int k = low; k <= high; k++) {
            if (i > mid) {
                elements[k] = helper[j++];
            } else if (j > high) {
                elements[k] = helper[i++];
            } else if (less(helper[j], helper[i])) {
                elements[k] = helper[j++];
            } else {
                elements[k] = helper[i++];
            }
        }
    }
}
