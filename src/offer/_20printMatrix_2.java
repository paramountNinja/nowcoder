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
 *  1  2  3
 *  4  5  6
 *  7  8  9
 *  利用魔方旋转的思想：
 *  第一步输出第一行1,2,3
 *  第二步删除第一行，旋转变成
 *  6 9
 *  5 8
 *  4 7
 *  第三步输出6，9
 *  第四步根据以上方法逆时针旋转
 */
 //@formatter:on

import java.util.ArrayList;

public class _20printMatrix_2 {
    public ArrayList<Integer> printMatrix(int[][] matrix) {
        ArrayList<Integer> list = new ArrayList<>();
        if (matrix == null) return null;
        int rows = matrix.length;
        while (rows != 0) {
            for (int i = 0; i < matrix[0].length; i++) //不能把这个col拿出来单独拿出来，因为matrix指向的内容发生了变化
                list.add(matrix[0][i]);
            if (rows == 1)
                break;
            //删除第一行旋转魔方，其实就是构建一个新的矩阵
            matrix = turn(matrix);
            rows = matrix.length;
        }
        return list;
    }

    private int[][] turn(int[][] matrix) {
        int rows = matrix.length;
        int cols = matrix[0].length;
        int[][] newMatrix = new int[cols][rows - 1];
        for (int j = cols - 1; j >= 0; j--) {
            for (int i = 1; i < rows; i++) {
                //旋转操作
                newMatrix[cols - 1 - j][i - 1] = matrix[i][j];    //第1行的变成第0列，第2行变成第1列...
            }
        }
        return newMatrix;
    }

    public static void main(String[] args) {
        int[][] matrix = {{1, 2}, {3, 4}};
        _20printMatrix_2 instance = new _20printMatrix_2();
        ArrayList<Integer> list = instance.printMatrix(matrix);
        System.out.println(list);
    }
}
