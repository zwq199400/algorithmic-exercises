import java.util.ArrayList;
import java.util.List;

/**
 * @author zhouwq
 * @date 2020/12/8 21:35
 */

public class Test39 {

    //给定一个无重复元素的数组 candidates 和一个目标数 target ，找出 candidates 中所有可以使数字和为 target 的组合。
//
// candidates 中的数字可以无限制重复被选取。
//
// 说明：
//
//
// 所有数字（包括 target）都是正整数。
// 解集不能包含重复的组合。
//
//
// 示例 1：
//
// 输入：candidates = [2,3,6,7], target = 7,
//所求解集为：
//[
//  [7],
//  [2,2,3]
//]
//
//
// 示例 2：
//
// 输入：candidates = [2,3,5], target = 8,
//所求解集为：
//[
//  [2,2,2,2],
//  [2,3,3],
//  [3,5]
//]
//
//
//
// 提示：
//
//
// 1 <= candidates.length <= 30
// 1 <= candidates[i] <= 200
// candidate 中的每个元素都是独一无二的。
// 1 <= target <= 500
//
// Related Topics 数组 回溯算法
// 👍 1083 👎 0

    public static void main(String[] args) {
        List<List<Integer>> re = combinationSum(new int[]{2,3,6,7}, 7);
        System.out.println(re);
    }

    public static List<List<Integer>> combinationSum(int[] candidates, int target) {
        List<List<Integer>> result = new ArrayList<>();
//        dfs(target, new ArrayList<>(), candidates, result, 0);
        dfs2(target, new ArrayList<>(), candidates, result, 0);
        return result;
    }
    private static void dfs(int target, List<Integer> list, int[] candidates, List<List<Integer>> result, int idx) {
        if (idx == candidates.length) {
            return;
        }
        if (target == 0) {
            result.add(new ArrayList<>(list));
            return;
        }
        dfs(target, list, candidates, result, idx + 1);
        if (target - candidates[idx] >= 0) {
            list.add(candidates[idx]);
            dfs(target - candidates[idx], list, candidates, result, idx);
            list.remove(list.size() - 1);
        }
    }

    private static void dfs2(int target, List<Integer> list, int[] candidates, List<List<Integer>> result, int idx) {
        if (target == 0) {
            result.add(new ArrayList<>(list));
            return;
        }
        if (target < 0) {
            return;
        }
        for (int i = idx; i < candidates.length; i++) {
            list.add(candidates[i]);
            dfs2(target - candidates[i], list, candidates, result, i);
            list.remove(list.size() - 1);
        }
    }
}
