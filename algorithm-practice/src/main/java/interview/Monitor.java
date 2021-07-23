package interview;

import java.util.Map;
import java.util.concurrent.ConcurrentHashMap;
import java.util.concurrent.atomic.AtomicInteger;
import java.util.concurrent.atomic.AtomicLong;

/**
 * @author heming1
 * @date 2021/7/22 11:33 下午
 * @description 阅读以下代码，发现其中问题，
 * 答案参考：https://www.freesion.com/article/27211178923/
 * 问题1：
 * MonitorKey没有重写hashCode方法，会导致产生很多重复对象，
 * 解决办法：重写hashcode
 *
 * 问题2：
 * 位置1处，取出value，null判断并不是原子操作，高并发情况下，可能会出现多个线程拿到的都是null，然后new对象，会丢失其中一个请求
 * 解决办法：
 * 换成monitors.putIfAbsent(key, value);
 *
 */
public class Monitor {
    public static class MonitorKey {
        String key;
        String value;

        public MonitorKey(String key, String value) {
            this.key = key;
            this.value = value;
        }

//        @Override
//        public boolean equals(Object o) {
//            if (this == o) {
//                return true;
//            }
//            if (o == null || getClass() != o.getClass()) {
//                return false;
//            }
//
//            MonitorKey that = (MonitorKey) o;
//
//            if (key != null ? !key.equals(that.key) : that.key != null) {
//                return false;
//            }
//            return value != null ? value.equals(that.value) : that.value == null;
//        }
//
//        @Override
//        public int hashCode() {
//            int result = key != null ? key.hashCode() : 0;
//            result = 31 * result + (value != null ? value.hashCode() : 0);
//            return result;
//        }
    }

    public static class MonitorValue {
        AtomicInteger count = new AtomicInteger();
        float avgTime;
        AtomicLong totalTime = new AtomicLong();
    }

    private Map<MonitorKey, MonitorValue> monitors = new ConcurrentHashMap<>();

    public void visit(String url, String desc, long timeCost) {
        MonitorKey key = new MonitorKey(url, desc);
        MonitorValue value = monitors.get(key);
        // 位置1
        if (null == value) {
            value = new MonitorValue();
            monitors.put(key, value);
        }

//        MonitorValue value = monitors.putIfAbsent(key, new MonitorValue());
        value.count.getAndIncrement();
        value.totalTime.getAndAdd(timeCost);
        value.avgTime = value.totalTime.get() / value.count.get();
    }

    public static void main(String[] args) {
        Map<String, String> map = new ConcurrentHashMap<>();
        System.out.println(map.put("1", "1")); //out: null
        System.out.println(map.putIfAbsent("1", "2")); //out: 1
        System.out.println(map.get("1")); //out: 1
    }

}