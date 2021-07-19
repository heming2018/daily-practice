import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.util.ArrayList;
import java.util.List;

/**
 * @author 10237
 * @date 2019/3/20 23:19
 * @description TODO
 */
public class HammingDistance {
    private static final Logger logger = LoggerFactory.getLogger(HammingDistance.class);

    public static void main(String[] args) {
        System.out.println(hammingDistance(1, 4));
    }

    public static int hammingDistance(int x, int y) {
        int res = 0;
        String xStr = toBinaryCode(x);
        String yStr = toBinaryCode(y);
        int abs = Math.abs(xStr.length() - yStr.length());

        StringBuilder add = new StringBuilder();
        for (int i = 0; i < abs; i++) {
            add.append(0);
        }

        if (xStr.length() > yStr.length()) {
            yStr = yStr+ add.toString();
        } else {
            xStr = xStr + add.toString();
        }
        for (int i = 0; i < xStr.length(); i++) {
            if (xStr.charAt(i) != yStr.charAt(i)) {
                res++;
            }
        }
        return res;
    }

    private static String toBinaryCode(int i) {
        StringBuilder sb = new StringBuilder();

        do {
            sb.append(i % 2);
            i = i / 2;
        } while (i != 0);

        return sb.toString();
    }

}