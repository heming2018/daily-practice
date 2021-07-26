package singleton;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

/**
 * @author heming1
 * @date 2021/6/19 5:40 下午
 * 
 */
public class SingleTon4 {
    private static final Logger logger = LoggerFactory.getLogger(SingleTon4.class);

    private static volatile SingleTon4 singleTon4;

    public static SingleTon4 getInstance(){
        if (singleTon4 == null) {
            synchronized (SingleTon4.class) {
                if (singleTon4 == null) {
                    singleTon4 = new SingleTon4();
                }
            }
        }
        return singleTon4;
    }

}