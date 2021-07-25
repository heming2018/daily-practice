package leetcode;

/**
 * @author heming1
 * @date 2021/7/26 12:09 上午
 * @description 142. 环形链表 II
 * https://leetcode-cn.com/problems/linked-list-cycle-ii/
 * 给定一个链表，返回链表开始入环的第一个节点。如果链表无环，则返回null。
 * 为了表示给定链表中的环，我们使用整数 pos 来表示链表尾连接到链表中的位置（索引从 0 开始）。 如果 pos 是 -1，则在该链表中没有环。注意，pos 仅仅是用于标识环的情况，并不会作为参数传递到函数中。
 * 说明：不允许修改给定的链表。
 */
public class LC142_detectCycle {

    public ListNode detectCycle(ListNode head) {
        if (head == null) return null;
        if (head.next == null) return null;

        ListNode fast = head;
        ListNode slow = head;
        boolean hasCycle = false;
        while (fast != null && fast.next != null) {
            fast = fast.next.next;
            slow = slow.next;
            if (fast == slow) {
                hasCycle = true;
                break;
            }
        }
        if (hasCycle) {
            ListNode q = head;
            while (q != fast) {
                fast = fast.next;
                q = q.next;
            }
            return q;
        }
        return null;
    }

    private static class ListNode {
        int val;
        ListNode next;

        ListNode(int x) {
            val = x;
            next = null;
        }
    }
}