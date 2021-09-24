package leetcode;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

/**
 * @author heming1
 * @date 2021/7/31 2:23 上午
 * @description 151. 翻转字符串里的单词
 * 给你一个字符串 s ，逐个翻转字符串中的所有 单词 。
 *
 * 单词 是由非空格字符组成的字符串。s 中使用至少一个空格将字符串中的 单词 分隔开。
 *
 * 请你返回一个翻转 s 中单词顺序并用单个空格相连的字符串。
 *
 * 说明：
 *
 * 输入字符串 s 可以在前面、后面或者单词间包含多余的空格。
 * 翻转后单词间应当仅用一个空格分隔。
 * 翻转后的字符串中不应包含额外的空格。
 */
public class LC151_reverseWords {

    public String reverseWords1(String s) {
        if (s == null || (s = s.trim()).isEmpty()) return "";
        int i, j, start, end;
        //首先翻转trim()后的一大长条字符串，之后再翻转每个单词(String内定义的char[]用final修饰，不可再变)
        StringBuilder sentence = new StringBuilder(s).reverse();
        //用来记录一个单词的前后两个空格
        start = end = 0;
        for (i = 0; i < sentence.length(); i++) {
            //如果碰到了一个空格，说明这个空格前到之前的一个空格已经有一个单词了，现在要翻转这个单词了
            if (sentence.charAt(i) == ' ') {
                //单词之间只能有一个空格，删除多余空格
                j = i + 1;
                while (sentence.charAt(j) == ' ') {
                    j++;
                }
                //delete方法前 包括，后 不包括
                sentence.delete(i + 1, j);
                //翻转单个单词
                end = i - 1;
                revSingleWord(sentence, start, end);
                //重新确定下一个单词的起始位置
                start = i + 1;
            }
        }
        //由于最后一个单词末尾没有空格，所以这里多处理一下
        revSingleWord(sentence, start, i - 1);
        return sentence.toString();
    }

    /**
     * 翻转单个单词
     */
    public void revSingleWord(StringBuilder sentence, int start, int end) {
        while (start < end) {
            char temp = sentence.charAt(start);
            sentence.setCharAt(start++, sentence.charAt(end));
            sentence.setCharAt(end--, temp);
        }
    }

    /**
     * 自己非原地解法
     */
    public String reverseWords(String s) {
        if (s == null) return s;
        String[] arr = s.split(" ");
        StringBuilder sb = new StringBuilder();
        for (int i = arr.length - 1; i >=0 ; i--) {
            if (arr[i].trim().length() > 0) {
                sb.append(arr[i].trim() + " ");
            }
        }
        return sb.toString().trim();
    }
}