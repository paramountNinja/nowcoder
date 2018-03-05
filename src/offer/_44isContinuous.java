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
 * 描述：从扑克牌中随机抽牌，判断是不是一个顺子，1-13，大小王可看成任意数，自定义为0
 */
 //@formatter:on

import java.util.Arrays;

public class _44isContinuous {
    //思路：统计数组中0的个数，统计各个相邻之间的差 与 0的个数比较（若出现重复的数直接返回false）
    public boolean isContinuous(int[] numbers) {
        if (numbers == null || numbers.length < 1) return false;
        //排序
        Arrays.sort(numbers);
        int numOfZero = 0;
        //统计0的个数
        for (int i = 0; i < numbers.length; i++) {
            if (numbers[i] == 0)
                numOfZero++;
        }
        //比较间隔大小
        int gap = 0;
        int p = numOfZero;//p要从非0的开始
        while (p < numbers.length - 1) {
            int q = p + 1;
            if (numbers[q] == numbers[p]) return false;
            else
                gap += numbers[q] - numbers[p] - 1;
            p++;
        }
        return gap - numOfZero == 0 || gap == 0; //若没有间隔也可，不能忘记加上
    }
}
