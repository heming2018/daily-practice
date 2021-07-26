package leetcode;

import java.util.Arrays;

/**
 * @author heming1
 * @date 2021/7/26 9:56 下午
 * @description TODO
 */
public class LC56_merge {

    public static void main(String[] args) {
        new LC56_merge().merge(new int[][]{{1, 4}, {0, 4}});
    }

    public int[][] merge(int[][] input) {
        if (input == null || input.length == 1) return input;

//        Arrays.sort(input, (o1, o2) -> o1[0]-o2[0]);

        for (int i = 1; i < input.length; i++) {
            int temp0 = input[i][0];
            int temp1 = input[i][1];
            int j = i - 1;
            while (j >= 0 && input[j][0] > temp0) {
                input[j + 1][0] = input[j][0];
                input[j + 1][1] = input[j][1];
                j--;
            }
            input[j + 1][0] = temp0;
            input[j + 1][1] = temp1;
        }
        int[][] res = new int[input.length][2];
        res[0] = input[0];
        int index = 0;
        for (int i = 1; i < input.length; i++) {
            int[] curr = input[i];
            if (res[index][1] >= curr[0]) {
                res[index][1] = Math.max(curr[1], res[index][1]);
            } else {
                res[++index] = curr;
            }
        }

        return Arrays.copyOf(res, index + 1);
    }
}