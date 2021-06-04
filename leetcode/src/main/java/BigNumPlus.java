/**
 * @author heming1
 * @date 2021/6/4 12:24 上午
 * @description 大整数相加
 */
public class BigNumPlus {

    public static void main(String[] args) {
        System.out.println(add("9999999","9999999"));
    }

    static String add(String left, String right) {
        int length = Math.max(left.length(), right.length());
        String leftReverser = reverseStr(left);
        String rightReverser = reverseStr(right);
        int jinwei = 0;
        StringBuilder sb = new StringBuilder();
        for (int i = 0; i < length; i++) {
            int num1 = 0;
            int num2 = 0;
            if (i < leftReverser.length()) {
                num1 = leftReverser.charAt(i) - '0';
            }
            if (i < rightReverser.length()) {
                num2 = rightReverser.charAt(i) - '0';
            }
            int sum = num1 + num2 + jinwei;
            if (sum >= 10) {
                sb.append(sum % 10);
                jinwei = 1;
            } else {
                sb.append(sum);
                jinwei = 0;
            }
        }
        if (jinwei > 0) {
            sb.append(jinwei);
        }
        return reverseStr(sb.toString());
    }

    public static String reverseStr(String str) {
        StringBuilder sb = new StringBuilder();
        for (int i = str.length() - 1; i >= 0; i--) {
            sb.append(str.charAt(i));
        }
        return sb.toString();
    }

}