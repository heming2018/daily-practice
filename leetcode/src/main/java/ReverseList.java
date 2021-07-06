import java.util.Stack;

/**
 * @author heming
 * @date 2019/11/17 22:06
 * @description 输入一个链表，反转链表后，输出新链表的表头。
 */
public class ReverseList {

    public static class ListNode {
        int val;
        ListNode next = null;

        ListNode(int val) {
            this.val = val;
        }
    }

    public ListNode reverseListNew(ListNode head) {
        if (head == null) {
            return null;
        }

        ListNode pre = null;
        ListNode curr = head;

        while (curr != null) {
            ListNode temp = curr.next;
            curr.next = pre;

            pre = curr;
            curr = temp;
        }

        return pre;
    }

    /**
     * 常规出栈解法
     */
    public static ListNode ReverseList(ListNode head) {
        Stack<ListNode> stack = new Stack<ListNode>();
        while (head != null) {
            stack.push(head);
            head = head.next;
        }
        ListNode newHead = null;
        if (!stack.isEmpty()) {
            newHead = stack.pop();
        }
        ListNode last = newHead;

        while (!stack.isEmpty()) {
            last.next = stack.pop();
            last = last.next;
        }

        if (last != null) {
            last.next = null;
        }

        return newHead;

    }

    /**
     * 循环替换next节点，依次反转
     */
    public static ListNode ReverseList1(ListNode head) {
        if (head == null) {
            return null;
        }
        ListNode pre = null;
        ListNode curr = head;

        while (curr != null) {
            // 先把当前节点保留下来
            ListNode temp = curr.next;
            // 反转节点指向
            curr.next = pre;

            // 为下一次循环做数据准备
            pre = curr;
            curr = temp;
        }
        // 所有节点遍历完成之后，curr已经为空了，pre节点才是首节点
        return pre;
    }


    public static void main(String[] args) {

        ListNode i1 = new ListNode(1);
        ListNode i2 = new ListNode(2);
        ListNode i3 = new ListNode(3);
        ListNode i4 = new ListNode(4);
        ListNode i5 = new ListNode(5);

        i1.next = i2;
        i2.next = i3;
        i3.next = i4;
        i4.next = i5;

        ListNode listNode = ReverseList1(i1);
        System.out.println(listNode);

    }
}