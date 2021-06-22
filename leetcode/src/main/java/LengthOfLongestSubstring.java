import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

/**
 * @author heming1
 * @date 2021/6/7 10:25 上午
 * @description 请从字符串中找出一个最长的不包含重复字符的子字符串，计算该最长子字符串的长度。
 *
 * 比如：bbccccccd
 * abcd
 */
public class LengthOfLongestSubstring {
    private static final Logger logger = LoggerFactory.getLogger(LengthOfLongestSubstring.class);

    public static void main(String[] args) {
        String s = "bbcb";
        System.out.println(lengthOfLongestSubstring(s));
    }

    private static String lengthOfLongestSubstring(String s) {
        if (s == null || s.isEmpty()) {
            return s;
        }
        int left = 0;
        int right = s.length() - 1;
        char[] charArray = s.toCharArray();


        while (left != right) {
            if (s.charAt(left) == s.charAt(right)) {
                left++;
            }



        }
        return new String();
    }
}