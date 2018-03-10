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
 * 描述：请编写一个方法，将字符串中的空格全部替换为“%20”。
 * 假定该字符串有足够的空间存放新增的字符，并且知道字符串的真实长度(小于等于1000)，同时保证字符串由大小写的英文字母组成。
 * 给定一个string iniString 为原始的串，以及串的长度 int len, 返回替换后的string。
 */
 //@formatter:on
public class _1_4replaceSpace {
    public static String replaceSpace(String iniString, int length) {
        if (iniString == null || length <= 0) return null;
        char[] chars = iniString.toCharArray();
        //查看有几个空格
        int space_num = 0;
        for (int i = 0; i < length; i++) {
            if (chars[i] == ' ')
                space_num++;
        }
        int increase = space_num * 2;//多了的格数
        char[] newChars = new char[length + increase];//拓展后的字符串
        int p = newChars.length - 1;//指针指向复制后的头元素的前面
        for (int i = chars.length - 1; i >= 0; i--) {
            if (chars[i] != ' ') {
                newChars[p--] = chars[i];
            } else {
                newChars[p--] = '0';
                newChars[p--] = '2';
                newChars[p--] = '%';
            }
        }
        return new String(newChars);
    }

    public static void main(String[] args) {
        String str = "hello world ninja";
        int len = str.length();
        String s = _1_4replaceSpace.replaceSpace(str, len);
        System.out.println(s);
    }
}
