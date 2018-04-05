package ctci;
//@formatter:off
import java.util.LinkedList;import java.util.Queue; /**
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
 * 描述：在一个nxm矩阵形状的城市里爆发了洪水，洪水从(0,0)的格子流到这个城市，在这个矩阵中有的格子有一些建筑，洪水只能在没有建筑的格子流动。
 * 请返回洪水流到(n - 1,m - 1)的最早时间(洪水只能从一个格子流到其相邻的格子且洪水单位时间能从一个格子流到相邻格子)。
 * 给定一个矩阵map表示城市，其中map[i][j]表示坐标为(i,j)的格子，值为1代表该格子有建筑，0代表没有建筑。
 * 同时给定矩阵的大小n和m(n和m均小于等于100)，请返回流到(n - 1,m - 1)的最早时间。保证洪水一定能流到终点。
 */
 //@formatter:on
public class _9_7Flood {
    //BFS
    public int floodFill(int[][] map, int n, int m) {
        if (n == 0 || m == 0 || map[0][0] == 1) return 0;
        Queue<Integer> que = new LinkedList<>();
        que.add(0);
        int x, y, next_x, next_y;
        int[][] dir = {{0, 1}, {1, 0}, {0, -1}, {-1, 0}};
        while (!que.isEmpty()) {
            Integer number = que.poll();
            x = number / m;
            y = number % m;
            for (int i = 0; i < 4; i++) {
                next_x = x + dir[i][0];
                next_y = y + dir[i][1];
                if (next_x >= 0 && next_x < n && next_y >= 0 && next_y < m && map[next_x][next_y] == 0) {//如果没越界且不是建筑物或者走过
                    que.add(next_x * m + next_y);
                    map[next_x][next_y] = map[x][y] + 1;
                }
                if (next_x == n - 1 && next_y == m - 1) {
                    return map[n - 1][m - 1];
                }
            }
        }
        return 0;
    }

    public static void main(String[] args) {
        int[][] map = {{0, 0, 0}, {0, 0, 0}, {0, 1, 0}};
        _9_7Flood flood = new _9_7Flood();
        int i = flood.floodFill(map, 3, 3);
        System.out.println(i);
    }
}
