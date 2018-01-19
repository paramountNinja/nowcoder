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
 * 描述：数组中有一个数字出现的次数超过数组长度的一半，请找出这个数字。
 * 例如输入一个长度为9的数组{1,2,3,2,2,2,5,4,2}。
 * 由于数字2在数组中出现了5次，超过数组长度的一半，因此输出2。如果不存在则输出0。
 */
 //@formatter:on
public class _29MoreThanHalfNum_Solution {
    /**
     * 当遍历下一个数字和之前保存的数字相同时加1，若不同则减1，若为0，则保存下一个数字，并把次数设为1
     * 求到的只是可能的结果
     * 最后存入的数字不一定是超过一半的所以需要检验
     * 时间复杂度O(n)
     */
    public int MoreThanHalfNum_Solution(int[] array) {
        if (array == null) return 0;
        int count = 1;
        int result = array[0];
        for (int i = 1; i < array.length; i++) {
            if (array[i] == result)
                count++;
            else {
                count--;
                if (count == 0) {
                    result = array[i];
                    count = 1;//需要将count设为1！
                }
            }
        }
        //验证
        int number = 0;
        for (int i = 0; i < array.length; i++) {
            if (array[i] == result)
                number++;
        }
        if (number * 2 > array.length)
            return result;
        else
            return 0;
    }
}
