import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

/**
 * @author heming
 * @date 2019/12/12 09:49
 * @description 定义栈的数据结构，请在该类型中实现一个能够得到栈中所含最小元素的min函数（时间复杂度应为O（1））。
 */
public class StackSolution {
    private static final Logger logger = LoggerFactory.getLogger(StackSolution.class);

    private Integer[] arr = new Integer[16];
    // [1,2,null]，index = 2
    private int index = 0;
    private Integer min;

    public void push(int node) {
        // 新加节点
        if (arr.length == index) {
            Integer[] temp = arr;
            arr = new Integer[arr.length * 2];
            if (temp.length >= 0) {
                System.arraycopy(temp, 0, arr, 0, temp.length);
            }
        }
        arr[index] = node;
        if (min == null || node < min) {
            min = node;
        }
        index++;
    }

    public void pop() {
        if (arr.length == 0 || index == 0) {
            throw new RuntimeException("数组为空");
        }
        Integer temp = arr[index - 1];
        arr[index - 1] = null;
        index--;
        if (temp.equals(min)) {
            min = null;
            for (int i = 0; i < index; i++) {
                if (min == null || arr[i] < min) {
                    min = arr[i];
                }
            }
        }
    }

    public int top() {
        if (arr.length == 0 || index == 0) {
            throw new RuntimeException("数组为空");
        }
        return arr[index - 1];
    }

    public int min() {
        return min;
    }

}