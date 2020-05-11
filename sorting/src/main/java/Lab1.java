import org.jetbrains.annotations.NotNull;

import java.util.Arrays;

public class Lab1 {
    /**
     * Sorting algorithms
     **/

    public static void main(String[] args) {
        int[] a = new int[]{1, 7, 1, 3, 2, 8, 4, 1, 9, 7, 3, 6, 1, 5};
        selectionSort(a);
        System.out.println(Arrays.toString(a));
    }

    private static boolean less(int a, int b) {
        return a - b < 0;
    }

    private static void exchange(@NotNull int[] a, int i, int j) {
        int swap = a[i];
        a[i] = a[j];
        a[j] = swap;
    }

    // Selection sort.
    public static void selectionSort(@NotNull int[] array) {
        int n = array.length;
        for (int i = 0; i < n; i++) {
            int minIndex = i;
            int minValue = array[minIndex];
            for (int j = i + 1; j < n; j++) {
                if (less(array[j], minValue)) {
                    minIndex = j;
                    minValue = array[minIndex];
                }
            }
            if (i != minIndex) exchange(array, i, minIndex);
        }
    }

    // Insertion sort.

    public static void insertionSort(@NotNull int[] array) {
        int n = array.length;
        for (int i = 0; i < n; i++) {
            for (int j = i; j > 0; j--) {
                if (less(array[j], array[j - 1])) exchange(array, j, j - 1);
                else break;
            }
        }
    }

    // Quicksort.

    public static void quickSort(int[] array) {
        throw new UnsupportedOperationException();
    }

    // Quicksort part of an array
    private static void quickSort(int[] array, int begin, int end) {
    }

    // Partition part of an array, and return the index where the pivot
    // ended up.
    private static int partition(int[] array, int begin, int end) {
        throw new UnsupportedOperationException();
    }

    // Swap two elements in an array
    private static void swap(@NotNull int[] array, int i, int j) {
        int x = array[i];
        array[i] = array[j];
        array[j] = x;
    }

    // Mergesort.

    public static int[] mergeSort(int[] array) {
        throw new UnsupportedOperationException();
    }

    // Mergesort part of an array
    private static int[] mergeSort(int[] array, int begin, int end) {
        throw new UnsupportedOperationException();
    }

    // Merge two sorted arrays into one
    private static int[] merge(int[] left, int[] right) {
        throw new UnsupportedOperationException();
    }
}