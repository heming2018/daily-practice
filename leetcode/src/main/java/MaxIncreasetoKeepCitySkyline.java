
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

/**
 * @author heming1
 * @date 2019/3/19 9:39
 * @description TODO
 */
public class MaxIncreasetoKeepCitySkyline {
    private static final Logger logger = LoggerFactory.getLogger(MaxIncreasetoKeepCitySkyline.class);

    public static void main(String[] args) {
        int[][] arr = new int[2][4];
        arr[0][0] = 3;
        arr[0][1] = 0;
        arr[0][2] = 8;
        arr[0][3] = 4;
        arr[1][0] = 2;
        arr[1][1] = 4;
        arr[1][2] = 5;
        arr[1][3] = 7;
        System.out.println(maxIncreaseKeepingSkyline(arr));
    }

    public static int maxIncreaseKeepingSkyline(int[][] grid) {
        int[] maxRows = new int[grid.length];
        int[] maxColumns = new int[grid[0].length];

        for (int i = 0; i < grid.length; i++) {
            for (int j = 0; j < grid[0].length; j++) {
                if (maxColumns[j] < grid[i][j]) {
                    maxColumns[j]  = grid[i][j];
                }
                if (maxRows[i] < grid[i][j]) {
                    maxRows[i] = grid[i][j];
                }
            }
        }

        int res = 0;
        for (int i = 0; i < grid.length; i++) {
            for (int j = 0; j < grid[0].length; j++) {
                int max = Math.min(maxColumns[j], maxRows[i]);
                if (grid[i][j] < max) {
                    res += (max - grid[i][j]);
                }

            }
        }
        return res;
    }

}