import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.util.*;

/**
 * @author heming1
 * @date 2021/6/6 12:51 上午
 * @description 微信群里抢红包算法（m元，n人），返回一个红包金额数组
 * 1.每个人（前n个人）都能抢到钱
 * 2.获得的金额都是随机的，但随机范围最大化(有机会获得可能的最多金额)
 * 3.机会均等（第一个人和第n个人抢到相同金额的概率是一样的）
 */
public class QiangHongBao {
    private static final Logger logger = LoggerFactory.getLogger(QiangHongBao.class);

    public static void main(String[] args) {
        qiangHongBao(10, 5);
    }


    public static double[] qiangHongBao(int money, int person) {
        if (person == 1) {
            return new double[]{money};
        }
        // 单位转换成分
        int moneyFen = money * 100;

        Random random = new Random();

        Set<Integer> split = new TreeSet<>();

        while (split.size() + 1 < person) {
            int randomNum = random.nextInt(moneyFen - person - 1) + 1;
            split.add(randomNum);
        }
        System.out.println("切割集合：" + split);

        double[] res = new double[person];
        Integer[] splitArr = split.toArray(new Integer[0]);
        res[0] = splitArr[0] * 0.01;

        double total = res[0];
        for (int i = 1; i < splitArr.length; i++) {
            res[i] = (splitArr[i] - splitArr[i - 1]) * 0.01;
            total += res[i];
        }
        res[person - 1] = (moneyFen - splitArr[splitArr.length - 1]) * 0.01;
        total += res[person - 1];

        System.out.println("结果：" + Arrays.toString(res));
        System.out.println("总和：" + total);

        return res;
    }


}