import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.util.HashMap;
import java.util.Map;
import java.util.Random;

/**
 * @author heming1
 * @date 2019/3/24 19:03
 * @description TODO
 */
public class EncodeAndDecodeTinyURL1 {
    private static final Logger logger = LoggerFactory.getLogger(EncodeAndDecodeTinyURL1.class);
    /**
     * (26+26+10)^6
     */
    private static final String RANDOM_STR = "abcdefghijklmnopqrstuvwxyzABCDEFGHIJKLMNOPQRSTUVWXYZ0123456789";

    private Map<String, String> short2Url = new HashMap<>();
    private Map<String, String> url2Short = new HashMap<>();

    // Encodes a URL to a shortened URL.
    public String encode(String longUrl) {
        if (short2Url.containsValue(longUrl)) {
            return url2Short.get(longUrl);
        }
        String randomStr = randomStr();
        while (short2Url.containsKey(randomStr)) {
            randomStr = randomStr();
        }

        String shortUrl = "http://tinyurl.com/" + randomStr;

        short2Url.put(shortUrl, longUrl);
        url2Short.put(longUrl, shortUrl);

        return shortUrl;
    }

    // Decodes a shortened URL to its original URL.
    public String decode(String shortUrl) {
        return short2Url.get(shortUrl);
    }

    private String randomStr() {
        StringBuilder sb = new StringBuilder();
        for (int i = 0; i < 6; i++) {
            Random random = new Random();
            sb.append(RANDOM_STR.charAt(random.nextInt(62)));
        }
        return sb.toString();
    }

}