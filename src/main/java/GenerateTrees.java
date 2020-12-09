import sun.reflect.generics.tree.Tree;

import java.util.ArrayList;
import java.util.List;

public class GenerateTrees {

    public static void main(String[] args) {
        /**
         * 给定一个整数 n，生成所有由 1 ... n 为节点所组成的二叉搜索树。
         *
         * 示例:
         *
         * 输入: 3
         * 输出:
         * [
         *   [1,null,3,2],
         *   [3,2,null,1],
         *   [3,1,null,null,2],
         *   [2,1,3],
         *   [1,null,2,null,3]
         * ]
         * 解释:
         * 以上的输出对应以下 5 种不同结构的二叉搜索树：
         *
         *    1         3     3      2      1
         *     \       /     /      / \      \
         *      3     2     1      1   3      2
         *     /     /       \                 \
         *    2     1         2                 3
         */
        List<TreeNode> treeNodes = generateTrees(3);
        System.out.println();
    }

    public static List<TreeNode> generateTrees(int n) {
        if (n == 0) {
            return new ArrayList<>();
        }
        return getList(1, n);
    }

    public static List<TreeNode> getList(int start, int end) {
        List<TreeNode> result = new ArrayList<>();
        if (start > end) {
            result.add(null);
            return result;
        }
        if (start == end) {
            result.add(new TreeNode(start));
            return result;
        }

        for (int i = start; i <= end; i++) {
            List<TreeNode> leftList = getList(start, i - 1);
            List<TreeNode> rightList = getList(i + 1, end);
            for (TreeNode left : leftList) {
                for (TreeNode right : rightList) {
                    TreeNode root = new TreeNode(i);
                    root.left = left;
                    root.right = right;
                    result.add(root);
                }
            }
        }
        return result;
    }
}
