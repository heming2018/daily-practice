package serializable;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.io.Serializable;

/**
 * @author heming1
 * @date 2019/3/25 9:49
 * @description TODO
 */
public class SerializeDomain1 implements Serializable {
    private static final Logger logger = LoggerFactory.getLogger(SerializeDomain2.class);
    private static final long serialVersionUID = -5285066244381821224L;

    private String str;

    private int num;

    public String getStr() {
        return str;
    }

    public void setStr(String str) {
        this.str = str;
    }

    public int getNum() {
        return num;
    }

    public void setNum(int num) {
        this.num = num;
    }

    @Override
    public String toString() {
        final StringBuilder sb = new StringBuilder("{");
        sb.append("\"str\":\"")
                .append(str).append('\"');
        sb.append(",\"num\":")
                .append(num);
        sb.append('}');
        return sb.toString();
    }
}