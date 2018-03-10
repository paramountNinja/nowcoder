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
 * 描述：有一个XxY的网格，一个机器人只能走格点且只能向右或向下走，要从左上角走到右下角。
 * 请设计一个算法，计算机器人有多少种走法。
 * 给定两个正整数int x,int y，请返回机器人的走法数目。保证x＋y小于等于12。
 */
 //@formatter:on
public class _9_2_1Robot {
    public static int countWays(int x, int y) {
        return helper(0, 0, x, y);
    }

    private static int helper(int i, int j, int x, int y) {
        if (i < 0 || j < 0 || i >= x || j >= y) return 0;
        if (i == x - 1 && j == y - 1) return 1;//到达目的地说明多了一种情况
        return helper(i + 1, j, x, y) + helper(i, j + 1, x, y);
    }

    public static void main(String[] args) {
        int x = 2;
        int y = 2;
        int i = _9_2_1Robot.countWays(x, y);
        System.out.println(i);
    }
}

