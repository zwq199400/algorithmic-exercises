import java.util.Collections;

/**
 * @author zhouwq
 * @date 2019/9/7 13:56
 */

public class QuickSort {


    private static void quickSort(int[] arr, int start, int end) {
        if (start >= end) {
            return;
        }
        int mark = partition(arr, start, end);
        quickSort(arr, start, mark);
        quickSort(arr, mark + 1, arr.length - 1);

    }

    public static void main(String[] args) {
        int[] arr = new int[]{5, 7, 1, 7, 6, 5, 8};
        quickSort(arr, 0, arr.length - 1);

        for (int a : arr) {
            System.out.println(a);
        }

    }

    private static void swap(int[] arr, int first, int second) {
        int temp = arr[first];
        arr[first] = arr[second];
        arr[second] = temp;
    }

    private static int partition(int[] arr, int start, int end) {
        //基准值
        int temp = arr[start];
        int mark = start;

        for (int i = start; i < end; i++) {
            if (arr[i] < temp) {
                mark++;
                swap(arr, i, mark);
            }
        }

        swap(arr, mark, start);
        return mark;
    }

}
