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
 * 描述：在一个长度为n的数组里的所有数字都在0到n-1的范围内。 数组中某些数字是重复的，但不知道有几个数字是重复的。也不知道每个数字重复几次。请找出数组中任意一个重复的数字。
 * 例如，如果输入长度为7的数组{2,3,1,0,2,5,3}，那么对应的输出是第一个重复的数字2。
 */
 //@formatter:on
public class _50duplicate {
    //用一个boolean的辅助数组；由于都是小于n的数，可以将其作为下标，相同的数在同一位置，类似于hash的功能
    public boolean duplicate(int numbers[], int length, int[] duplication) {
        if (numbers == null || numbers.length <= 1) return false;
        boolean[] k = new boolean[numbers.length];//初始化后都为false;
        for (int i = 0; i < numbers.length; i++) {
            if (k[numbers[i]] == true) {//说明前面已经有相同的数了
                duplication[0] = numbers[i];
                return true;
            }

            k[numbers[i]] = true;//循环到该数，就在对应的boolean数组上设为true
        }
        return false;
    }
}
