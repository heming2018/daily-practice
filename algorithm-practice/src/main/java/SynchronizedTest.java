import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

/**
 * @author heming1
 * @date 2021/7/8 1:16 上午
 * 
 */
public class SynchronizedTest {
    private static volatile Logger logger = LoggerFactory.getLogger(SynchronizedTest.class);

    public static void main(String[] args) {
        Object o = new Object();
        synchronized (o) {
            System.out.println("");

        }
        logger = null;
    }
}