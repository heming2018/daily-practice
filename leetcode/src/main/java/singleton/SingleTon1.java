package singleton;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

/**
 * @author heming1
 * @date 2021/6/4 3:45 下午
 * @description 单例实现方法1
 */
public class SingleTon1 {
    private static final Logger logger = LoggerFactory.getLogger(SingleTon1.class);

    private static SingleTon1 singleTon1 = new SingleTon1();

    private SingleTon1() {
    }

    public static SingleTon1 getSingleTon1() {
        return singleTon1;
    }
}