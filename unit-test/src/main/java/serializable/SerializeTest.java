package serializable;

import com.google.gson.Gson;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.io.Serializable;

/**
 * @author heming1
 * @date 2019/3/25 9:47
 * 
 */
public class SerializeTest implements Serializable {
    private static final Logger logger = LoggerFactory.getLogger(SerializeTest.class);

    public static void main(String[] args) {
        SerializeDomain1 serializeDomain1 = new SerializeDomain1();
        serializeDomain1.setNum(1);
        serializeDomain1.setStr("str");

        Gson gson = new Gson();
        String s = gson.toJson(serializeDomain1);
        SerializeDomain2 serializeDomain2 = gson.fromJson(s, SerializeDomain2.class);

        System.out.println(serializeDomain2);
    }
}