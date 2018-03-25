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
 * 描述：利用字符重复出现的次数，编写一个方法，实现基本的字符串压缩功能。
 * 比如，字符串“aabcccccaaa”经压缩会变成“a2b1c5a3”。若压缩后的字符串没有变短，则返回原先的字符串。
 * 给定一个string iniString为待压缩的串(长度小于等于10000)，保证串内字符均由大小写英文字母组成，返回一个string，为所求的压缩后或未变化的串。
 */
 //@formatter:on

import java.util.ArrayList;
import java.util.List;

public class _1_5Zipper {
    public String zipString(String iniString) {
        if (iniString == null || iniString.length() == 1) return iniString;
        char[] chars = iniString.toCharArray();
        StringBuilder zip = new StringBuilder();
        int p = 0;
        int count = 1;
        while (p < chars.length) {
            while (p + 1 < chars.length && chars[p] == chars[p + 1]) {
                count++;
                p++;
            }
            zip.append(chars[p]);
            zip.append(count + "");
            count = 1;
            p++;
        }
        if (zip.length() > chars.length) return iniString;

        return zip.toString();
    }

    public static void main(String[] args) {
        String s = "welcometonowcoderrrrr";
        _1_5Zipper one = new _1_5Zipper();
        String s1 = one.zipString(s);
        System.out.println(s1);

    }
}
