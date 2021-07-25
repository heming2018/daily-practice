package leetcode;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.util.HashMap;
import java.util.HashSet;
import java.util.Set;

/**
 * @author heming1
 * @date 2021/7/19 1:07 上午
 * @description 3. 无重复字符的最长子串
 * https://leetcode-cn.com/problems/longest-substring-without-repeating-characters/
 * 给定一个字符串 s ，请你找出其中不含有重复字符的 最长子串 的长度。
 */
public class LC3_lengthOfLongestSubstring {

    public static void main(String[] args) {
        System.out.println(lengthOfLongestSubstring1("qrsvbspk"));
    }
    // 参考别人的实现
    public static int lengthOfLongestSubstring(String s) {
        if (s == null || s.length() == 0) {
            return 0;
        }
        if (s.length() == 1) {
            return 1;
        }
        Set<Character> set = new HashSet<>();
        int l = 0, r = 0;
        int res = 1;
        while (l <= r && r < s.length()) {
            if (!set.contains(s.charAt(r))) {
                set.add(s.charAt(r));
                res = Math.max(res, r - l + 1);
                r++;
            } else {
                set.remove(s.charAt(l));
                l++;
            }
        }
        return res;
    }
    // 自己实现
    public static int lengthOfLongestSubstring1(String s) {
        if (s == null || s.length() == 0){
            return 0;
        }

        int l = 0;
        int r = 0;
        Set<Character> set = new HashSet<>();
        int res = 1;
        while (l <= r && r < s.length()) {
            if (!set.contains(s.charAt(r))) {
                set.add(s.charAt(r));
                res = Math.max(res, set.size());
                r++;
            } else {
                set.remove(s.charAt(l));
                l++;
            }
        }
        return res;
    }

}