import java.util.HashSet;
import java.util.Set;

/**
 * @author zhouwq
 * @date 2019/7/24 15:27
 */

public class QuickSort2 {

    public static void quickSort(int[] arr, int start, int end) {

        if (end < start) {
            return;
        }
        int temp = arr[start];
        int markStart = start;
        int markEnd = end;
        while (markStart != markEnd) {
            if (arr[markEnd] < temp) {
                if (arr[markStart] > temp) {
                    swap(arr, markEnd ,markStart);
                } else{
                    markStart++;
                }
            } else {
                markEnd--;
            }
        }
        swap(arr, start, markStart);
        quickSort(arr, start, markStart -1);
        quickSort(arr, markStart + 1, end);
    }

    public static void main(String[] args) {
        int arr[] = {4,10,7,3,2,9,6,7,8};
        quickSort(arr, 0, arr.length - 1);
        System.out.println();
    }

    private static void swap(int[] arr, int a1, int a2) {
        int temp = arr[a1];
        arr[a1] = arr[a2];
        arr[a2] = temp;
    }

}
