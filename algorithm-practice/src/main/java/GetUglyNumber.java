import java.util.ArrayList;
import java.util.List;

/**
 * @author heming
 * @date 2019/11/12 13:40
 * 题目描述
 * 把只包含质因子2、3和5的数称作丑数（Ugly Number）。例如6、8都是丑数，但14不是，因为它包含质因子7。 习惯上我们把1当做是第一个丑数。求按从小到大的顺序的第N个丑数。
 */
public class GetUglyNumber {
    public static void main(String[] args) {
        System.out.println(GetUglyNumber_Solution(2));
    }

    public static int GetUglyNumber_Solution(int index) {
        if (index < 1) {
            return 0;
        }
        int t2 = 0, t3 = 0, t5 = 0;

        List<Integer> list = new ArrayList<>();
        list.add(1);
        for (int i = 1; i < index; i++) {
            int currNum = Math.min(list.get(t2) * 2, Math.min(list.get(t3) * 3, list.get(t5) * 5));
            list.add(i, currNum);
            if (currNum == list.get(t2) * 2) t2++;
            if (currNum == list.get(t3) * 3) t3++;
            if (currNum == list.get(t5) * 5) t5++;
        }

        return list.get(index - 1);
    }
}