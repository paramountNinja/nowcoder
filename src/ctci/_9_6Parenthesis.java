package ctci;
//@formatter:off
import java.util.Stack; /**
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
 * 描述：对于一个字符串，请设计一个算法，判断其是否为一个合法的括号串。
 * 给定一个字符串A和它的长度n，请返回一个bool值代表它是否为一个合法的括号串。
 * 测试样例："(()())",6返回：true
 * 测试样例："()a()()",7返回：false
 * 测试样例："()(()()",7返回：false
 */
 //@formatter:on
public class _9_6Parenthesis {
    public boolean chkParenthesis(String A, int n) {
        int left = 0;
        int right = 0;
        for (int i = 0; i < n; i++) {
            if (A.charAt(i) != '(' && A.charAt(i) != ')')
                return false;
            if (A.charAt(i) == '(') left++;
            if (A.charAt(i) == ')') right++;
        }
        return left == right;
    }
}
