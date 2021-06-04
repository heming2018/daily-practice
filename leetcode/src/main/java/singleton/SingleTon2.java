package singleton;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

/**
 * @author heming1
 * @date 2021/6/4 3:49 下午
 * @description 懒汉式实现方式
 */
public class SingleTon2 {
    private static final Logger logger = LoggerFactory.getLogger(SingleTon2.class);

    private static SingleTon2 singleTon2;

    private SingleTon2() {
    }

    private static synchronized SingleTon2 getSingleTon2() {
        if (singleTon2 == null) {
            synchronized (SingleTon2.class) {
                if (singleTon2 == null) {
                    singleTon2 = new SingleTon2();
                }
            }
        }
        return singleTon2;
    }
}