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
 * 描述：在数组中的两个数字，如果前面一个数字大于后面的数字，则这两个数字组成一个逆序对。
 * 输入一个数组,求出这个数组中的逆序对的总数P。并将P对1000000007取模的结果输出。 即输出P%1000000007
 */
 //@formatter:on

public class _36InversePairs {
    public int InversePairs(int[] array) {

        if (array == null || array.length == 0)
            return 0;
        int[] copy = new int[array.length];
        for (int i = 0; i < array.length; i++) {
            copy[i] = array[i];
        }
        int count = inversePairsCore(array, copy, 0, array.length - 1);//数值过大求余
        return count;

    }

    private int inversePairsCore(int[] array, int[] copy, int low, int high) {
        if (low == high)
            return 0;
        int mid = (low + high) >> 1;
        //递归
        int leftCount = inversePairsCore(array, copy, low, mid) % 1000000007;
        int rightCount = inversePairsCore(array, copy, mid + 1, high) % 1000000007;
        int count = 0;
        int i = mid;
        int j = high;
        int locCopy = high;
        while (i >= low && j > mid) { // 两组中的指针分别往前移动
            if (array[i] > array[j]) {
                count += j - mid;//多了第二组指针前面数字个的逆序对
                copy[locCopy--] = array[i--];
                count %= 1000000007;
            } else {
                copy[locCopy--] = array[j--];
            }
        }
        //两组一个到头跳出上面while循环后,将剩下的一个组的内容加入copy数组,下面两个for循环其实只有一个执行了
        for (; i >= low; i--) {
            copy[locCopy--] = array[i];
        }
        for (; j > mid; j--) {
            copy[locCopy--] = array[j];
        }
        //排序,即修改已经排好序的位置上的值
        for (int s = low; s <= high; s++) {
            array[s] = copy[s];
        }
        return (leftCount + rightCount + count) % 1000000007;
    }
}
