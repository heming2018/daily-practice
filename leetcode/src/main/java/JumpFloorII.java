/**
 * @author heming
 * @date 2019/11/8 00:13
 * @description TODO
 */
public class JumpFloorII {

    
    public static void main(String[] args) {
        System.out.println(JumpFloorII(4));
    }

    public static int JumpFloorII(int target) {
        if (target == 0) {
            return 0;
        }
        if (target <= 2) {
            return target;
        }
        int count = 1;
        while (target > 2) {
            count *= 2;
            target -= 1;
        }
        return count * 2;
    }
}