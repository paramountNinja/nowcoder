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
 * 描述：有个小孩正在上楼梯，楼梯有n阶台阶，
 * 小孩一次可以上1阶、2阶、3阶。请实现一个方法，计算小孩有多少种上楼的方式。
 * 为了防止溢出，请将结果Mod 1000000007
 * 给定一个正整数int n，请返回一个数，代表上楼的方式数。保证n小于等于100000。
 */
 //@formatter:on
public class _9_1GoUpstairs {

    //溢栈
/*    public int countWays(int n) {
        int mod = 1000000007;
        if (n <= 2) return n;
        if (n == 3) return 4;
        return countWays(n - 1) % mod + countWays(n - 2) % mod + countWays(n - 3) % mod;
    }*/
    public int countWays(int n) {
        if (n == 1) return 1;
        if (n == 2) return 2;
        if (n == 3) return 4;
        int mod = 1000000007;
        int first = 1;
        int second = 2;
        int third = 4;
        int result = 0;
        for (int i = 4; i <= n; i++) {
            result = (first + second) % mod + third % mod;
            first = second % mod;//依次往后移动一位数
            second = third % mod;
            third = result;
        }
        return result % mod;
    }


    public static void main(String[] args) {
        _9_1GoUpstairs instance = new _9_1GoUpstairs();
        int i = instance.countWays(36196);
        System.out.println(i);
    }
}
    /*
    f(n) = f(n-1) + f(n-2) + f(n-3);
     */