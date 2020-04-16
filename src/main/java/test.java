import java.util.HashMap;
import java.util.HashSet;
import java.util.Map;
import java.util.Set;

/**
 * @author zhouwq
 * @date 2019/7/17 16:11
 */

public class test {


    private static void mergeSort(int[] arr, int start, int end) {
        if (start >= end) {
            return;
        }
        int mark = (end + start) / 2;
        mergeSort(arr, start, mark);
        mergeSort(arr, mark + 1, end);

        int[] temp = new int[end - start + 1];
        int i = start;
        int j = mark + 1;
        int idx = 0;
        while (i <= mark && j <= end) {
            if (arr[i] > arr[j]) {
                temp[idx] = arr[j];
                j++;
            } else {
                temp[idx] = arr[i];
                i++;
            }
            idx++;
        }

        while (j <= end) {
            temp[idx] = arr[j];
            idx++;
            j++;
        }

        while (i <= mark) {
            temp[idx] = arr[i];
            idx++;
            i++;
        }

        for (int x = 0; x < temp.length; x++) {
            arr[start + x] = temp[x];
        }

        // 1 3 5 9
        // 2 5 8 10
        // 1 2 3 5 5 8 9 10
    }

    public static int removeElement(int[] nums, int val) {
        if (nums.length == 0) {
            return 0;
        }

        int j =0;
        for (int i = 0; i < nums.length; i++) {
            if (nums[i] != val) {
                nums[j++] = nums[i];
            }
        }
        return j;

    }

    public static void main(String[] args) {
        int[] arr = new int[]{0,1,2,2,3,0,4,2};
        int a = removeElement(arr, 2);
        System.out.println();
    }

}

