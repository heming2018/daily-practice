import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.util.*;

/**
 * @author heming1
 * @date 2021/6/4 11:24 上午
 * @description 符号匹配
 */
public class KuohaoPipei {
    private static final Logger logger = LoggerFactory.getLogger(KuohaoPipei.class);

    public static void main(String[] args){
        System.out.println(isValid("())(){}[]"));
    }

    private static boolean isValid(String str) {
        if (str == null || str.isEmpty()) {
            return true;
        }
        Stack<Character> stack = new Stack<>();
        Map<Character, Character> map = new HashMap<>();
        map.put('[',']');
        map.put('{','}');
        map.put('(',')');
        for (int i = 0; i < str.length(); i++) {
            if (map.containsKey(str.charAt(i))) {
                stack.add(str.charAt(i));
            } else if (map.containsValue(str.charAt(i))) {
                if (stack.isEmpty()) {
                    return false;
                }
                if (stack.pop().equals(str.charAt(i))) {
                    return false;
                }
            }
        }

        return stack.isEmpty();
    }

}