import java.util.Stack;

public class PalindromeNode {
    public static void main(String[] args) {
        //给定一个链表的头节点head，请判断该链表是否为回文结构
        ListNode head = new ListNode(1);
        head.next = new ListNode(2);
        head.next.next = new ListNode(3);
        head.next.next.next = new ListNode(1);
        head.next.next.next.next = new ListNode(1);
        System.out.println(judge1(head));

    }

    private static boolean judge1(ListNode listNode) {

        Stack<ListNode> stack = new Stack<ListNode>();
        ListNode fastNode = listNode;
        ListNode flowNode = listNode;
        while (fastNode.next != null && fastNode.next.next != null) {
            flowNode = flowNode.next;
            fastNode = fastNode.next.next;
        }
        while (flowNode.next != null) {
            stack.push(flowNode.next);
            flowNode = flowNode.next;
        }
        while (!stack.isEmpty()) {
            if (stack.pop().val != listNode.val) {
                return false;
            }
            listNode = listNode.next;
        }
        return true;
    }
}
