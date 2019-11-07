import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

/**
 * @author heming
 * @date 2019/11/6 14:03
 * @description TODO
 */
public class JumpFloor {
    private static final Logger logger = LoggerFactory.getLogger(JumpFloor.class);

    public static void main(String[] args) {
        System.out.println(jumpFloor(3));
    }

    public static int jumpFloor(int target) {
        if (target > 2) {
            return jumpFloor(target - 1) + jumpFloor(target - 2);
        } else if (target == 1) {
            return 1;
        } else if (target == 2) {
            return 2;
        } else {
            return 0;
        }
    }

}