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
 * 描述：请实现一个函数用来找出字符流中第一个只出现一次的字符。例如，当从字符流中只读出前两个字符"go"时，第一个只出现一次的字符是"g"。当从该字符流中读出前六个字符“google"时，第一个只出现一次的字符是"l"。
 * 如果当前字符流没有存在出现一次的字符，返回#字符。
 */
 //@formatter:on
public class _54FirstAppearingOnce {
    //一个字符占8位，因此不会超过256个，可以申请一个256大小的数组来实现一个简易的哈希表。
    // 时间复杂度为O(n)，空间复杂度O(n).
    //一个字符占8bit，所以ascii码表中的字符256个，但只有128是可见的，所以数组大小改为128也没问题。
    int[] temp = new int[128];
    StringBuilder s = new StringBuilder();

    //Insert one char from stringstream
    public void Insert(char ch) {
        s.append(ch);
        temp[ch]++;

    }

    //return the first appearence once char in current stringstream
    public char FirstAppearingOnce() {
        char[] chars = s.toString().toCharArray();
        for (char c : chars) {
            if (temp[c] == 1)
                return c;
        }
        return '#';
    }
}



