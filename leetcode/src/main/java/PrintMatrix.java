import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.util.ArrayList;

/**
 * @author heming
 * @date 2019/12/11 17:11
 * @description 输入一个矩阵，按照从外向里以顺时针的顺序依次打印出每一个数字，例如，如果输入如下4 X 4矩阵： 1 2 3 4 5 6 7 8 9 10 11 12 13 14 15 16 则依次打印出数字1,2,3,4,8,12,16,15,14,13,9,5,6,7,11,10.
 */
public class PrintMatrix {
    private static final Logger logger = LoggerFactory.getLogger(PrintMatrix.class);


    public static void main(String[] args) {

//        int[][] test = new int[5][1];
//
//        test[0][0] = 1;
//        test[1][0] = 2;
//        test[2][0] = 3;
//        test[3][0] = 4;
//        test[4][0] = 5;
        int[][] test = new int[2][2];

        test[0][0] = 1;
        test[0][1] = 2;
        test[1][0] = 3;
        test[1][1] = 4;
        ArrayList<Integer> list = printMatrix(test);
        System.out.println(list);

    }

    public static ArrayList<Integer> printMatrix(int[][] matrix) {
        ArrayList<Integer> list = new ArrayList<>();
        int x;
        int y;
        int beginIndex = 0;
        int xEndIndex = matrix.length - 1;
        int yEndIndex = matrix[0].length - 1;

        while (beginIndex <= xEndIndex && beginIndex <= yEndIndex) {
            x = beginIndex;
            y = beginIndex;
            while (y < yEndIndex) {
                list.add(matrix[x][y]);
                y++;
            }
            // 这里多读一位，是为了把正向的节点都读完。
            // 因为后两步需要判断是不是单列或者单行，如果是，就不往下读了。
            while (x <= xEndIndex) {
                list.add(matrix[x][y]);
                x++;
            }
            // 因为x超出了一位，所以需要减1
            x--;
            // 从上往下读的时候把最后一位读了，所以这里y需要左移一位，即将从右往左读
            y--;
            while (y > beginIndex && beginIndex != xEndIndex) {
                list.add(matrix[x][y]);
                y--;
            }
            while (x > beginIndex && beginIndex != yEndIndex) {
                list.add(matrix[x][y]);
                x--;
            }
            beginIndex += 1;
            yEndIndex -= 1;
            xEndIndex -= 1;
        }
        return list;
    }
}