package ctci;
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
 * 描述：请编写一个方法，返回某集合的所有非空子集。
 * 给定一个int数组A和数组的大小int n，请返回A的所有非空子集。保证A的元素个数小于等于20，且元素互异。各子集内部从大到小排序,子集之间字典逆序排序，见样例。
 * 测试样例：[123,456,789]返回：{[789,456,123],[789,456],[789,123],[789],[456 123],[456],[123]}
 */
 //@formatter:on

import java.util.ArrayList;
import java.util.Arrays;

public class _9_4Subset_2 {
    public ArrayList<ArrayList<Integer>> getSubsets(int[] A, int n) {
        ArrayList<ArrayList<Integer>> res = new ArrayList<>();
        if (n == 0) return res;
        Arrays.sort(A);

        int size = (1 << n) - 1;//非空子集的个数
        for (int i = size; i >= 1; i--) {
            ArrayList<Integer> subSet = new ArrayList<>();
            for (int j = n - 1; j >= 0; j--) {
                if (((i >> j) & 1) == 1)
                    subSet.add(A[j]);
            }
            res.add(subSet);
        }
        return res;
    }
}


/*
思路: 使用二进制
例如三个数，则2^3-1=7，用二进制表示为111，每一位上表示这个数字有没有
 */
