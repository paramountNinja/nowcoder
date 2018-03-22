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
 * 描述：有一组数，对于其中任意两个数，若前面一个大于后面一个数字，则这两个数字组成一个逆序对。
 * 请设计一个高效的算法，计算给定数组中的逆序对个数。
 * 给定一个int数组A和它的大小n，请返回A中的逆序对个数。保证n小于等于5000。
 */
 //@formatter:on
public class _11_9AntiOrder {
    //归并，从后遍历前面一组的每一个值，找后面一组的逆序对个数
    public int count(int[] A, int n) {
        //复制一份
        int[] copy = new int[n];
        for (int i = 0; i < n; i++) {
            copy[i] = A[i];
        }
        return helper(A, copy, 0, n - 1);
    }

    //递归
    private int helper(int[] a, int[] copy, int start, int end) {//返回的是逆序对个数
        if (start >= end) return 0;
        int mid = start + (end - start) / 2;
        int left = helper(a, copy, start, mid);
        int right = helper(a, copy, mid + 1, end);
        int count = 0;
        int i = mid; //从后往前遍历，和后面一组比较，看有几个逆序对
        int j = end;
        int p = end;
        while (i >= start && j > mid) {
            if (a[i] > a[j]) {//因为j里面都有序，所以j前面的所有数都能和i构成逆序对
                count += j - mid;
                copy[p--] = a[i--];
            } else {
                copy[p--] = a[j--];
            }
        }
        //到这里一个数组已经空了
        for (; i >= start; i--) {
            copy[p--] = a[i];
        }
        for (; j > mid; j--) {
            copy[p--] = a[j];
        }

        //替换a中的值
        for (int k = start; k <= end; k++) {
            a[k] = copy[k];
        }

        return left + right + count;
    }
}
