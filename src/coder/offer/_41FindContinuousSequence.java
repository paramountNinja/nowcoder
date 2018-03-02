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
 * 描述：输出所有和为S的连续正数序列。序列内按照从小至大的顺序，序列间按照开始数字从小到大的顺序
 */
 //@formatter:on

import java.util.ArrayList;

public class _41FindContinuousSequence {

    private ArrayList<ArrayList<Integer>> result = new ArrayList<>();

    public ArrayList<ArrayList<Integer>> FindContinuousSequence(int sum) {
        if (sum <= 1) return result;
        //用两个指针small big 标记最小最大值，可知当head >中间值的时候则不可能再有满足题意的情况
        int mid = (sum + 1) / 2;
        int small = 1;
        int big = 2;
        int curSum = small + big;
        while (small < mid) {
            if (curSum == sum) {
                printSequence(small, big);
                curSum -= small;
                big++;
                small++;
                curSum += big;
            } else if (curSum < sum) {
                big++;
                curSum += big;
            } else {
                curSum -= small;
                small++;
            }
        }
        return result;
    }

    private void printSequence(int small, int big) {
        ArrayList<Integer> list = new ArrayList<>();
        for (int i = small; i <= big; i++)
            list.add(i);
        result.add(list);
    }


    public static void main(String[] args) {
        int sum = 100;
        _41FindContinuousSequence instance = new _41FindContinuousSequence();
        ArrayList<ArrayList<Integer>> arrayLists = instance.FindContinuousSequence(sum);
        System.out.println(arrayLists);
    }
}
