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
 * 描述：在一个字符串(1<=字符串长度<=10000，全部由字母组成)中找到第一个只出现一次的字符,并返回它的位置
 */
 //@formatter:on

import java.util.HashMap;
import java.util.Map;

public class _35FirstNotRepeatingChar {
    public int FirstNotRepeatingChar(String str) {
        if (str == null || str.length() <= 0) return -1;
        Map<Character, Integer> map = new HashMap<>();//用来记录每个数字出现的次数
        for (int i = 0; i < str.length(); i++) {
            char data = str.charAt(i);
            if (map.get(data) == null)
                map.put(data, 1);
            else
                map.put(data, map.get(data) + 1);
        }
        int result = -1;
        for (int i = 0; i < str.length(); i++) {
            if (map.get(str.charAt(i)) == 1) {
                result = i;
                break;
            }
        }
        return result;
    }

    public static void main(String[] args) {
        String str = "google";
        _35FirstNotRepeatingChar instance = new _35FirstNotRepeatingChar();
        int i = instance.FirstNotRepeatingChar(str);
        System.out.println(i);
    }
}
