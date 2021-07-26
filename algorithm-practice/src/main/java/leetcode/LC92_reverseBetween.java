package leetcode;

/**
 * @author heming1
 * @date 2021/7/26 3:01 下午
 * @description 92. 反转链表 II
 * https://leetcode-cn.com/problems/reverse-linked-list-ii/
 * 给你单链表的头指针 head 和两个整数left 和 right ，其中left <= right 。请你反转从位置 left 到位置 right 的链表节点，返回 反转后的链表 。
 */
public class LC92_reverseBetween {

    // 自己实现
    public ListNode reverseBetween0(ListNode head, int left, int right) {
        if (head == null) return head;
        ListNode dummpHead = new ListNode();
        dummpHead.next = head;
        ListNode pre = dummpHead;

        for (int i = 0; i < left - 1; i++) {
            pre = pre.next;
        }
        // leftNode是第一段链表的结尾
        ListNode leftNode = pre;
        // listHead是待反转链表的首节点
        ListNode listHead = pre.next;

        for (int i = 0; i < (right - left + 1); i++) {
            pre = pre.next;
        }
        // listEnd是待反转链表的尾结点
        ListNode listEnd = pre;
        // rightNode是第三段链表的首节点
        ListNode rightNode = pre.next;

        // 首尾去掉引用
        leftNode.next = null;
        listEnd.next = null;

        ListNode reverseList = reverseList(listHead);
        // 第一段和翻转后的链表首节点连接
        leftNode.next = reverseList;
        // 翻转后原来的首节点变成了尾结点，连接到第三段
        listHead.next = rightNode;

        return dummpHead.next;
    }
    // TODO 头插法暂时没有理解
    public ListNode reverseBetween1(ListNode head, int left, int right) {
        // 设置 dummyNode 是这一类问题的一般做法
        ListNode dummyNode = new ListNode(-1);
        dummyNode.next = head;
        ListNode pre = dummyNode;
        for (int i = 0; i < left - 1; i++) {
            pre = pre.next;
        }
        ListNode cur = pre.next;
        ListNode next;
        for (int i = 0; i < right - left; i++) {
            next = cur.next;
            cur.next = next.next;
            next.next = pre.next;
            pre.next = next;
        }
        return dummyNode.next;
    }

    ListNode reverseList(ListNode head) {
        ListNode curr = head;
        ListNode pre = null;

        while (curr != null) {
            ListNode next = curr.next;
            curr.next = pre;

            pre = curr;
            curr = next;
        }
        return pre;
    }

    private class ListNode {
        int val;
        ListNode next;

        ListNode() {
        }

        ListNode(int val) {
            this.val = val;
        }

        ListNode(int val, ListNode next) {
            this.val = val;
            this.next = next;
        }
    }


}