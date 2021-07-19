package nowcoder;

import java.util.ArrayList;
import java.util.HashMap;

/**
 * @author heming1
 * @date 2021/7/18 5:25 下午
 * @description NC93 设计LRU缓存结构
 *
 * 设计LRU缓存结构，该结构在构造时确定大小，假设大小为K，并有如下两个功能
 * set(key, value)：将记录(key, value)插入该结构
 * get(key)：返回key对应的value值
 * [要求]
 * set和get方法的时间复杂度为O(1)
 * 某个key的set或get操作一旦发生，认为这个key的记录成了最常使用的。
 * 当缓存的大小超过K时，移除最不经常使用的记录，即set或get最久远的。
 * 若opt=1，接下来两个整数x, y，表示set(x, y)
 * 若opt=2，接下来一个整数x，表示get(x)，若x未出现过或已被移除，则返回-1
 * 对于每个操作2，输出一个答案
 */
public class NC93_LRU {

    public static void main(String[] args) {
        int[][] ops = {{1, 1, 1}, {1, 2, 2}, {1, 3, 2}, {2, 1}, {1, 4, 4}, {2, 2}};
        NC93_LRU nc93_lru = new NC93_LRU();
        System.out.println(nc93_lru.LRU(ops, 3));
    }

    /**
     * lru design
     *
     * @param operators int整型二维数组 the operators
     * @param k         int整型 the k
     * @return int整型一维数组
     */
    public int[] LRU(int[][] operators, int k) {
        // write code here
        this.capacity = k;
        this.head.next = end;
        this.end.pre = head;

        ArrayList<Integer> list = new ArrayList<>();
        for (int i = 0; i < operators.length; i++) {
            if (operators[i][0] == 1) {
                set(operators[i][1], operators[i][2]);
            } else if (operators[i][0] == 2) {
                list.add(get(operators[i][1]));
            }
        }
        int[] res = new int[list.size()];
        for (int i = 0; i < list.size(); i++) {
            res[i] = list.get(i);
        }
        return res;
    }

    class ListNode {
        ListNode pre;
        ListNode next;
        int key;
        int val;

        ListNode(int k, int v) {
            this.key = k;
            this.val = v;
        }
    }

    HashMap<Integer, ListNode> map = new HashMap<>();
    ListNode head = new ListNode(-1, -1);
    ListNode end = new ListNode(-1, -1);
    int capacity;

    void set(int k, int v) {
        ListNode node = map.get(k);
        if (node == null) {
            if (map.size() >= capacity) {
                removeLast();
            }
            ListNode addNode = new ListNode(k, v);
            add2First(addNode);
        } else {
            node.val = v;
            move2First(node);
        }
    }

    int get(int k) {
        ListNode node = map.get(k);
        if (node != null) {
            move2First(node);
            return node.val;
        }
        return -1;
    }

    // 移动节点到第一位
    // node
    // head -> first -> first.next
    void move2First(ListNode node) {
        node.pre.next = node.next;
        node.next.pre = node.pre;

        node.pre = head;
        node.next = head.next;

        head.next.pre = node;
        head.next = node;
    }

    // 删除最后一个节点
    // pre -> last -> end
    void removeLast() {
        ListNode last = end.pre;
        map.remove(last.key);

        last.pre.next = end;
        end.pre = last.pre;
    }

    // 添加节点到第一位
    void add2First(ListNode node) {
        // 链表处理
        ListNode next = head.next;
        node.next = next;
        next.pre = node;

        head.next = node;
        node.pre = head;
        // map处理
        map.put(node.key, node);
    }

}