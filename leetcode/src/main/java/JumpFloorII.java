import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

/**
 * @author heming
 * @date 2019/11/8 00:13
 * @description TODO
 */
public class JumpFloorII {
    private static final Logger logger = LoggerFactory.getLogger(JumpFloorII.class);

    public static void main(String[] args) {
        System.out.println(jumpFloorII(4));
    }

    public static int jumpFloorII(int target) {
        int res = 0;
        if (target == 1) {
            return 1;
        } else if (target == 2) {
            return 2;
        } else if (target > 2) {
            while (target >= 1) {
                res += jumpFloorII(target - 1);
                target--;
            }
            res++;
            return res;
        } else {
            return 0;
        }
    }

}