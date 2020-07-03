///**
// * @author zhouwq
// * @date 2019/8/30 15:47
// */
//
//public class BinaryTree {
//    /**
//     * 给定一个所有节点为非负值的二叉搜索树，求树中任意两节点的差的绝对值的最小值。
//     *
//     * 示例 :
//     *
//     * 输入:
//     *
//     *    1
//     *     \
//     *      3
//     *     /
//     *    2
//     *
//     * 输出:
//     * 1
//     *
//     * 解释:
//     * 最小绝对差为1，其中 2 和 1 的差的绝对值为 1（或者 2 和 3）。
//     * 注意: 树中至少有2个节点。
//     */
//
//
//    class Solution {
//        class util.TreeNode {
//            int val;
//            util.TreeNode left;
//            util.TreeNode right;
//
//            util.TreeNode(int x) {
//                val = x;
//            }
//        }
//
//        private int minResult;
//
//        public int getMinimumDifference(util.TreeNode root) {
//
//            int min = 0;
//        }
//
//        private int getMin(util.TreeNode root, int min){
//            int nowMin = 0;
//            util.TreeNode leftNode = root.left;
//            util.TreeNode rightNode = root.right;
//            if(leftNode == null && rightNode == null){
//                return min;
//            }
//            if(leftNode != null){
//                nowMin = Math.abs(leftNode.val - root.val);
//                getMin(leftNode, nowMin);
//            }
//            if(rightNode != null){
//                int rightMin = Math.abs(rightNode.val - root.val);
//                nowMin = rightMin < nowMin ? rightMin : nowMin;
//                getMin(rightNode, nowMin);
//            }
//
//        }
//    }
//}
