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

public class _9_4Subset {
    public ArrayList<ArrayList<Integer>> getSubsets(int[] A, int n) {
        ArrayList<ArrayList<Integer>> res = new ArrayList<>();
        if (n == 0) return res;
        Arrays.sort(A);
        return helper(A, n);
    }

    private ArrayList<ArrayList<Integer>> helper(int[] a, int n) {
        ArrayList<ArrayList<Integer>> res = new ArrayList<>();
        //终止条件
        if (n == 1) {
            ArrayList<Integer> inner = new ArrayList<>();
            inner.add(a[0]);
            res.add(inner);
            return res;
        }

        ArrayList<ArrayList<Integer>> preRes = helper(a, n - 1);
        for (int i = 0; i < preRes.size(); i++) {
            ArrayList<Integer> inner = new ArrayList<>();
            inner.add(a[n - 1]);
            inner.addAll(preRes.get(i));
            res.add(inner);
        }
        ArrayList<Integer> inner = new ArrayList<>();
        inner.add(a[n - 1]);
        res.add(inner);
        res.addAll(preRes);
        return res;//返回上一层的内容
    }


}


/*
思路: 每次都是在前一个基础上前面加一个元素，然后加上其本身的一种情况，再把之前的结果集放在list后面
1
2,1     2
3,2,1   3,2     3,1     3
 */
