import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.util.HashMap;

/**
 * @author heming1
 * @date 2021/7/19 1:07 上午
 * @description 3. 无重复字符的最长子串
 * https://leetcode-cn.com/problems/longest-substring-without-repeating-characters/
 * 给定一个字符串 s ，请你找出其中不含有重复字符的 最长子串 的长度。
 */
public class LC3_lengthOfLongestSubstring {

    public static void main(String[] args) {
        System.out.println(lengthOfLongestSubstring("abcabcbb"));
    }

    public static int lengthOfLongestSubstring(String s) {
        if (s == null || s.length() == 0) {
            return 0;
        }
        if (s.length() == 1) {
            return 1;
        }
        HashMap<Character, Integer> map = new HashMap<>();
        int l = 0, r = 0;
        int res = 1;
        while (l <= r && r < s.length()) {
            if (!map.containsKey(s.charAt(r))) {
                map.put(s.charAt(r), r);
                res = Math.max(res, r - l + 1);
                r++;
            } else {
                map.remove(s.charAt(l));
                l++;
            }
        }
        return res;
    }
}