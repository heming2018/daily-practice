/**
 * @author heming
 * @date 2019/11/8 00:13
 * 
 */
public class JumpFloorII {

    
    public static void main(String[] args) {
        System.out.println(JumpFloorII(4));
    }

    public static int JumpFloorII(int target) {
        if (target == 0) {
            return 0;
        }
        if (target == 1) {
            return 1;
        }
        int res = 1;
        while (target > 1) {
            res *= 2;
            target -= 1;
        }
        return res;
    }
}