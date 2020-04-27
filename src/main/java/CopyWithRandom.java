import java.util.HashMap;
import java.util.Map;

/**
 * @author zhouwq
 * @date 2020/4/26 21:48
 */

public class CopyWithRandom {
    public static void main(String[] args) {
        //复制含有随机指针节点的链表
        RandomNode head = null;
        System.out.println("=========================");

        head = new RandomNode(1);
        head.next = new RandomNode(2);
        head.next.next = new RandomNode(3);
        head.next.next.next = new RandomNode(4);
        head.next.next.next.next = new RandomNode(5);
        head.next.next.next.next.next = new RandomNode(6);

        head.rand = head.next.next.next.next.next; // 1 -> 6
        head.next.rand = head.next.next.next.next.next; // 2 -> 6
        head.next.next.rand = head.next.next.next.next; // 3 -> 5
        head.next.next.next.rand = head.next.next; // 4 -> 3
        head.next.next.next.next.rand = null; // 5 -> null
        head.next.next.next.next.next.rand = head.next.next.next; // 6 -> 4

        RandomNode randomNode = copyListNode(head);
        System.out.println("=========================");
    }

    private static RandomNode copyListNode(RandomNode listNode) {
        //新旧节点对象映射关系
        Map<RandomNode, RandomNode> hashNode = new HashMap<>(1 << 4);

        RandomNode curNode = listNode;
        while (curNode != null) {
            RandomNode newCopyNode = new RandomNode(curNode.value);
            hashNode.put(curNode, newCopyNode);
            curNode = curNode.next;
        }
        RandomNode result = new RandomNode(listNode.value);
        RandomNode temp = result;
        while (listNode != null) {
            temp.next = hashNode.get(listNode.next);
            temp.rand = hashNode.get(listNode.rand);
            listNode = listNode.next;
            temp = temp.next;
        }
        return result;

    }

    private static RandomNode copyListNode2(RandomNode listNode) {
        //新旧节点对象映射关系
        Map<RandomNode, RandomNode> hashNode = new HashMap<>(1 << 4);

        RandomNode curNode = listNode;
        while (curNode != null) {
            RandomNode newCopyNode = new RandomNode(curNode.value);
            hashNode.put(curNode, newCopyNode);
            curNode = curNode.next;
        }
        RandomNode result = new RandomNode(listNode.value);
        RandomNode temp = result;
        while (listNode != null) {
            temp.next = hashNode.get(listNode.next);
            temp.rand = hashNode.get(listNode.rand);
            listNode = listNode.next;
            temp = temp.next;
        }
        return result;

    }

    private static class RandomNode {
        public int value;
        public RandomNode next;
        public RandomNode rand;
        public RandomNode(int data) { this.value = data; }
    }
}
