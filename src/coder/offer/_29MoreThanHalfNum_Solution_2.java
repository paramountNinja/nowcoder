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

import java.util.HashMap;
import java.util.Map;

public class _29MoreThanHalfNum_Solution_2 {
    /**
     * HashMap
     */
    public int MoreThanHalfNum_Solution(int[] array) {
        if (array == null || array.length == 0) return 0;
        int count = 0;
        int data = 0;
        Map<Integer, Integer> map = new HashMap<>();//key:数字 val:个数
        for (int i = 0; i < array.length; i++) {
            if (map.get(array[i]) == null)
                map.put(array[i], 1);
            else {
                map.put(array[i], map.get(array[i]) + 1);
            }
            if (map.get(array[i]) > count) {
                count = map.get(array[i]);
                data = array[i];
            }
        }
        if (count * 2 > array.length)
            return data;
        else return 0;
    }
}
