package volatileTest;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

/**
 * @author heming
 * @date 2019/11/23 18:22
 * 
 */
public class Connection {
    private static final Logger logger = LoggerFactory.getLogger(Connection.class);

    private static Boolean initialized = false;

    public static Boolean getInitialized() {
        return initialized;
    }

    public void init() {
        initialized = true;
        try {
            Thread.sleep(50000);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }

    public static void main(String[] args) {
        Connection connection = new Connection();
        Runnable runnable = new Runnable() {
            @Override
            public void run() {
                connection.init();
                System.out.println("ok1");
            }
        };
        Thread thread = new Thread(runnable);
        thread.start();
        Runnable runnable1 = new Runnable() {
            @Override
            public void run() {
                Connection.getInitialized();
                System.out.println("ok2");
            }
        };
        Thread thread1 = new Thread(runnable1);
        thread1.start();

    }


}