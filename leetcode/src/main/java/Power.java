/**
 * @author heming
 * @date 2019/11/12 17:42
 * @description 给定一个double类型的浮点数base和int类型的整数exponent。求base的exponent次方。
 * 保证base和exponent不同时为0
 */
public class Power {
    public static void main(String[] args) {
        System.out.println(Power(2, -3));
    }

    public static double Power(double base, int exponent) {
        if (exponent == 0) {
            return 1;
        }
        double res = base;
        int exponentAbs = exponent > 0 ? exponent : 0 - exponent;

        for (int i = 1; i < exponentAbs; i++) {
            res *= base;
        }

        return exponent > 0 ? res : 1 / res;
    }
}