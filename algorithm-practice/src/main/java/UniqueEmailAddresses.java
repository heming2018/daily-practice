import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.util.HashSet;
import java.util.Set;

/**
 * @author 10237
 * @date 2019/3/23 23:57
 * 
 */
public class UniqueEmailAddresses {
    private static final Logger logger = LoggerFactory.getLogger(UniqueEmailAddresses.class);

    public static void main(String[] args) {
        numUniqueEmails(new String[]{"testemail@leetcode.com", "testemail1@leetcode.com", "testemail+david@lee.tcode.com"});
    }

    /**
     * without indexOf or split
     * @param emails
     * @return
     */
    public static int numUniqueEmails(String[] emails) {
        Set<String> set = new HashSet<>();
        for (String s : emails) {
            int atIndex = s.length();
            for (int i = 0; i < s.length(); i++) {
                if ("@".equals(String.valueOf(s.charAt(i)))) {
                    atIndex = i;
                }
            }
            String name = s.substring(0, atIndex);
            String field = s.substring(atIndex);

            name = name.replace(".", "");

            for (int i = 0; i < name.length(); i++) {
                if ("+".equals(String.valueOf(name.charAt(i)))) {
                    name = name.substring(0, i);
                    break;
                }
            }
            set.add(name + field);

        }
        return set.size();
    }

    public static int numUniqueEmails2(String[] emails) {
        Set<String> set = new HashSet<>();
        for (String email : emails) {
            String[] split = email.split("@");
            String[] split1 = split[0].split("\\+");
            set.add(split1[0].replace(".", "") + split[1]);
        }
        return set.size();
    }

}