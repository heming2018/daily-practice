import java.util.HashMap;

/**
 * @author heming1
 * @date 2021/6/9 5:32 下午
 */
public class LruCache<K, V> {

    private int cacheCapcity;
    private HashMap<K, CacheNode> caches;
    private CacheNode first;
    private CacheNode last;

    public LruCache(int size) {
        this.cacheCapcity = size;
        caches = new HashMap<>(size);
    }

    public void put(K k, V v) {
        CacheNode node = caches.get(k);
        if (node == null) {
            if (caches.size() >= cacheCapcity) {
                caches.remove(last.key);
                removeLast();
            }
            node = new CacheNode();
            node.key = k;
        }
        node.value = v;
        moveToFirst(node);
        caches.put(k, node);
    }

    public Object get(K k) {
        CacheNode node = caches.get(k);
        if (node == null) {
            return null;
        }
        moveToFirst(node);
        return node.value;
    }

    public Object remove(K k) {
        CacheNode node = caches.get(k);
        if (node != null) {
            if (node.pre != null) {
                node.pre.next = node.next;
            }
            if (node.next != null) {
                node.next.pre = node.pre;
            }
            if (node == first) {
                first = node.next;
            }
            if (node == last) {
                last = node.pre;
            }
        }

        return caches.remove(k);
    }

    public void clear() {
        first = null;
        last = null;
        caches.clear();
    }


    private void moveToFirst(CacheNode node) {
        // 如果第一次进来
        if (first == null || last == null) {
            first = node;
            last = node;
        }
        // 如果就是首节点
        if (node == first) {
            return;
        }
        // 如果当前节点是尾节点，尾节点指向当前节点的pre指针
        if (node == last) {
            last = node.pre;
        }

        // 当前节点next节点的pre指向当前节点的pre
        if (node.next != null) {
            node.next.pre = node.pre;
        }
        // 当前节点pre节点的next指针指向当前节点的next
        if (node.pre != null) {
            node.pre.next = node.next;
        }

        // 当前节点的next指针指向first节点
        node.next = first;
        first.pre = node;
        first = node;
        // 头节点的pre指针指向当前节点的next指针
        first.pre = null;
    }

    private void removeLast() {
        if (last != null) {
            last = last.pre;
            if (last == null) {
                first = null;
            } else {
                last.next = null;
            }
        }
    }

    @Override
    public String toString() {
        StringBuilder sb = new StringBuilder();
        CacheNode node = first;
        while (node != null) {
            sb.append(String.format("%s:%s ", node.key, node.value));
            node = node.next;
        }

        return sb.toString();
    }

    class CacheNode {
        CacheNode pre;
        CacheNode next;
        Object key;
        Object value;

        public CacheNode() {

        }
    }

    public static void main(String[] args) {

        LruCache<Integer, String> lru = new LruCache<Integer, String>(3);
        lru.put(1, "a");
        System.out.println(lru.toString());
        lru.put(2, "b");    // 2:b 1:a
        System.out.println(lru.toString());
        lru.put(3, "c");    // 3:c 2:b 1:a
        System.out.println(lru.toString());
        lru.put(4, "d");    // 4:d 3:c 2:b
        System.out.println(lru.toString());
        lru.put(1, "aa");   // 1:aa 4:d 3:c
        System.out.println(lru.toString());
        lru.put(2, "bb");   // 2:bb 1:aa 4:d
        System.out.println(lru.toString());
        lru.put(5, "e");    // 5:e 2:bb 1:aa
        System.out.println(lru.toString());
        lru.get(1);         // 1:aa 5:e 2:bb
        System.out.println(lru.toString());
        lru.remove(11);     // 1:aa 5:e 2:bb
        System.out.println(lru.toString());
        lru.remove(1);      //5:e 2:bb
        System.out.println(lru.toString());
        lru.put(1, "aaa");  //1:aaa 5:e 2:bb
        System.out.println(lru.toString());
    }

}