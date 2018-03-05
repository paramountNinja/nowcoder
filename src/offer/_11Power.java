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
public class _11Power {
    //累乘
    public double Power(double base, int exponent) {
        double result = 1.0;
        if (base == 0) {
            if (exponent == 0) return 1;
            else return 0;
        }
        int absExponent = 0;
        if (exponent == 0) return 1;
        else if (exponent < 0) absExponent = -exponent;//考虑指数为负时，使用绝对值
        else absExponent = exponent;
        for (int i = 1; i <= absExponent; i++) {
            result *= base;
        }
        if (exponent < 0) result = 1.0 / result;

        return result;
    }
}
