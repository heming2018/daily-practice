import java.util.ArrayList;
import java.util.List;

/**
 * @author heming
 * @date 2019/11/17 22:06
 * @description
 * 输入一个链表，输出一个链表，该输出链表包含原链表中从倒数第k个结点至尾节点的全部节点。
 * 如果该链表长度小于k，请返回一个长度为 0 的链表。
 */
public class FindKthToTail {

    public static class ListNode {
        int val;
        ListNode next = null;

        ListNode(int val) {
            this.val = val;
        }
    }

    /**
     * 常规解法
     */
    public static ListNode FindKthToTail(ListNode head, int k) {
        List<ListNode> list = new ArrayList<ListNode>();
        while (head != null) {
            list.add(head);
            head = head.next;
        }
        int index = list.size() - k;
        if (index >= 0 && index < list.size()) {
            return list.get(index);
        } else {
            return null;
        }

    }

    /**
     * 常规解法
     */
    public static ListNode FindKthToTail2(ListNode head, int k) {

        if (head == null || k <= 0) {
            return null;
        }
        // 两个指针，指针2先走k步，然后两指针一起走，当在前的指针位置为size-1，则指针1位置为结果
        ListNode i1 = head;
        ListNode i2 = head;
        int count = 0;

        while (count < k - 1) {
            // 走下一步之前，要判断下一步是不是空节点，如果是，说明链表的长度小于k，则返回null
            if (i2.next == null) {
                return null;
            }
            i2 = i2.next;
            count++;
        }
        if (i2 == null) {
            return null;
        }
        while (i2.next != null) {
            i1 = i1.next;
            i2 = i2.next;
        }

        return i1;

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

        ListNode listNode = FindKthToTail2(i1, 6);
        System.out.println(listNode);

    }
}