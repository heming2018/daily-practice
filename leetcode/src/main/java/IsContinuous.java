import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.util.Arrays;

/**
 * @author heming
 * @date 2019/11/19 23:13
 * @description TODO
 */
public class IsContinuous {
    private static final Logger logger = LoggerFactory.getLogger(IsContinuous.class);

    public static void main(String[] args) {

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
}