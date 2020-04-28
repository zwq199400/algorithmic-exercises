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

        RandomNode randomNode = copyListNode2(head);
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

        RandomNode curNode = listNode;
        while (curNode != null) {
            RandomNode newNode = new RandomNode(curNode.value);
            newNode.next = curNode.next;
            curNode.next = newNode;
            curNode = newNode.next;
        }

        curNode = listNode;
        int i = 1;
        RandomNode temp = null;
        while (curNode != null) {
            //偶数为新拷贝的链表节点
            if (i % 2 == 0) {
                curNode.rand = temp;
            } else {
                temp = curNode.rand;
            }
            i++;
            curNode = curNode.next;
        }

        RandomNode randomNode = new RandomNode(0);
        RandomNode result = randomNode;
        curNode = listNode;
        int j = 1;
        while (curNode != null) {
            if (j % 2 == 0) {
                result.next = curNode;
                result = result.next;
            }
            curNode = curNode.next;
            j++;
        }
        return randomNode.next;

    }

    private static class RandomNode {
        public int value;
        public RandomNode next;
        public RandomNode rand;
        public RandomNode(int data) { this.value = data; }
    }
}
