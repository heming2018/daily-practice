import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.util.Arrays;

/**
 * @author heming
 * @date 2019/11/19 23:13
 * @description
 * LL今天心情特别好, 因为他去买了一副扑克牌, 发现里面居然有2个大王, 2个小王(一副牌原本是54张 ^ _ ^)...
 * 他随机从中抽出了5张牌,想测测自己的手气,看看能不能抽到顺子,如果抽到的话,他决定去买体育彩票,嘿嘿！！
 * “红心A,黑桃3,小王,大王,方片5”,“Oh My God!”不是顺子.....LL不高兴了,他想了想,决定大\小 王可以看成任何数字,并且A看作1
 * ,J为11,Q为12,K为13。上面的5张牌就可以变成“1,2,3,4,5”(大小王分别看作2和4),“So Lucky!”。LL决定去买体育彩票啦。
 * 现在,要求你使用这幅牌模拟上面的过程,然后告诉我们LL的运气如何， 如果牌能组成顺子就输出true，否则就输出false。为了方便起见,你可以认为大小王是0。
 */
public class IsContinuous {
    private static final Logger logger = LoggerFactory.getLogger(IsContinuous.class);

    public static void main(String[] args) {
        isContinuous1(new int[]{1, 3, 2, 5, 4});
    }

    public boolean isContinuous(int[] numbers) {
        if (numbers == null || numbers.length != 5) {
            return false;
        }
        Arrays.sort(numbers);
        int zeroNum = 0;
        int needZeroNum = 0;
        for (int i = 0; i < numbers.length - 1; i++) {
            if (numbers[i] == 0) {
                zeroNum++;
            } else {
                int number = numbers[i + 1] - numbers[i];
                if (number == 0) {
                    return false;
                } else if (number > 1) {
                    needZeroNum += number - 1;
                }
            }
        }

        return zeroNum - needZeroNum >= 0;
    }

    /**
     * 需满足条件：
     * 1. 最大减最小<5
     * 2. 数组长度为5
     * 3. 没有对子
     *
     * @param numbers
     * @return
     */
    public static boolean isContinuous1(int[] numbers) {
        if (numbers == null || numbers.length != 5) {
            return false;
        }
        int[] arr = new int[14];
        int max = -1;
        int min = 14;
        for (int i = 0; i < numbers.length; i++) {
            if (numbers[i] > 0) {

                if (arr[numbers[i]] == 1) {
                    // 说明有对子
                    return false;
                }
                if (numbers[i] > max) {
                    max = numbers[i];
                }
                if (numbers[i] < min) {
                    min = numbers[i];
                }
                // 判断对子用
                arr[numbers[i]] = 1;
            }
        }

        return max - min < 5;
    }
}