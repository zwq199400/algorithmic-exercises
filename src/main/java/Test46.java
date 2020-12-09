import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

/**
 * @author zhouwq
 * @date 2020/12/8 21:35
 */

public class Test46 {

    public static void main(String[] args) {
        List<List<Integer>> re = combinationSum(new int[]{1,2,3});
        System.out.println(re);
    }


    public static List<List<Integer>> combinationSum(int[] nums) {
        List<List<Integer>> result = new ArrayList<>();
        boolean[] used = new boolean[nums.length];
        dfs(nums, 0, result, new ArrayList<>(), used);
        return result;
    }

    private static void dfs(int[] nums, int idx, List<List<Integer>> result, List<Integer> node, boolean[] used) {
        if (idx == nums.length) {
            result.add(new ArrayList<>(node));
            return;
        }
        for(int i = 0; i < nums.length; i++) {
            if (!used[i]) {
                node.add(nums[i]);
                used[i] = true;
                dfs(nums, idx + 1, result, node, used);
                node.remove(node.size() - 1);
                used[i] = false;
            }
        }
    }
}
