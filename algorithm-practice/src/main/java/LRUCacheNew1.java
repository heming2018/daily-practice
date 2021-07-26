import java.util.HashMap;

/**
 * @author heming1
 * @date 2021/7/14 6:03 下午
 * 
 */
public class LRUCacheNew1 {

    HashMap<Integer, LRUCacheNewNode1> map = new HashMap<>();
    LRUCacheNewNode1 first = new LRUCacheNewNode1();
    LRUCacheNewNode1 last = new LRUCacheNewNode1();
    int capacity;

    static class LRUCacheNewNode1 {
        LRUCacheNewNode1 pre;
        LRUCacheNewNode1 next;
        int key;
        int value;

        LRUCacheNewNode1(int key, int value) {
            this.key = key;
            this.value = value;
        }

        LRUCacheNewNode1() {
        }
    }

    public LRUCacheNew1(int capacity) {
        this.capacity = capacity;
        LRUCacheNewNode1 first = new LRUCacheNewNode1();
        LRUCacheNewNode1 last = new LRUCacheNewNode1();
        first.next = last;
        last.pre = first;
    }

    public int get(int key) {
        LRUCacheNewNode1 node = map.get(key);
        if (node != null) {
            move2First(node);
            return node.value;
        } else {
            return -1;
        }
    }

    public void put(int key, int value) {
        LRUCacheNewNode1 curr = map.get(key);
        if (curr == null) {
            if (map.size() >= capacity) {
                removeLast();
                map.remove(key);
            }
            LRUCacheNewNode1 node = new LRUCacheNewNode1(key, value);
            map.put(key, node);
            move2First(node);
        } else {
            curr.value = value;
            move2First(curr);
        }
    }

    private void move2First(LRUCacheNewNode1 node) {
        node.pre = first;
        node.next = first.next;

        first.next = node;
        first.next.pre = node;
    }

    private void removeLast() {
        if (last.pre != null) {
            last.pre = last.pre.pre;
            last.pre.pre.next = last;
        }
    }

}