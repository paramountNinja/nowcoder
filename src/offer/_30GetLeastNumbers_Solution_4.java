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

public class _30GetLeastNumbers_Solution_4 {
    //利用快速排序中的获取分割（中轴）点位置函数getPartitiion。
    //基于数组的第k个数字来调整，使得比第k个数字小的所有数字都位于数组的左边，比第k个数字大的所有数字都位于数组的右边。
    // 调整之后，位于数组左边的k个数字就是最小的k个数字（这k个数字不一定是排序的）。O(N)
    public ArrayList<Integer> GetLeastNumbers_Solution(int[] input, int k) {
        ArrayList<Integer> list = new ArrayList<>();
        if (input == null || input.length <= 0 || k == 0 || k > input.length) return list;
        int start = 0;
        int end = input.length - 1;
        int index = -1;
        while (index != k - 1) {
            if (index > k - 1) end = index - 1; //因为index>k-1的，所以再递归的时候，e是等于index-1的
            else start = index + 1;
            index = getPartition(input, start, end);//不断的迭代，使得当前的index=k-1;
        }
        for (int i = 0; i < k; i++)
            list.add(input[i]);
        return list;
    }

    private int getPartition(int[] input, int start, int end) {
        int j = start - 1;
        int cmp = input[end];
        for (int i = start; i < end; i++) {
            if (input[i] < cmp) {
                int tmp = input[i];
                input[i] = input[++j];
                input[j] = tmp;
            }
        }
        int tmp = input[end];
        input[end] = input[++j];
        input[j] = tmp;
        return j;
    }


    public static void main(String[] args) {
        int[] input = {4, 5, 1, 6, 2, 7, 3, 8};
        int k = 7;
        _30GetLeastNumbers_Solution_4 instance = new _30GetLeastNumbers_Solution_4();
        ArrayList<Integer> list = instance.GetLeastNumbers_Solution(input, k);
        System.out.println(list);
    }
}
