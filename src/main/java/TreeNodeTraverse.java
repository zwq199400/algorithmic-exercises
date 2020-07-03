import util.TreeNode;

import java.util.LinkedList;

/**
 * @author zhouwq
 * @date 2020/5/13 10:31
 */

public class TreeNodeTraverse {
    public static void main(String[] args) {
        TreeNode head = new TreeNode(5);
        TreeNode left = new TreeNode(1);
        TreeNode right = new TreeNode(3);
        head.right = right;
        head.left = left;
        TreeNode left1 = new TreeNode(7);
        TreeNode right1 = new TreeNode(8);
        head.left.left = left1;
        head.left.right = right1;
        TreeNode left2 = new TreeNode(10);
        TreeNode right2 = new TreeNode(12);
        head.right.left = left2;
        head.right.right = right2;
//        preOrderTraverse(head);
        System.out.println("--------");
        postOrderTraverse(head);
        System.out.println("--------");
        postOrderTraverseRecursion(head);
        System.out.println("--------");
        postOrderTraverse2(head);
    }

    /**
     * 先序遍历  根节点->左节点->右节点
     */
    private static void preOrderTraverse(TreeNode head) {
        LinkedList<TreeNode> stack = new LinkedList<>();

        stack.add(head);
        while (!stack.isEmpty()) {

            TreeNode temp = stack.removeFirst();
            if (temp.right != null) {
                stack.addFirst(temp.right);
            }
            if (temp.left != null) {
                stack.addFirst(temp.left);
            }
            System.out.println(temp.val);
        }
    }

    /**
     * 中序遍历  左节点->根节点->右节点
     */
    private static void inOrderTraverse(TreeNode head) {
        LinkedList<TreeNode> stack = new LinkedList<>();
        TreeNode cur = head;
        while (!stack.isEmpty() || cur != null) {
            if (cur != null) {
                stack.addFirst(cur);
                cur = cur.left;
            } else {
                cur = stack.removeFirst();
                System.out.println(cur.val);
                cur = cur.right;
            }
        }
    }

    /**
     * 后序遍历 左节点->右节点->根节点
     */
    private static void postOrderTraverse(TreeNode head) {
        LinkedList<TreeNode> stack = new LinkedList<>();
        LinkedList<TreeNode> set = new LinkedList<>();
        TreeNode cur = head;
        while (!stack.isEmpty() || cur != null) {
            if (cur != null) {
                stack.addFirst(cur);
                cur = cur.left;
            } else {
                TreeNode temp = stack.peekFirst();
                if (temp.right != null && !set.contains(temp)) {
                    cur = temp.right;
                    set.add(temp);
                } else {
                    System.out.println(temp.val);
                    stack.removeFirst();
                }
            }
        }
    }

    /**
     * 转换为先序遍历后  倒置打印结果
     * @param head
     */
    private static void postOrderTraverse2(TreeNode head) {
        LinkedList<TreeNode> stack = new LinkedList<>();

        LinkedList<Integer> result = new LinkedList<>();
        stack.add(head);
        while (!stack.isEmpty()) {

            TreeNode temp = stack.removeFirst();
            if (temp.left != null) {
                stack.addFirst(temp.left);
            }
            if (temp.right != null) {
                stack.addFirst(temp.right);
            }
            result.add(temp.val);
        }

        while (!result.isEmpty()) {
            System.out.println(result.pollLast());
        }
    }

    /**
     * 先序遍历  根节点->左节点->右节点
     */
    private static void preOrderTraverseRecursion(TreeNode head) {
        if (head == null) {
            return;
        }
        System.out.println(head.val);
        preOrderTraverseRecursion(head.left);
        preOrderTraverseRecursion(head.right);
    }

    /**
     * 中序遍历  左节点->根节点->右节点
     */
    private static void inOrderTraverseRecursion(TreeNode head) {
        if (head == null) {
            return;
        }
        inOrderTraverseRecursion(head.left);
        System.out.println(head.val);
        inOrderTraverseRecursion(head.right);
    }

    /**
     * 后序遍历 左节点->右节点->根节点
     */
    private static void postOrderTraverseRecursion(TreeNode head) {
        if (head == null) {
            return;
        }
        postOrderTraverseRecursion(head.left);
        postOrderTraverseRecursion(head.right);
        System.out.println(head.val);
    }
}
