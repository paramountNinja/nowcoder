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
 * 描述：在数组A[0..n-1]中，有所谓的魔术索引，满足条件A[i]=i。给定一个升序数组，元素值各不相同，
 * 编写一个方法，判断在数组A中是否存在魔术索引。请思考一种复杂度优于o(n)的方法。
 * 给定一个int数组A和int n代表数组大小，请返回一个bool，代表是否存在魔术索引。
 * 测试样例：[1,2,3,4,5]返回：false
 */
 //@formatter:on
public class _9_3_1MagicIndex {
    //此方法顺序查找，复杂度 = o(n) 不满足题意
   /* public boolean findMagicIndex(int[] A, int n) {
        for (int i = 0; i < A.length; i++) {
            if (A[i] == i) {
                return true;
            }
        }
        return false;
    }*/

    //二分查找
    public boolean findMagicIndex(int[] A, int n) {
        if (n == 0) return true;
        return helper(A, 0, n - 1);
    }

    private boolean helper(int[] a, int start, int end) {
        if (start >= end) return false;
        int mid = start + (end - start) / 2;
        if (a[mid] == mid) return true;
        else if (mid < a[mid]) return helper(a, start, mid);
        else return helper(a, mid + 1, end);

    }
}
