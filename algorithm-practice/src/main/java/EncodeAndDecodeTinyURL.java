import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.util.HashMap;
import java.util.Map;

/**
 * @author heming1
 * @date 2019/3/24 18:47
 * 
 */
public class EncodeAndDecodeTinyURL {

    private Map<String, String> map = new HashMap<>();

    private Long count = 0L;

    // Encodes a URL to a shortened URL.
    public String encode(String longUrl) {
        count += 1;
        map.put(String.valueOf(count), longUrl);
        return String.valueOf(count);
    }

    // Decodes a shortened URL to its original URL.
    public String decode(String shortUrl) {
        return map.get(shortUrl);
    }

}
