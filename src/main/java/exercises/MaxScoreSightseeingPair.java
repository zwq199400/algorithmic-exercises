package exercises;

/**
 * @author zhouwq
 * @date 2020/6/17 9:37
 */

public class MaxScoreSightseeingPair {
    /**
     * 给定正整数数组 A，A[i] 表示第 i 个观光景点的评分，并且两个景点 i 和 j 之间的距离为 j - i。
     *
     * 一对景点（i < j）组成的观光组合的得分为（A[i] + A[j] + i - j）：景点的评分之和减去它们两者之间的距离。
     *
     * 返回一对观光景点能取得的最高分。
     *
     *  
     *
     * 示例：
     *
     * 输入：[8,1,5,2,6]
     * 输出：11
     * 解释：i = 0, j = 2, A[i] + A[j] + i - j = 8 + 5 + 0 - 2 = 11
     *  
     *
     * 提示：
     *
     * 2 <= A.length <= 50000
     * 1 <= A[i] <= 1000
     * @param A
     * @return
     */
    public static int maxScoreSightseeingPair(int[] A) {
        if (A == null) {
            return 0;
        }
        int max = A[0];
        int sum = 0;
        for (int i = 1; i < A.length; ++i) {
            sum = Math.max(sum, A[i] - i + max);
            max = Math.max(A[i] + i, max);
        }
        return sum;
    }

    public static void main(String[] args) {
        int a = maxScoreSightseeingPair(new int[]{8,1,5,2,6});
        System.out.println(a);
    }
}
