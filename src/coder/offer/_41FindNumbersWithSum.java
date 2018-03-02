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
 * 描述：输入一个递增排序的数组和一个数字S，在数组中查找两个数，使得他们的和正好是S，
 *       如果有多对数字的和等于S，输出两个数的乘积最小的。
 */
 //@formatter:on

import java.util.ArrayList;

public class _41FindNumbersWithSum {
    public ArrayList<Integer> FindNumbersWithSum(int[] array, int sum) {
        ArrayList<Integer> result = new ArrayList<>();
        int one = Integer.MAX_VALUE;
        int two = Integer.MAX_VALUE;
        int mul = Integer.MAX_VALUE;
        if (array == null || array.length <= 1) return result;
        //两个指针一个从前往后，一个从后往前
        int small = 0;
        int big = array.length - 1;
        while (small < big) {
            if (array[small] + array[big] == sum) {
                if (array[small] * array[big] < mul) {//如果乘积变小了，更新one two mul,也可以直接用定理：sum相同，离的越远积越大
                    mul = array[small] * array[big];
                    one = array[small];
                    two = array[big];
                }
                small++;
                big--;
            } else if (array[small] + array[big] < sum) {
                small++;
            } else {
                big--;
            }
        }
        if (one < Integer.MAX_VALUE && two < Integer.MAX_VALUE) {
            result.add(one);
            result.add(two);
        }
        return result;
    }
}
