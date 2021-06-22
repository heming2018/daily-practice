import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.util.concurrent.locks.ReentrantLock;

/**
 * @author heming1
 * @date 2021/6/20 3:05 上午
 * @description TODO
 */
public class ReentrantLockTest implements Runnable {
    private static final Logger logger = LoggerFactory.getLogger(ReentrantLockTest.class);
    private ReentrantLock lock;

    private String sleep;

    public ReentrantLockTest(ReentrantLock lock, String sleep) {
        this.lock = lock;
        this.sleep = sleep;
    }

    public static void main(String[] args) {
        ReentrantLock lock = new ReentrantLock();

        Thread t1 = new Thread(new ReentrantLockTest(lock, "持有锁线程1"));
        Thread t2 = new Thread(new ReentrantLockTest(lock, "抢夺锁线程2"));
        t1.start();
        t2.start();
    }

    @Override
    public void run() {
        System.out.println(sleep + "===开始获取锁");
        if ("抢夺锁线程2".equals(sleep)) {
            System.out.println(sleep + "===开始睡觉了");
            try {
                Thread.sleep(1000);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }
        lock.lock();
        try {
            System.out.println(sleep + "===获取到锁了");
            if ("持有锁线程1".equals(sleep)) {
                System.out.println(sleep + "===开始睡觉了");
                try {
                    Thread.sleep(3000);
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
            }
        } finally {
            lock.unlock();
            System.out.println(sleep + "===释放锁完成");
        }
    }
}