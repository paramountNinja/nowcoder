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
 * 描述：{1,2,3,3,3,3,4,5} 3在这个数组中出现了4次
 */
 //@formatter:on
public class _38GetNumberOfK {
    //一般的顺序查找和二分查找时间复杂度都为O(n);所以采用二分查找第一个k和第二个k,时间复杂度为O(logn)
    public int GetNumberOfK(int[] array, int k) {
        if (array == null || array.length <= 0) return 0;
        int number = 0;
        //获得第一个最后一个k的下标
        int first = getFirstK(array, 0, array.length - 1, k);
        int last = getLastK(array, 0, array.length - 1, k);
        if (first > -1 && last > -1)
            number = last - first + 1;
        return number;
    }

    private int getFirstK(int[] array, int start, int end, int k) {
        if (start > end) return -1;//即没有找到k
        int middle = start + (end - start) / 2;
        int middleData = array[middle];
        if (middleData > k) end = middle - 1;
        else if (middleData < k) start = middle + 1;
        else {//此时中间的这个数等于k
            if ((middle > 0 && array[middle - 1] != k) || middle == 0)
                return middle;
            else end = middle - 1;
        }
        return getFirstK(array, start, end, k);
    }

    private int getLastK(int[] array, int start, int end, int k) {
        if (start > end) return -1;//即没有找到k
        int middle = start + (end - start) / 2;
        int middleData = array[middle];
        if (middleData > k) end = middle - 1;
        else if (middleData < k) start = middle + 1;
        else {//此时中间的这个数等于k
            if ((middle < array.length - 1 && array[middle + 1] != k) || middle == array.length - 1)
                return middle;
            else start = middle + 1;
        }
        return getLastK(array, start, end, k);
    }
}
