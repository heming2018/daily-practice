package singleton;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

/**
 * @author heming1
 * @date 2021/6/19 5:37 下午
 * 
 */
public class SingleTon3 {
    private static final Logger logger = LoggerFactory.getLogger(SingleTon3.class);

    private static  SingleTon3 ton = new SingleTon3();

    private SingleTon3() {
    }

    public static SingleTon3 getInstance(){
        return ton;
    }
}