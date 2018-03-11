package ctci;
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
 * 描述：有一个XxY的网格，一个机器人只能走格点且只能向右或向下走，要从左上角走到右下角。请设计一个算法，计算机器人有多少种走法。注意这次的网格中有些障碍点是不能走的。
给定一个int[][] map,表示网格图，若map[i][j]为1则说明该点不是障碍点，否则则为障碍。另外给定int x,int y，表示网格的大小。请返回机器人从(0,0)走到(x - 1,y - 1)的走法数，为了防止溢出，请将结果Mod 1000000007。保证x和y均小于等于50
 */
 //@formatter:on
public class _9_2_2Robot {
    //深度遍历方法的递归，超时！
   /* public int countWays_dfs(int[][] map, int x, int y) {
        if (map == null || x < 0 || y < 0) return 0;
        return helper(0, 0, map, x, y);
    }
    private int helper(int i, int j, int[][] map, int x, int y) {
        if (i < 0 || j < 0 || i >= x || j >= y || map[i][j] != 1) return 0;
        if (i == x - 1 && j == y - 1) return 1;
        return (helper(i + 1, j, map, x, y) + helper(i, j + 1, map, x, y)) % 1000000007;
    }*/


    //动态规划打表    dp[i][j]=dp[i-1][j]+dp[i][j-1]
    /*
    障碍物 方法数 = 0；
    起点   方法数 = 1；
    上边沿 方法数 = 左边来的
    左边沿 方法数 = 右边来的
    其他点 方法数 = 左边 + 上边
     */
    public int countWays(int[][] map, int x, int y) {
        if (map[0][0] == 0 || map[x - 1][y - 1] == 0) return 0;//这是坑，测试用例里面把起点为0的情况也考虑进去。。。
        int mod = 1000000007;
        int[][] dp = new int[map.length][map[0].length];
        for (int i = 0; i < x; i++) {
            for (int j = 0; j < y; j++) {
                if (i == 0 && j == 0) dp[i][j] = 1; //起点
                else if (map[i][j] != 1) dp[i][j] = 0;
                else if (i == 0 && j != 0) dp[i][j] = dp[i][j - 1];//上边沿
                else if (i != 0 && j == 0) dp[i][j] = dp[i - 1][j];//左边沿
                else dp[i][j] = dp[i][j - 1] % mod + dp[i - 1][j] % mod;
            }
        }
        return dp[x - 1][y - 1] % mod;
    }


    public static void main(String[] args) {
        int[][] map = {{1, 0, 1}, {1, 0, 1}, {1, 1, 1}};
        int x = 3;
        int y = 3;
        _9_2_2Robot instance = new _9_2_2Robot();
        int i = instance.countWays(map, x, y);
        System.out.println(i);
    }
}
