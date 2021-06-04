import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

/**
 * @author heming1
 * @date 2021/6/4 2:17 下午
 * @description 死锁实例
 */
public class DeadLock implements Runnable {
    private static final Logger logger = LoggerFactory.getLogger(DeadLock.class);

    private boolean flag;
    private String name;

    private static final String RES1 = "";
    private static final String RES2 = "";

    public DeadLock(boolean flag, String name) {
        this.flag = flag;
        this.name = name;
    }

    @Override
    public void run() {
        if (flag) {
            System.out.println(name + "开始获取资源RES1");
            synchronized (RES1) {
                System.out.println(name + "获取到资源RES1！");
                try {
                    Thread.sleep(300000);
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
                System.out.println(name + "开始获取资源RES2");
                synchronized (RES2) {
                    System.out.println(name + "获取到资源RES2！");
                }
            }

        } else {
            System.out.println(name + "开始获取资源RES2");
            synchronized (RES2) {
                System.out.println(name + "获取到资源RES2！");
                try {
                    Thread.sleep(300000);
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
                System.out.println(name + "开始获取资源RES1");
                synchronized (RES1) {
                    System.out.println(name + "获取到资源RES1！");
                }
            }

        }
    }

    public static void main(String[] args) {
        Thread thread1 = new Thread(new DeadLock(true, "线程1："));
        Thread thread2 = new Thread(new DeadLock(false, "线程2："));
        thread1.start();
        thread2.start();
    }
}