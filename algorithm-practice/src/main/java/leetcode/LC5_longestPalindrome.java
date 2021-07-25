package leetcode;

/**
 * @author heming1
 * @date 2021/7/25 5:38 下午
 * @description 5. 最长回文子串
 * https://leetcode-cn.com/problems/longest-palindromic-substring/
 * 给你一个字符串 s，找到 s 中最长的回文子串。
 *
 * 输入：s = "babad"
 * 输出："bab"
 * 解释："aba" 同样是符合题意的答案。
 */
public class LC5_longestPalindrome {

    int start = 0;
    int end = 0;

    /**
     * 中心扩散法
     */
    public String longestPalindrome0(String s) {
        if (s == null || s.length() == 1) {
            return s;
        }

        int len = s.length();
        char[] ss = s.toCharArray();

        for (int i = 1; i < len; i++) {
            find(ss, len, i, i);
            find(ss, len, i - 1 ,i);
        }
        return s.substring(start, end);
    }

    void find(char[] ss, int len, int l, int r) {
        while (l >= 0 && r < len && l <= r) {
            if (ss[l] == ss[r]) {
                l--;
                r++;
            } else {
                break;
            }
        }

        if (r - (l + 1) > end - start) {
            start = l + 1;
            end  = r;
        }
    }

}