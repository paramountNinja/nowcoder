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
 * 描述：连续子数组的最大和例如:{6,-3,-2,7,-15,1,2,2},连续子向量的最大和为8(从第0个开始,到第3个为止)。
 * 要求时间复杂度为O(n)
 */
 //@formatter:on
public class _31FindGreatestSumOfSubArray {
    //动态规划
    public int FindGreatestSumOfSubArray(int[] array) {
        if (array == null || array.length <= 0) return 0;
        int sum = 0;
        int max = Integer.MIN_VALUE;
        for (int i = 0; i < array.length; i++) {
            if (sum <= 0)//若前面的几个数部分和小于0，则此时的数加上他肯定变小，所以sum变成此时这个数；前面的max已保存
                sum = array[i];
            else
                sum += array[i];
            if (sum > max) //更新max值
                max = sum;
        }
        return max;
    }

    public static void main(String[] args) {
        int[] array = {1, -2, 3, 10, -4, 7, 2, -5};
        //int[] array = {-2, -8, -1, -5, -9};
        _31FindGreatestSumOfSubArray instance = new _31FindGreatestSumOfSubArray();
        int max = instance.FindGreatestSumOfSubArray(array);
        System.out.println(max);
    }
}
