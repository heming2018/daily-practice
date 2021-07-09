import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.util.HashSet;
import java.util.List;
import java.util.Set;

/**
 * @author heming1
 * @date 2021/7/8 4:54 下午
 *
 * 判断给定的链表中是否有环。如果有环则返回true，否则返回false。
 * 你能给出空间复杂度O(1)的解法么？
 * 输入分为2部分，第一部分为链表，第二部分代表是否有环，然后回组成head头结点传入到函数里面。-1代表无环，其他的数字代表有环，这些参数解释仅仅是为了方便读者自测调试
 *
 * 示例1
 * 输入：{3,2,0,-4},1
 * 返回值：true
 * 说明：
 * 第一部分{3,2,0,-4}代表一个链表，第二部分的1表示，-4到位置1，即-4->2存在一个链接，组成传入的head为一个带环的链表 ,返回true
 *
 */
public class HasCycle {
    private static final Logger logger = LoggerFactory.getLogger(HasCycle.class);

    public static class ListNode {
        int val;
        ListNode next = null;

        ListNode(int val) {
            this.val = val;
        }
    }

    /**
     * {-21,10,17,8,4,26,5,35,33,-7,-16,27,-12,6,29,-12,5,9,20,14,14,2,13,-24,21,23,-21,5},-1
     * @param head
     * @return
     */
    public boolean hasCycle(ListNode head) {
        ListNode curr = head;
        Set<ListNode> list = new HashSet<>();
        while (curr != null) {
            if (list.contains(curr)) {
                return true;
            }
            list.add(curr);
            curr = curr.next;
        }
        return false;
    }

    public boolean hasCycle0(ListNode head) {
        ListNode fast = head;
        ListNode slow = head;

        while (fast != null && fast.next != null) {
            fast = fast.next.next;
            slow = slow.next;
            if (fast == slow) {
                return true;
            }
        }
        return false;
    }
}