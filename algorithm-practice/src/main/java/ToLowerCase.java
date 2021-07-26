import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

/**
 * @author heming1
 * @date 2019/3/18 14:52
 * 
 */
public class ToLowerCase {
    private static final Logger logger = LoggerFactory.getLogger(ToLowerCase.class);

    public static String toLowerCase(String str) {
        return str.toLowerCase();
    }

    /**
     * 'a' - 'A' = 32
     */
    public static String toLowerCaseAvoidLibrary(String str) {
        char[] chars = str.toCharArray();

        for (int i = 0; i < chars.length; i++) {
            char c = chars[i];
            if (c >= 'A' && c <= 'Z') {
                chars[i] = (char) (c - 'A' + 'a');
            }
        }
        return new String(chars);

    }

    public static void main(String[] args) {
        int i = '1' - '0';
        System.out.println(i);
    }

}