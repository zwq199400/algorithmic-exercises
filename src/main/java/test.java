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

    public static double findMedianSortedArrays(int[] nums1, int[] nums2) {
        int m = nums1.length;
        int n = nums2.length;
        int[] temp = new int[m + n];
        int i = 0;
        int j = 0;
        int idx = 0;
        while (i < m && j < n) {
            if (nums1[i] < nums2[j]) {
                temp[idx] = nums1[i];
                i++;
            } else {
                temp[idx] = nums2[j];
                j++;
            }
            idx++;
        }
        while (i < m) {
            temp[idx++] = nums1[i++];
        }
        while (j < n) {
            temp[idx++] = nums2[j++];
        }
        double result = 0D;
        int mid = (m + n) / 2;
        if ((m + n) % 2 == 0) {
            return (temp[mid] + temp[mid - 1]) / 2.0;
        } else {
            return (double) temp[mid];
        }

    }

    public static int uniquePathsWithObstacles(int[][] obstacleGrid) {
        int m = obstacleGrid.length;
        int n = obstacleGrid[0].length;
        int[][] arr = new int[m][n];
        if (obstacleGrid[0][0] == 1) {
            return 0;
        }
        arr[0][0] = 1;
        for (int i = 1; i < m; i++) {
            if (obstacleGrid[i][0] == 1) {
                arr[i++][0] = 0;
                while (i < m) {
                    arr[i++][0] = 0;
                }
                break;
            } else {
                arr[i][0] = 1;
            }
        }
        for (int i = 1; i < n; i++) {
            if (obstacleGrid[0][i] == 1) {
                arr[0][i++] = 0;
                while (i < n) {
                    arr[0][i++] = 0;
                }
                break;
            } else {
                arr[0][i] = 1;
            }
        }

        for (int i = 1; i < m; i++) {
            for (int j = 1; j < n; j++) {
                if (obstacleGrid[i][j] == 1) {
                    arr[i][j] = 0;
                } else {
                    arr[i][j] = arr[i-1][j] + arr[i][j - 1];
                }
            }
        }
        return arr[m - 1][n - 1];
    }


    public static List<List<Integer>> threeSum(int[] nums) {
        Arrays.sort(nums);
        List<List<Integer>> result = new ArrayList<>();
        Map<Integer, Integer> keyMapping = new HashMap<>(nums.length);
        for (int i = 0; i < nums.length; i++) {
            keyMapping.put(nums[i], i);
        }
        for (int i = 0; i < nums.length; i++) {
            for (int j = i + 1; j < nums.length; j++) {
                if (i != 0 && nums[i] == nums[i - 1]) {
                    continue;
                }
                if (j != i + 1 && nums[j] == nums[j - 1]) {
                    continue;
                }
                int sum = nums[i] + nums[j];
                int sumAbs = -sum;
                if (keyMapping.containsKey(sumAbs)) {
                    int key = keyMapping.get(sumAbs);
                    if (key <= j) {
                        continue;
                    }
                    result.add(Arrays.asList(nums[i], nums[j], sumAbs));
                }
            }
        }
        return result;
    }


    public static Map<String, List<String>> mapping;

    public static List<String> letterCombinations(String digits) {
        mapping = new HashMap<>(7);
        mapping.put("2", Arrays.asList("a", "b", "c"));
        mapping.put("3", Arrays.asList("d", "e", "f"));
        mapping.put("4", Arrays.asList("g", "h", "i"));
        mapping.put("5", Arrays.asList("j", "k", "l"));
        mapping.put("6", Arrays.asList("m", "n", "o"));
        mapping.put("7", Arrays.asList("p", "q", "r", "s"));
        mapping.put("8", Arrays.asList("t", "u", "v"));
        mapping.put("9", Arrays.asList("w", "x", "y", "z"));

        List<String> result = new ArrayList<>();

        int length = digits.length();
        handelStr(new StringBuilder(), digits, result);
        return result;
    }

    private static void handelStr(StringBuilder str, String oldStr, List<String> result) {
        if (oldStr.length() == 0) {
            result.add(str.toString());
            return;
        }
        String strInt = oldStr.substring(0, 1);
        List<String> keyStringList = mapping.get(strInt);
        for (String key : keyStringList) {
            StringBuilder newStrBuilder = new StringBuilder(str);
            newStrBuilder.append(key);
            String newOldStr = oldStr.substring(1);
            handelStr(newStrBuilder, newOldStr, result);
        }
    }

    public static boolean equationsPossible(String[] equations) {
        Map<String, String> parent = new HashMap<>();
        for (String str : equations) {
            String str1 = str.substring(0, 1);
            String str2 = str.substring(3, 4);
            String method = str.substring(1, 3);
            if (Objects.equals(method, "==")) {
                if (parent.containsKey(str1)) {
                    parent.put(str2, parent.get(str1));
                } else {
                    parent.put(str1, str2);
                }
            }
            System.out.println();
        }

        for (String str : equations) {
            String str1 = str.substring(0, 1);
            String str2 = str.substring(3, 4);
            String method = str.substring(1, 3);
            if (Objects.equals(method, "!=")) {
                parent.put(str1, str2);
            }
        }
        return false;
    }

    public static ListNode swapPairs(ListNode head) {
        if (head == null || head.next == null) {
            return head;
        }
        Queue<ListNode> queue = new LinkedList<>();
        ListNode cur = head;
        queue.offer(cur);
        queue.offer(cur.next);
        ListNode lastNode = null;
        while (!queue.isEmpty() && queue.size() > 1) {
            ListNode firstNode = queue.poll();
            ListNode secondNode = queue.poll();
            firstNode.next = secondNode.next;
            secondNode.next = firstNode;
            if (lastNode != null) {
                lastNode.next = secondNode;
            } else {
                cur = secondNode;
            }
            lastNode = firstNode;

            if (lastNode.next != null) {
                queue.offer(lastNode.next);
                if (lastNode.next.next != null) {
                    queue.offer(lastNode.next.next);
                }
            }
        }
        return cur;

    }


    public static void main(String[] args) {
        ListNode head = new ListNode(1);
        ListNode head2 = new ListNode(2);
        ListNode head3 = new ListNode(3);
        ListNode head4 = new ListNode(4);
        head.next = head2;
        head.next.next = head3;
        head.next.next.next = head4;
        ListNode ss = swapPairs(head);
        System.out.println();
    }
}


class ListNode {
    int val;
    ListNode next;
    ListNode(int x) { val = x; }
}

class TreeNode {
    int val;
    TreeNode left;
    TreeNode right;
    TreeNode(int x) {
        val = x;
    }

    TreeNode () {

    }
}

