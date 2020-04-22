import java.util.*;

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

    public static class ListNode {
        int val;
        ListNode next;
        ListNode(int x) { val = x; }
    }
    static List<Integer> numList = new ArrayList<Integer>();

    public static ListNode deleteDuplicates(ListNode head) {

        if (head != null) {
            if (numList.contains(head.val)) {
                head = head.next;
            } else {
                numList.add(head.val);
            }
            deleteDuplicates(head.next);
        }
        return head;
    }

    public static void merge(int[] nums1, int m, int[] nums2, int n) {
        int x = 0,y = 0,idx = 0;
        int[] result = new int[nums1.length];
        while (x < m && y < n) {
            result[idx++] = nums1[x] < nums2[y] ? nums1[x++] : nums2[y++];
        }
        while (x < m) {
            result[idx++] = nums1[x++];
        }
        while (y < n) {
            result[idx++] = nums2[y++];
        }

        System.arraycopy(result, 0, nums1, 0, nums1.length);
    }


    public static void main(String[] args) {
//        int[] nums1 = {1,2,3,0,0,0};
        int[] nums1 = {1};
        int[] nums2 = {};
        merge(nums1, 1, nums2, 0);
        System.out.println();
    }

}

