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
 * 描述：非递减旋转数组中的最小数字   如{3,4,5,1,2}中找到最小的数字1
 */
 //@formatter:on
public class _8MinNumberInRotatedArray {
    public static int minNumberInRotateArray(int[] array) {
        if (array.length == 0) return 0;
        int low = 0;
        int high = array.length - 1;
        if (array[low] < array[high]) return array[low];
        while (true) {
            if (low == high - 1) break;
            int mid = low + (high - low) / 2;
            if (array[mid] == array[low] && array[mid] == array[high]) {
                return findMin(array, low, high);
            }
            if (array[mid] >= array[low]) low = mid;
            else high = mid;
        }
        return array[high];
    }

    private static int findMin(int[] array, int low, int high) {
        int result = array[low];
        for (int i = low + 1; i <= high; i++) {
            if (array[i] < result)
                result = array[i];
        }
        return result;
    }

    public static void main(String[] args) {
        int[] array = {2,3,4,1};
        int i = _8MinNumberInRotatedArray.minNumberInRotateArray(array);
        System.out.println(i);
    }
}
