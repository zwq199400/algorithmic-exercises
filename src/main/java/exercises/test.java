package exercises;

import util.ListNode;

import java.text.SimpleDateFormat;
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

    public static ListNode addTwoNumbers(ListNode l1, ListNode l2) {
        if (l1 == null && l2 == null) {
            return null;
        }
        int cur = 0;
        ListNode result = new ListNode(0);
        ListNode temp = result;
        while (l1 != null || l2 != null) {
            int sum;
            if (l1 == null) {
                sum = l2.val;
            } else if (l2 == null) {
                sum = l1.val;
            } else {
                sum = l1.val + l2.val;
            }
            sum += cur;
            cur = sum / 10;
            temp.next = new ListNode(sum % 10);
            temp = temp.next;
            if (l1 != null) {
                l1 = l1.next;
            }
            if (l2 != null) {
                l2 = l2.next;
            }
        }
        if (cur == 1) {
            temp.next = new ListNode(cur);
        }
        return result.next;
    }

    public static int lengthOfLongestSubstring(String s) {
        if (s == null) {
            return 0;
        }
        HashMap<Character, Integer> map = new HashMap<Character, Integer>();
        int max = 0;
        int left = 0;
        for(int i = 0; i < s.length(); i ++){
            if(map.containsKey(s.charAt(i))){
                left = Math.max(left,map.get(s.charAt(i)) + 1);
            }
            map.put(s.charAt(i),i);
            max = Math.max(max,i-left+1);
        }
        return max;
    }

    public static String longestPalindrome(String s) {
        if (s == null || s.length() == 0) {
            return "";
        }
        int length = s.length();
        int left = 0;
        int right = 0;
        int maxLength = 0;
        int maxStart = 0;
        int len = 0;
        for (int i = 0; i < length; i++) {
            left = i - 1;
            right = i + 1;
            while (left >= 0 && s.charAt(left) == s.charAt(i)) {
                len++;
                left--;
            }
            while (right < length && s.charAt(right) == s.charAt(i)) {
                len++;
                right++;
            }
            while (left >= 0 && right < length && s.charAt(left) == s.charAt(right)) {
                len = len + 2;
                left--;
                right++;
            }
            if (len > maxLength) {
                maxLength = len;
                maxStart = left;
            }
            len = 1;
        }
        return s.substring(maxStart + 1, maxStart + maxLength + 1);
    }

    public static boolean equationsPossible(String[] equations) {
        boolean flag = true;
        int[] parent = new int[27];
        for (int i = 1; i <= 26; i++) {
            parent[i] = i;
        }

        for (int i = 0; i < equations.length; i++) {
            String str = equations[i];
            int startInt = str.charAt(0) - 'a' + 1;
            int endInt = str.charAt(3) - 'a' + 1;
            String flagStr = str.substring(1, 2);
            if (flagStr.equals("=")) {
                union(startInt, endInt, parent);
            }
        }
        for (int i = 0; i < equations.length; i++) {
            String str = equations[i];
            int startInt = str.charAt(0) - 'a' + 1;
            int endInt = str.charAt(3) - 'a' + 1;
            String flagStr = str.substring(1, 2);
            if (flagStr.equals("!")) {
                int st = findParent(startInt, parent);
                int et = findParent(endInt, parent);
                if (st == et) {
                    flag = false;
                }
            }
        }
        return flag;
    }

    public static int findParent(int a, int[] parent) {
        int parentInt = parent[a];
        if (parentInt != a) {
            parentInt = findParent(parentInt, parent);
        }
        parent[a] = parentInt;
        return parentInt;
    }

    public static void union(int a, int b, int[] parent) {
        int parentA = findParent(a,parent);
        int parentB = findParent(b,parent);
        if (parentA != parentB) {
            parent[parentA] = parentB;
        }
    }

    public static List<List<Integer>> threeSum(int[] nums) {
        Arrays.sort(nums);
        List<List<Integer>> result = new ArrayList<>();
        for (int i = 0; i < nums.length; i++) {
            if (nums[i] > 0) {
                break;
            }
            if(i > 0 && nums[i] == nums[i-1]) continue;
            int left = i + 1;
            int right = nums.length - 1;
            while (left < right) {
                int sum = nums[left] + nums[i] + nums[right];
                if (sum < 0) {
                    left++;
                } else if (sum > 0) {
                    right--;
                } else {
                    result.add(Arrays.asList(nums[i], nums[left], nums[right]));
                    while (left<right && nums[left] == nums[left+1]) left++; // 去重
                    while (left<right && nums[right] == nums[right-1]) right--; // 去重
                    left++;
                    right--;
                }
            }
        }
        return result;
    }

    public static void main(String[] args) {
        String format = "yyyy年MM月dd日 E";
        String aa = new SimpleDateFormat(format, Locale.ENGLISH).format(159236548L);
        System.out.println(aa);
    }
}


