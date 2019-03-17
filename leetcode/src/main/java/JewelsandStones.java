import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.util.HashSet;
import java.util.Set;

/**
 * @author 10237
 * @date 2019/3/18 0:10
 * @description TODO
 */
public class JewelsandStones {
    private static final Logger logger = LoggerFactory.getLogger(JewelsandStones.class);

    public static void main(String[] args) {
        System.out.println(numJewelsInStones("aA", "aAAbbbb"));
    }

    public static int numJewelsInStones(String J, String S) {
        int result = 0;

        Set<Character> set = new HashSet<>();
        for (char c : J.toCharArray()) {
            set.add(c);
        }

        for (char c : S.toCharArray()) {
            if (set.contains(c)) {
                result++;
            }
        }

        return result;

    }
}