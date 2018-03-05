package base;

//地图场景中的广度优先搜索 （雷达扩散）：将扩散到的坐标存入一个数组，用头尾两个指针管理，然后依次遍历，类似队列
/*
s 0 0 0 0
0 0 1 1 0
0 0 1 e 0
0 0 0 0 0
0 0 0 0 0

s起点，e终点，1障碍物
 */
public class BFSDemo {

    //构建地图
    static int max_x = 100;
    static int max_y = 100;
    static int[][] map = new int[max_x][max_y];
    //方向
    static int[][] next = {{1, 0}, {0, 1}, {-1, 0}, {0, -1}};
    //x y step 数据
    static int[][] data = new int[100][3];
    //记录搜索过的点
    static boolean[][] mark = new boolean[max_x][max_y];

    //两个指针分别指向数据数组的头尾
    static int index_head = 0;
    static int index_tail = 1;

    public static void main(String[] args) {
        map[3][2] = 100;//设置目的地
        map[3][1] = 1;//障碍物
        map[2][2] = 1;
        map[4][2] = 1;
        //设置初始数据
        int source_x = 0;
        int source_y = 0;
        int step = 1;
        data[index_head][0] = source_x;
        data[index_head][1] = source_y;
        data[index_head][2] = step;
        mark[0][0] = true;

        boolean flag = true;
        while (flag) {
            source_x = data[index_head][0];
            source_y = data[index_head][1];
            step = data[index_head][2];
            for (int i = 0; i < next.length; i++) {
                //取下一步的坐标
                int next_x = source_x + next[i][0];
                int next_y = source_y + next[i][1];
                //判断边界
                if (next_x == max_x || next_y == max_y || next_x == -1 || next_y == -1
                        || mark[next_x][next_y] || map[next_x][next_y] == 1)
                    continue;
                //到达目的地
                if (map[next_x][next_y] == 100) {
                    flag = false;
                    step += 1;
                    break;
                }
                //未到达
                mark[next_x][next_y] = true;
                data[index_tail][0] = next_x;
                data[index_tail][1] = next_y;
                data[index_tail][2] = step + 1;
                index_tail++;
            }
            index_head++;
        }
        System.out.println(step);
    }
}
