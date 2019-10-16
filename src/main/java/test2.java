import java.util.HashSet;
import java.util.Set;

/**
 * @author zhouwq
 * @date 2019/7/24 15:27
 */

public class test2 {
    /**
     * 给定一个链表，判断链表中是否有环。
     *
     * 为了表示给定链表中的环，我们使用整数 pos 来表示链表尾连接到链表中的位置（索引从 0 开始）。 如果 pos 是 -1，则在该链表中没有环。
     *
     *  
     *
     * 示例 1：
     *
     * 输入：head = [3,2,0,-4], pos = 1
     * 输出：true
     * 解释：链表中有一个环，其尾部连接到第二个节点。
     *
     *
     * 示例 2：
     *
     * 输入：head = [1,2], pos = 0
     * 输出：true
     * 解释：链表中有一个环，其尾部连接到第一个节点。
     *
     *
     * 示例 3：
     *
     * 输入：head = [1], pos = -1
     * 输出：false
     * 解释：链表中没有环。
     */

    class ListNode {
        int val;
        ListNode next;

        ListNode(int x) {
            val = x;
            next = null;
        }
    }
    public class Solution {
        public boolean hasCycle(ListNode head) {
            Set<ListNode> set = new HashSet<ListNode>();

            if(head != null){
                set.add(head);
                while (head.next != null){
                    if(set.contains(head.next)){
                        return true;
                    }else{
                        set.add(head.next);
                    }
                    head = head.next;
                }
            }
            return false;
        }

        public boolean hasCycle2(ListNode head) {

            if (head == null || head.next == null) {
                return false;
            }
            ListNode slow = head;
            ListNode fast = head.next;
            while (slow != fast) {
                if (fast == null || fast.next == null) {
                    return false;
                }
                slow = slow.next;
                fast = fast.next.next;
            }
            return true;
        }
    }

    /**
     * 给定一个链表，返回链表开始入环的第一个节点。 如果链表无环，则返回 null。
     *
     * 为了表示给定链表中的环，我们使用整数 pos 来表示链表尾连接到链表中的位置（索引从 0 开始）。 如果 pos 是 -1，则在该链表中没有环。
     *
     * 说明：不允许修改给定的链表。
     *
     *  
     *
     * 示例 1：
     *
     * 输入：head = [3,2,0,-4], pos = 1
     * 输出：tail connects to node index 1
     * 解释：链表中有一个环，其尾部连接到第二个节点。
     *
     *
     * 示例 2：
     *
     * 输入：head = [1,2], pos = 0
     * 输出：tail connects to node index 0
     * 解释：链表中有一个环，其尾部连接到第一个节点。
     *
     *
     * 示例 3：
     *
     * 输入：head = [1], pos = -1
     * 输出：no cycle
     * 解释：链表中没有环。
     */

    public ListNode detectCycle(ListNode head) {
        Set<ListNode> set = new HashSet<ListNode>();

        int idx = 0;
        if(head != null){
            set.add(head);
            while (head.next != null){
                if(set.contains(head.next)){
                    return head.next;
                }else{
                    set.add(head.next);
                }
                head = head.next;
            }
        }
        return null;
    }

    /**
     * 归并排序 快速排序 堆排序
     * 额外空间复杂度
     * O(N)  O(logN) O(1)
     * 三者的时间复杂度都是 O(N^logN)
     *
     *
     *
     * 归并排序：
     *
     */

}
