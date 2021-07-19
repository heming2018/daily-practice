import java.util.HashMap;

/**
 * @author heming1
 * @date 2021/7/14 3:40 下午
 */
public class LRUCacheNew {

    HashMap<Integer, LRUCacheNewNode> map = new HashMap<>();
    LRUCacheNewNode first;
    LRUCacheNewNode last;
    int capacity;

    static class LRUCacheNewNode {
        LRUCacheNewNode pre;
        LRUCacheNewNode next;
        int key;
        int value;

        LRUCacheNewNode(int key, int value) {
            this.key = key;
            this.value = value;
        }

        LRUCacheNewNode() {
        }
    }

    public LRUCacheNew(int capacity) {
        this.capacity = capacity;
    }

    public int get(int key) {
        LRUCacheNewNode node = map.get(key);
        if (node == null) {
            return -1;
        }

        move2first(node);
        return node.value;
    }

    public void put(int key, int value) {
        LRUCacheNewNode curr = map.get(key);
        if (curr == null) {
            if (map.size() >= capacity) {
                map.remove(last.key);
                removeLastNode();
            }
            LRUCacheNewNode node = new LRUCacheNewNode(key, value);
            map.put(key, node);
            move2first(node);
        } else {
            curr.value = value;
            move2first(curr);
        }
    }

    private void move2first(LRUCacheNewNode node) {
        if (first == null || last == null) {
            first = node;
            last = node;
            return;
        }

        if (node.next != null) {
            node.next.pre = node.pre;
        }
        if (node.pre != null) {
            node.pre.next = node.next;
        }

        node.pre = null;
        node.next = first;
        first.pre = node;
        first = node;
    }

    private void removeLastNode() {
        // last节点前置节点变成last节点
        if (last != null) {
            last = last.pre;
            if (last != null) {
                last.next = null;
            }
        }
    }

    public static void main(String[] args) {
        LRUCacheNewNode node = new LRUCacheNewNode(1,2);
        LRUCacheNewNode first = new LRUCacheNewNode(3,4);
        first.next = new LRUCacheNewNode(5, 6);

        node.pre = null;
        node.next = first;
        first.pre = node;
        first = node;

        System.out.println(first);
    }
}