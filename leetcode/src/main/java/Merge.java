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
     * @param list1
     * @param list2
     * @return
     */
    public static ListNode Merge(ListNode list1, ListNode list2) {
        if (list1 == null) {
            return list2;
        }
        if (list2 == null) {
            return list1;
        }

        ListNode res = new ListNode(Math.min(list1.val, list2.val));
        if (res.val == list1.val) {
            list1 = list1.next;
        } else {
            list2 = list2.next;
        }

        ListNode lastNode = res;

        while (list1 != null && list2 != null) {
            int min = Math.min(list1.val, list2.val);
            if (min == list1.val) {
                lastNode.next = list1;
                list1 = list1.next;
            } else {
                lastNode.next = list2;
                list2 = list2.next;
            }
            lastNode = lastNode.next;
        }
        if (list1 != null) {
            lastNode.next = list1;
        }
        if (list2 != null) {
            lastNode.next = list2;
        }

        return res;
    }

    public static class ListNode {
        int val;
        ListNode next = null;

        ListNode(int val) {
            this.val = val;
        }
    }
}