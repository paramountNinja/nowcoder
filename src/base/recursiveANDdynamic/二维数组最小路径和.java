package base.recursiveANDdynamic;

/*
二维数组，每个数都是正数，左上走到右下，每一步只能向右或向下，沿途数字加起来，返回最小路径和
 */
public class 二维数组最小路径和 {

    //往右或往下的最短路径 暴力递归枚举，很多重复计算，时间复杂度很高
    public static int walk(int[][] matrix, int i, int j) {
        if (i == matrix.length - 1 && j == matrix[0].length - 1)
            return matrix[i][j];
        if (i == matrix.length - 1)
            return matrix[i][j] + walk(matrix, i, j + 1);
        if (j == matrix[0].length - 1)
            return matrix[i][j] + walk(matrix, i + 1, j);
        int right = walk(matrix, i, j + 1);
        int down = walk(matrix, i + 1, j);
        return matrix[i][j] + Math.min(right, down);
    }


    //无后效性问题(i,j确定时，返回值一定是固定的) 可改成动态规划 存到表里（右下角存放最终结果），中间结果不需要重复计算
    public static int walk_2(int[][] m) {
        if (m == null || m.length == 0 || m[0] == null || m[0].length == 0) {
            return 0;
        }
        int row = m.length;
        int col = m[0].length;
        int[][] dp = new int[row][col];//创建一个存放结果的数组
        dp[0][0] = m[0][0];
        //先定义左上的边界值
        for (int i = 1; i < row; i++) {
            dp[i][0] = dp[i - 1][0] + m[i][0];
        }
        for (int j = 1; j < col; j++) {
            dp[0][j] = dp[0][j - 1] + m[0][j];
        }
        for (int i = 1; i < row; i++) {
            for (int j = 1; j < col; j++) {
                dp[i][j] = Math.min(dp[i - 1][j], dp[i][j - 1]) + m[i][j];
            }
        }
        return dp[row - 1][col - 1];
    }

    public static void main(String[] args) {
        int[][] m = {
                {1, 1, 1},
                {0, 0, 1},
                {1, 0, 1}
        };
        //System.out.println(walk(m, 0, 0));
        System.out.println(walk_2(m));
    }
}

/*
当前位置 + 往右或往下的最短路径


递归 ---> 动态规划
 */