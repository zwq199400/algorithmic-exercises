import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/**
 * @author zhouwq
 * @date 2020/12/8 21:35
 */

public class Test40 {
    public static void main(String[] args) {
        List<List<Integer>> re = combinationSum(new int[]{2,5,2,1,2}, 5);
        System.out.println(re);
    }

    public static List<List<Integer>> combinationSum(int[] candidates, int target) {
        List<List<Integer>> result = new ArrayList<>();
        Arrays.sort(candidates);
        boolean[] used = new boolean[candidates.length];
        dfs(target, new ArrayList<>(), candidates, result, 0, used);
        return result;
    }
    private static void dfs(int target, List<Integer> list, int[] candidates, List<List<Integer>> result, int idx, boolean[] used) {
        if (idx == candidates.length) {
            return;
        }
        if (target == 0) {
            result.add(new ArrayList<>(list));
            return;
        }
        dfs(target, list, candidates, result, idx + 1, used);
        if (idx > 0 && candidates[idx] == candidates[idx - 1] && !used[idx - 1]) {
            return;
        }
        if (!used[idx] && target - candidates[idx] >= 0) {
            used[idx] = true;
            list.add(candidates[idx]);
            dfs(target - candidates[idx], list, candidates, result, idx, used);
            list.remove(list.size() - 1);
            used[idx] = false;
        }
    }
}
