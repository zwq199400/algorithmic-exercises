package exercises;

import util.ListNode;

import java.util.Comparator;
import java.util.HashMap;
import java.util.LinkedList;
import java.util.Map;
import java.util.PriorityQueue;
import java.util.Queue;

/**
 * @author zhouwq
 * @date 2020/6/17 13:50
 */

public class MergeKLists {
    /**
     * 合并 k 个排序链表，返回合并后的排序链表。请分析和描述算法的复杂度。
     *
     * 示例:
     *
     * 输入:
     * [
     *   1->4->5,
     *   1->3->4,
     *   2->6
     * ]
     * 输出: 1->1->2->3->4->4->5->6
     */

    public ListNode mergeKLists(ListNode[] lists) {
        PriorityQueue<ListNode> queue = new PriorityQueue<ListNode>(Comparator.comparingInt(o -> o.val));

        ListNode result = new ListNode(0);
        for (int i = 0; i < lists.length; i++) {
            ListNode node = lists[i];
            if (node == null) {
                continue;
            }
            queue.offer(lists[i]);
        }

        ListNode cur = result;
        while (!queue.isEmpty()) {
            ListNode next = queue.poll();
            cur.next = next;
            cur = cur.next;
            if (next.next != null) {
                queue.offer(next.next);
            }
        }

        return result.next;
    }

    public ListNode mergeTwoLists(ListNode l1, ListNode l2) {
        ListNode result = new ListNode(0);

        ListNode listNode = result;
        while (l1 != null && l2 != null) {

            if (l1.val > l2.val) {
                listNode.next = l2;
                l2 = l2.next;
            } else {
                listNode.next = l1;
                l1 = l1.next;
            }
            listNode = listNode.next;
        }
        if (l1 != null) {
            listNode.next = l1;
        } else if (l2 != null) {
            listNode.next = l2;
        }

        return result.next;
    }
}
