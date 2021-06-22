import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

/**
 * @author heming
 * @date 2019/11/25 22:34
 * @description 输入两个单调递增的链表，输出两个链表合成后的链表，当然我们需要合成后的链表满足单调不减规则。
 */
public class Merge {
    private static final Logger logger = LoggerFactory.getLogger(Merge.class);


    public static void main(String[] args) {

        ListNode i11 = new ListNode(1);
        ListNode i12 = new ListNode(4);
        ListNode i13 = new ListNode(5);

        ListNode i21 = new ListNode(5);
        ListNode i22 = new ListNode(6);
        ListNode i23 = new ListNode(7);
        ListNode i24 = new ListNode(8);

        i11.next = i12;
        i12.next = i13;

        i21.next = i22;
        i22.next = i23;
        i23.next = i24;

        ListNode listNode = Merge(i11, i21);
        System.out.println(listNode);

    }

    /**
     * 个人解法：
     * 先遍历两个链表，直到一条链表为空，然后将非空的那条链表追加到结果后面
     *
     * @param l1
     * @param l2
     * @return
     */
    public static ListNode Merge(ListNode l1, ListNode l2) {
        if (l1 == null && l2 == null) {
            return null;
        }

        ListNode head = new ListNode(0);
        ListNode curr = head;
        while (l1 != null && l2 != null) {
            if (curr.next == null) {
                curr.next = new ListNode(0);
            }

            if (l1.val < l2.val) {
                curr.next.val = l1.val;
                l1 = l1.next;
            } else {
                curr.next.val = l2.val;
                l2 = l2.next;
            }
            curr = curr.next;
        }

        if (l1 == null) {
            curr.next = l2;
        }
        if (l2 == null) {
            curr.next = l1;
        }
        return head.next;
    }

    public static ListNode Merge1(ListNode list1, ListNode list2) {
        ListNode rootBefore = new ListNode(0);

        ListNode curr = rootBefore;
        while (list1 != null && list2 != null) {
            if (list1.val < list2.val) {
                curr.next = list1;
                list1 = list1.next;
            } else {
                curr.next = list2;
                list2 = list2.next;
            }
            curr = curr.next;
        }
        if (list1 != null) {
            curr.next = list1;
        }
        if (list2 != null) {
            curr.next = list2;
        }
        return rootBefore.next;
    }

    public static class ListNode {
        int val;
        ListNode next = null;

        ListNode(int val) {
            this.val = val;
        }
    }
}