public class MergeLinkedList {

    public static void main(String[] args) {
        /**
         * 给定一个单向链表的头节点head，节点的值类型是整型，再给定一个整 数pivot。实现一个调整链表的函数，将链表调整为左部分都是值小于 pivot的节点，中间部分都是值等于pivot的节点，
         * 右部分都是值大于 pivot的节点。除这个要求外，对调整后的节点顺序没有更多的要求。
         * 例如：链表9->0->4->5->1，pivot=3。 调整后链表可以是1->0->4->9->5，也可以是0->1->9->5->4。
         * 总之，满 足左部分都是小于3的节点，中间部分都是等于3的节点（本例中这个部 分为空），右部分都是大于3的节点即可。对某部分内部的节点顺序不做 要求。
         */
        ListNode head = new ListNode(9);
        head.next = new ListNode(0);
        head.next.next = new ListNode(4);
        head.next.next.next = new ListNode(5);
        head.next.next.next.next = new ListNode(1);
        ListNode result = merge2(head, 4);
        System.out.println();
    }

    private static ListNode merge(ListNode node, int pivot) {
        ListNode cur = node;
        int length = 0;
        while (cur != null) {
            length++;
            cur = cur.next;
        }
        ListNode[] nodeArr = new ListNode[length];
        ListNode result = node;
        for (int i = 0; i < length; i++) {
            nodeArr[i] = result;
            result = result.next;
        }

        int first = 0;
        int end = length - 1;
        while (first < end) {
            if (nodeArr[end].val < pivot) {
                if (nodeArr[first].val > pivot) {
                    swap(nodeArr, first, end);
                } else {
                    first++;
                }
            } else {
                end--;
            }
        }
        ListNode mergeNode = nodeArr[0];
        ListNode temp = mergeNode;
        //最终链表连接
        for (int i = 1; i < length; i++) {
            temp.next = nodeArr[i];
            temp = temp.next;
        }
        temp.next = null;
        return mergeNode;
    }

    private static ListNode merge2(ListNode node, int pivot) {
        //小于区
        ListNode a1 = null;
        ListNode a1End = null;
        //等于区
        ListNode a2 = null;
        ListNode a2End = null;
        //大于区
        ListNode a3 = null;
        ListNode a3End = null;

        ListNode temp = node;
        while (temp != null) {
            if (temp.val < pivot) {
                if (a1End == null) {
                    a1 = temp;
                    a1End = temp;
                } else {
                    a1End.next = temp;
                    a1End = temp;
                }
            } else if (temp.val > pivot) {
                if (a3End == null) {
                    a3 = temp;
                    a3End = temp;
                } else {
                    a3End.next = temp;
                    a3End = temp;
                }
            } else {
                if (a2End == null) {
                    a2 = temp;
                    a2End = temp;
                } else {
                    a2End.next = temp;
                    a2End = temp;
                }
            }
            temp = temp.next;
        }

        if (a1End != null) {
            a1End.next = null;
        }
        if (a2End != null) {
            a2End.next = null;
        }
        if(a3End != null) {
            a3End.next = null;
        }
        //拼接
        if (a1End != null) {
            if (a2End != null) {
                a1End.next = a2;
                if (a3End != null) {
                    a2End.next = a3;
                }
            } else if (a3End != null) {
                a1End.next = a3;
            }
        } else if (a2End != null) {
            if (a3End != null) {
                a2End.next = a3;
            }
        }

        return a1End == null ? (a2End == null ? a3 : a2) : a1;

    }

    private static void swap(ListNode[] arr, int a1, int a2) {
        ListNode temp = arr[a1];
        arr[a1] = arr[a2];
        arr[a2] = temp;
    }
}
