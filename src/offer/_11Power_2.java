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
 * 描述：给定一个double类型的浮点数base和int类型的整数exponent。求base的exponent次方。
 */
 //@formatter:on
public class _11Power_2 {
    //运用递归，时间复杂度O(logn)
    //当n为偶数，TrieTree^n =（TrieTree^n/2）*（TrieTree^n/2） 当n为奇数，TrieTree^n = TrieTree^[(n-1)/2] * TrieTree^[(n-1)/2] * TrieTree

    public double Power(double base, int exponent) {
        if (base == 0) {
            if (exponent == 0) return 1;
            else return 0;
        }
        int absExponent;
        if (exponent < 0) absExponent = -exponent;
        else if (exponent == 0) return 1;
        else absExponent = exponent;
        double result = power_recur(base, absExponent);
        return (exponent > 0) ? result : 1 / result;
    }

    private double power_recur(double base, int absExponent) {
        if (absExponent == 0) return 1.0;
        if (absExponent == 1) return base;
        double result = power_recur(base, absExponent >> 1);
        result *= result;//TrieTree^[(n-1)/2] * TrieTree^[(n-1)/2]
        if ((absExponent & 1) == 1) result *= base;//如果指数是奇数的话，再乘一个底数base
        return result;
    }
}
