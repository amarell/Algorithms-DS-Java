package MergeSort;

public class MergeSort extends AbstractSort {

    public static void sort(int[] elements) {
        int[] helper = new int[elements.length];

        sort(elements, helper, 0, elements.length - 1);
    }

    private static void sort(int[] elements, int[] helper, int low, int high) {
        if (high <= low) {
            return;
        }

        int mid = low + (high - low) / 2;
        sort(elements, helper, low, mid);
        sort(elements, helper, mid + 1, high);
        merge(elements, helper, low, mid, high);
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
