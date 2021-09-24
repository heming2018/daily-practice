package interview;

import java.util.HashMap;
import java.util.Scanner;

/**
 * @author heming1
 * @date 2021/8/5 4:39 下午
 * @description TODO
 */
public class Xunhuan {
//11/7 =
    /*
    关键是如果是无限循环小数怎么确定循环节：如果曾经出现过的被除数再次出现，
    那么上一次出现的位置就是循环节的开头，此处就是循环节的结尾(不包括），举个栗子
    11/7=1……4，整数部分是1，然后计算小数部分
    被除数 商 余数
    40    5 5
    50    7 1
    10    1 3
    30    4 2
    20    2 6
    60    8 4
    40    5 5 此处被除数40再次出现，那么循环节就是（571428）
    */
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int a = scanner.nextInt();
        int b = scanner.nextInt();

        StringBuilder result = new StringBuilder();
        // 先求出整数部分
        result.append(a / b);
        // 如果有小数部分再求小数部分
        if (a % b != 0) {
            a = a % b;
            result.append('.');
            // 使用hashmap记录每一个被除数和它上一次出现的位置
            HashMap<Integer, Integer> map = new HashMap<>();
            while (a != 0) {
                // 新的被除数
                a *= 10;
                // 如果这个被除数曾经出现过，那么找到了循环节，游戏结束
                if (map.get(a) != null) {
                    // 在上一次此被除数出现的位置之前插入'('
                    result.insert(map.get(a), "(");
                    // 在最后插入')'
                    result.append(')');
                    break;
                }

                // 没有出现过就将此被除数插入map
                map.put(a, result.length());

                // 求出商和余数
                result.append(a / b);
                a = a % b;
            }
        }

        // 输出结果
        System.out.println(result);
    }


}