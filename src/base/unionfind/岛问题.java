package base.unionfind;

/*
一个矩阵中只有0和1两种值， 每个位置都可以和自己的上、 下、 左、 右
四个位置相连， 如果有一片1连在一起， 这个部分叫做一个岛， 求一个
矩阵中有多少个岛？
举例：
0 0 1 0 1 0
1 1 1 0 1 0
1 0 0 1 0 0
0 0 0 0 0 0
这个矩阵中有三个岛。
 */
public class 岛问题 {
    //法一：感染法，单核cpu跑，双重for循环
    public static int countIslands(int[][] arr) {
        int count = 0;
        for (int i = 0; i < arr.length; i++) {
            for (int j = 0; j < arr[0].length; j++) {
                if (arr[i][j] == 1) {
                    count++;
                    infect(arr, i, j);//周围的有1的都置为2
                }
            }
        }
        return count;
    }

    private static void infect(int[][] arr, int i, int j) {
        //base case 以下情况直接返回
        if (i < 0 || i >= arr.length || j < 0 || j >= arr[0].length || arr[i][j] != 1) {
            return;
        }
        arr[i][j] = 2;
        infect(arr, i + 1, j);
        infect(arr, i - 1, j);
        infect(arr, i, j + 1);
        infect(arr, i, j - 1);
    }

    //法二：并查集，拆分成几块，适合数据较大的情况


    public static void main(String[] args) {
        int[][] m = {
                {0, 0, 0, 0, 0, 0, 0, 0, 0},
                {0, 1, 1, 1, 0, 1, 1, 1, 0},
                {0, 1, 1, 1, 0, 0, 0, 1, 0},
                {0, 1, 1, 0, 0, 0, 0, 0, 0},
                {0, 0, 0, 0, 0, 1, 1, 0, 0},
                {0, 0, 0, 0, 1, 1, 1, 0, 0},
                {0, 0, 0, 0, 0, 0, 0, 0, 0}
        };
        System.out.println(countIslands(m));
    }
}

/*
并查集的思想
将矩阵分成几块，然后每一块查找岛屿，将1相连，最后合并的时候减去边界在一起的
 */