package offer;
//@formatter:off
/**
 *                             _ooOoo_
 *                            o8888888o
 *                            88" . "88
 *                            (| -_- |)
 *                            O\  =  /O
 *                         ____/`---'\____
 *                       .'  \\|     |//  `.
 *                      /  \\|||  :  |||//  \
 *                     /  _||||| -:- |||||-  \
 *                     |   | \\\  -  /// |   |
 *                     | \_|  ''\---/''  |   |
 *                     \  .-\__  `-`  ___/-. /
 *                   ___`. .'  /--.--\  `. . __
 *                ."" '<  `.___\_<|>_/___.'  >'"".
 *               | | :  `- \`.;`\ _ /`;.`/ - ` : | |
 *               \  \ `-.   \_ __\ /__ _/   .-` /  /
 *          ======`-.____`-.___\_____/___.-`____.-'======
 *                             `=---='
 *          ^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^
 *                     佛祖保佑        永无BUG
 *
 * 描述：输入一个矩阵，按照从外向里以顺时针的顺序依次打印出每一个数字，例如，如果输入如下矩阵：
 *  1  2  3  4
 *  5  6  7  8
 *  9 10 11 12
 * 13 14 15 16
 * 则依次打印出数字1,2,3,4,8,12,16,15,14,13,9,5,6,7,11,10.
 */
 //@formatter:on

import java.util.ArrayList;

public class _20printMatrix {
    private ArrayList<Integer> list = new ArrayList<>();

    public ArrayList<Integer> printMatrix(int[][] matrix) {
        if (matrix == null) return null;
        int rows = matrix.length;
        int cols = matrix[0].length;
        int start = 0;
        //通过观察，循环的条件
        while (rows > start * 2 && cols > start * 2) {
            printMatrixInCircle(matrix, rows, cols, start);
            start++;
        }
        return list;
    }

    //打印一圈的数据
    private void printMatrixInCircle(int[][] matrix, int rows, int cols, int start) {
        //第一步横着肯定是有的，
        //第二步竖着条件是终止行号大于起始行号
        //第三步往回横条件是至少两行两列，即，终止行号大于起始行号，终止列号大于起始列号
        //第四步往上竖条件是至少三行两列，即，终止行号至少比起始行号大2，终止列号大于起始列号
        int endX = cols - 1 - start;
        int endY = rows - 1 - start;
        //从左到右打印一行
        for (int i = start; i <= endX; i++)
            list.add(matrix[start][i]);
        //从上到下打印一列
        if (start < endY) {
            for (int i = start + 1; i <= endY; i++)
                list.add(matrix[i][endX]);
        }
        //从右到左打印一行
        if (start < endX && start < endY) {
            for (int i = endX - 1; i >= start; i--)
                list.add(matrix[endY][i]);
        }
        //从下到上打印一行
        if (start < endX && start < endY - 1) {
            for (int i = endY - 1; i >= start + 1; i--)
                list.add(matrix[i][start]);
        }
    }
}
