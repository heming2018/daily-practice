import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

/**
 * @author heming1
 * @date 2021/7/16 4:05 下午
 * 牛客NC50 链表中的节点每k个一组翻转
 * 将给出的链表中的节点每k个一组翻转，返回翻转后的链表
 * 如果链表中的节点数不是k的倍数，将最后剩下的节点保持原样
 * 你不能更改节点中的值，只能更改节点本身。
 * 要求空间复杂度O(1) O(1)
 * <p>
 * 给定的链表是1→2→3→4→5
 * 对于 k=2, 你应该返回 2->1->4->3->5
 * 对于 k=3, 你应该返回 3->2->1->4->5
 */
public class ReverseKGroup {
    private static final Logger logger = LoggerFactory.getLogger(ReverseKGroup.class);

    private class ListNode {
        int val;
        ListNode next = null;
    }

    /**
     * 1→2→3→4→5
     *
     */
    public ListNode reverseKGroup(ListNode head, int k) {
        // write code here

        int count = 0;
        ListNode curr = head;
        while (curr != null) {
            if (count == k - 1) {
                ListNode next = curr.next;
                curr.next = null;
//                reverse(he)
                count = 0;

            }
            count++;
            curr = curr.next;
        }
        return null;
    }
}