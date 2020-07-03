import util.ListNode;

public class TowLinkedListIntersect {
    public static void main(String[] args) {
        //两个单链表相交的一系列问题
        //【 题目】 给定两个可能有环也可能无环的单链表， 头节点head1和head2。 请实现一个函数， 如果两个链表相交， 请返回相交的 第一个节点。 如果不相交， 返回null
        //【 要求】 如果两个链表长度之和为N， 时间复杂度请达到O(N)， 额外空间复杂度请达到O(1)。
        // 1->2->3->4->5->6->7->null
        ListNode head1 = new ListNode(1);
        head1.next = new ListNode(2);
        head1.next.next = new ListNode(3);
        head1.next.next.next = new ListNode(4);
        head1.next.next.next.next = new ListNode(5);
        head1.next.next.next.next.next = new ListNode(6);
        head1.next.next.next.next.next.next = new ListNode(7);


        // 0->9->8->6->7->null
        ListNode head2 = new ListNode(0);
        head2.next = new ListNode(9);
        head2.next.next = new ListNode(8);
        head2.next.next.next = head1.next.next.next.next.next; // 8->6


        // 1->2->3->4->5->6->7->4...
        head1 = new ListNode(1);
        head1.next = new ListNode(2);
        head1.next.next = new ListNode(3);
        head1.next.next.next = new ListNode(4);
        head1.next.next.next.next = new ListNode(5);
        head1.next.next.next.next.next = new ListNode(6);
        head1.next.next.next.next.next.next = new ListNode(7);
        head1.next.next.next.next.next.next = head1.next.next.next; // 7->4

        // 0->9->8->2...
        head2 = new ListNode(0);
        head2.next = new ListNode(9);
        head2.next.next = new ListNode(8);
        head2.next.next.next = head1.next; // 8->2
//        getIntersectNode(head1, head2);

        // 0->9->8->6->4->5->6..
        head2 = new ListNode(0);
        head2.next = new ListNode(9);
        head2.next.next = new ListNode(8);
        head2.next.next.next = head1.next.next.next.next.next; // 8->6
        getIntersectNode(head1, head2);

    }

    private static ListNode getIntersectNode(ListNode head1, ListNode head2) {

        ListNode loop1 = getLoopNode(head1);
        ListNode loop2 = getLoopNode(head2);

        ListNode resultNode;
        if (loop1 == null && loop2 == null) {
            //两个单链表
            resultNode = noLoopNode(head1, head2);
            System.out.println();
        } else if (loop1 != null && loop2 != null) {
            //两个有环链表
            resultNode = bothLoop(head1, head2, loop1, loop2);
        } else {
            //其中一个有环
            return null;
        }
        return null;
    }

    private static ListNode getLoopNode(ListNode listNode) {
        ListNode slow = listNode;
        ListNode fast = listNode;
        ListNode loopNode = null;
        while (slow != null && fast != null) {
            slow = slow.next;
            if (fast.next == null) {
                fast = null;
            } else {
                fast = fast.next.next;
            }
            if (fast == slow) {
                loopNode = slow.next;
                break;
            }
        }
        ListNode head = null;
        if (loopNode != null) {
            head = listNode;
            while (head != null) {
                if (head != fast) {
                    head = head.next;
                    fast = fast.next;
                } else {
                    return head;
                }
            }
        }
        return null;
    }

    private static ListNode noLoopNode(ListNode head1, ListNode head2) {
        if (head1 == null || head2 == null) {
            return null;
        }
        int i = 0;
        int x = 0;
        ListNode cur = head1;
        while (cur != null) {
            i++;
            cur = cur.next;
        }
        cur = head2;
        while (cur != null) {
            x++;
            cur = cur.next;
        }

        ListNode cur2 = i > x ? head1 : head2;
        cur = cur2 == head1 ? head2 : head1;
        int n = Math.abs(i - x);
        while (n != 0) {
            cur2 = cur2.next;
            n--;
        }

        while (cur2 != null && cur != null) {
            if (cur == cur2) {
                return cur;
            }
            cur = cur.next;
            cur2 = cur2.next;
        }
        return null;
    }

    private static ListNode bothLoop(ListNode head1, ListNode head2, ListNode loop1, ListNode loop2) {
        if (loop1 == loop2) {
            int i = 0;
            int x = 0;
            ListNode cur = head1;
            while (cur != loop1) {
                i++;
                cur = cur.next;
            }
            cur = head2;
            while (cur != loop1) {
                x++;
                cur = cur.next;
            }

            ListNode cur2 = i > x ? head1 : head2;
            cur = cur2 == head1 ? head2 : head1;
            int n = Math.abs(i - x);
            while (n != 0) {
                cur2 = cur2.next;
                n--;
            }

            while (cur2 != null && cur != null) {
                if (cur == cur2) {
                    return cur;
                }
                cur = cur.next;
                cur2 = cur2.next;
            }
        } else {

            ListNode cur = loop1;
            while (cur != loop2) {
                if (cur == null) {
                    return null;
                }
                cur = cur.next;
            }
            return loop1;
        }
        return null;
    }
}
