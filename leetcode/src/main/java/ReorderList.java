import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

/**
 * @author heming1
 * @date 2021/7/15 10:50 下午
 * 143. 重排链表
 * 给定一个单链表L：L0→L1→…→Ln-1→Ln ，
 * 将其重新排列后变为： L0→Ln→L1→Ln-1→L2→Ln-2→…
 *
 * 你不能只是单纯的改变节点内部的值，而是需要实际的进行节点交换。
 * 示例 1:
 * 给定链表 1->2->3->4, 重新排列为 1->4->2->3.
 */
public class ReorderList {
    private static final Logger logger = LoggerFactory.getLogger(ReorderList.class);

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

    public void reorderList(ListNode head) {
        if (head == null || head.next == null) {
            return;
        }
        ListNode mid = findMid(head);

        ListNode l2 = mid.next;
        mid.next = null;
        l2 = reverse(l2);
        ListNode l1 = head;
        // l1: 1 -> 2
        // l2: 4 -> 3
        while (l1 != null && l2 != null) {
            ListNode l1Next = l1.next;
            ListNode l2Next = l2.next;
            l1.next = l2;
            l1.next.next = l1Next;

            l1 = l1Next;
            l2 = l2Next;
        }
    }

    private ListNode reverse(ListNode head) {
        ListNode newHead = null;
        while (head != null) {
            ListNode next = head.next;
            head.next = newHead;

            newHead = head;
            head = next;
        }
        return newHead;
    }

    private ListNode findMid(ListNode head) {
        ListNode fast = head;
        ListNode slow = head;
        while (fast != null && fast.next != null) {
            fast = fast.next.next;
            slow = slow.next;
        }
        return slow;
    }
}