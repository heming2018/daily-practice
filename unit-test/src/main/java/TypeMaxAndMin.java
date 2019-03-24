import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

/**
 * @author heming1
 * @date 2019/3/24 16:12
 * @description TODO
 */
public class TypeMaxAndMin {
    private static final Logger logger = LoggerFactory.getLogger(TypeMaxAndMin.class);

    public static void main(String[] args) {
        System.out.println(Byte.MIN_VALUE);
        System.out.println(Byte.MAX_VALUE);
        System.out.println(Short.MIN_VALUE);
        System.out.println(Short.MAX_VALUE);
        // -2147483648
        System.out.println(Integer.MIN_VALUE);
        // 2147483647
        System.out.println(Integer.MAX_VALUE);
        // -9223372036854775808
        System.out.println(Long.MIN_VALUE);
        // 9223372036854775807
        System.out.println(Long.MAX_VALUE);
    }
}