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
 * 描述：给定两个字符串，请编写程序，确定其中一个字符串的字符重新排列后，能否变成另一个字符串。这里规定大小写为不同字符，且考虑字符串重点空格。
 * 给定一个string stringA和一个string stringB，请返回一个bool，代表两串是否重新排列后可相同。保证两串的长度都小于等于5000。
 */
 //@formatter:on

import java.util.ArrayList;
import java.util.List;

public class _1_3Same {
    public boolean checkSam(String stringA, String stringB) {
        if (stringA == null && stringB == null) return true;
        if ((stringA == null && stringB != null) || (stringA != null && stringB == null)) return false;
        if (stringA.length() != stringB.length()) return false;
        char[] achars = stringA.toCharArray();
        char[] bchars = stringB.toCharArray();
        List<Character> list = new ArrayList<>();
        for (char a : achars)
            list.add(a);
        for (char b : bchars) {
            int flag = 0; //0表示这一个没有找到对应的字符
            for (int i = 0; i < list.size(); i++) {
                if (list.get(i) == b) {
                    list.remove(i);
                    flag = 1;
                    break;
                }
            }
            if (flag == 0) return false;
        }
        return list.isEmpty() ? true : false;
    }
}
/*
此题也可以开辟两个256个空间的散列表来做
注：为什么是256？因为一个字符是8位，每一个位置都有01两种可能，所以有2^8 = 256种可能，涵盖了全部字符
 */
