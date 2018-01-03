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
 * 描述：替换字符串中所有的空格位%20  使用场景：socket传输编码问题
 */
 //@formatter:on
public class _04ReplaceAllSpace {
    public String replaceSpace(StringBuffer str) {
        int spaceNum = 0;
        for (int i = 0; i < str.length(); i++) {
            if (str.charAt(i) == ' ') spaceNum++;//找到所有的空格
        }
        str.setLength(str.length() + 2 * spaceNum);
        int p = str.length() - 1;//始终指向复制后的头位置
        for (int i = str.length() - 2 * spaceNum - 1; i >= 0; i--) {
            if (str.charAt(i) != ' ') {
                str.setCharAt(p, str.charAt(i));
                p--;
            } else {
                str.setCharAt(p--, '0');
                str.setCharAt(p--, '2');
                str.setCharAt(p--, '%');
            }
        }
        return str.toString();
    }
}