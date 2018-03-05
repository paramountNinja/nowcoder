package base;

//地图场景中的深度优先搜索（穷举）：朝一个方向一直走，走不通换方向，然后返回，擦除标记，寻找其他路径
/*
s 0 0 0 0
0 0 1 1 0
0 0 1 e 0
0 0 0 0 0
0 0 0 0 0

s起点，e终点，1障碍物
 */
public class DFSDemo {
    //设定x,y轴最大值,创建地图
    static int max_x = 100;
    static int max_y = 100;
    static int[][] map = new int[max_x][max_y];
    //设定方向
    static int[][] next = {{1, 0}, {0, 1}, {-1, 0}, {0, -1}};
    //标记是否走过
    static boolean[][] mark = new boolean[max_x][max_y];
    //最少步数
    static int min_step = Integer.MAX_VALUE;

    public static void main(String[] args) {
        map[3][2] = 100;//设置目的地e的值
        map[3][1] = 1;//障碍物
        map[2][2] = 1;
        map[4][2] = 1;

        //深度优先搜索
        dfs(0, 0, 1);

        System.out.println(min_step);

    }


    private static void dfs(int x, int y, int step) {
        //判断条件：若到达目的地 或 步数大于现有最小值 或 步数大于容忍的值（防止溢出）
        if (map[x][y] == 100 || step > min_step || step > 20) {
            min_step = Math.min(step, min_step);
            return;
        }
        //若没到,走一步
        for (int i = 0; i < next.length; i++) {
            int next_x = x + next[i][0]; //i=0 时往右走一步；
            int next_y = y + next[i][1];
            //判断边界，走不通了，走过了，碰到障碍物了。则直接执行下一次循环，即换一个方向走
            if (next_x == max_x || next_y == max_y || next_x == -1 || next_y == -1
                    || mark[next_x][next_y] || map[next_x][next_y] == 1)
                continue;
            //标记已经走过的点
            mark[next_x][next_y] = true;
            dfs(next_x, next_y, step + 1); //这里使用递归，当i=0时实现一直往右走，其他类推
            mark[next_x][next_y] = false;//擦除这个点的记录，回过头来找其他的路
        }

    }
}
