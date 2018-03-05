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
 * 描述：输入n个整数，找出其中最小的K个数。例如输入4,5,1,6,2,7,3,8这8个数字，则最小的4个数字是1,2,3,4,。
 */
 //@formatter:on

import java.util.ArrayList;
import java.util.Collections;

public class _30GetLeastNumbers_Solution {
    //简单粗暴的全排列，时间复杂度为O(nlogn)
    public ArrayList<Integer> GetLeastNumbers_Solution(int[] input, int k) {
        ArrayList<Integer> list = new ArrayList<>();
        if (input == null || input.length <= 0 || k == 0 || k > input.length) return list;
        for (int i = 0; i < input.length; i++)
            list.add(input[i]);
        Collections.sort(list);
        for (int i = list.size() - 1; i >= k; i--)
            list.remove(i);
        return list;
    }

    public static void main(String[] args) {
        int[] input = {4, 5, 1, 6, 2, 7, 3, 8};
        int k = 4;
        _30GetLeastNumbers_Solution instance = new _30GetLeastNumbers_Solution();
        ArrayList<Integer> list = instance.GetLeastNumbers_Solution(input, k);
        System.out.println(list);
    }
}
