package coder.offer;
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
 * 描述：把字符串转换成整数
 */
 //@formatter:on
public class _49StrToInt {
    public int StrToInt(String str) {
        if (str == null || str.length() == 0) return 0;
        char[] chars = str.toCharArray();
        int s = 1;//符号位
        int res = 0;//结果
        if (chars[0] == '-') s = -1;
        for (int i = ((chars[0] == '+' || chars[0] == '-') ? 1 : 0); i < chars.length; i++) {//如果有符号从第二个开始遍历
            if (!(chars[i] >= '0' && chars[i] <= '9')) return 0;//如果存在不为数字的值就返回0
            res = (res << 1) + (res << 3) + (chars[i] & 0xf);//等同于res=res*10+chars[i]-'0';         res*2 + res*8
            //字符'0'到'9'的ascii值的低4个二进制位刚好就是0到9所以chars[i]&0xf等于chars[i]-'0'。
        }
        return res * s;
    }
}
