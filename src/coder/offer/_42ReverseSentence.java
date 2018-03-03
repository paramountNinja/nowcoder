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
 * 描述：例如，“student. a am I”。反转回 “I am a student.”
 */
 //@formatter:on
public class _42ReverseSentence {
    //思路:将str完全反转，然后每个再反转
    public String ReverseSentence(String str) {
        char[] chars = str.toCharArray();
        reverse(chars, 0, chars.length - 1);

        int preHead = -1;//标志每一个段的开头位
        for (int i = 0; i < chars.length; i++) {
            if (chars[i] == ' ') {
                int tail = i;
                reverse(chars, preHead + 1, tail - 1);
                preHead = tail;
            }
        }
        reverse(chars, preHead + 1, chars.length - 1);//最后一个单词单独进行反转,因为最后没有空格
        return new String(chars);
    }

    //反转指定长度位置的内容
    private void reverse(char[] chars, int start, int end) {
        while (start < end) {
            char temp = chars[start];
            chars[start] = chars[end];
            chars[end] = temp;
            start++;
            end--;
        }
    }
}
