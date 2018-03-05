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

public class _30GetLeastNumbers_Solution_3 {
    //最大堆的方法O(nlogn)
    public ArrayList<Integer> GetLeastNumbers_Solution(int[] input, int k) {
        ArrayList<Integer> list = new ArrayList<>();
        if (input == null || input.length <= 0 || k == 0 || k > input.length) return list;
        //构建最大堆
        for (int i = k / 2; i >= 0; i--) {//从中间那个数开始，确保他的两倍不存在，这样往前一个个构建最大堆
            adjustMaxHeap(input, i, k - 1);
        }
        //从第k个元素开始分别与最大堆的最大值做比较，如果比最大值小，则替换并调整堆
        //最终堆里的就是最小的K个数
        for (int j = k; j < input.length; j++) {
            if (input[j] < input[0]) {
                int tmp = input[0];
                input[0] = input[j];
                input[j] = tmp;
                adjustMaxHeap(input, 0, k - 1);
            }
        }
        for (int m = 0; m < k; m++) {
            list.add(input[m]);
        }
        return list;
    }

    private void adjustMaxHeap(int[] input, int start, int end) {
        //保存根节点（最大值）
        int temp = input[start];
        for (int i = 2 * start + 1; i <= end; i = 2 * i + 1) {
            //找到左右儿子中的最大值
            if (i < end && input[i + 1] > input[i])//右子树较大，小于end检验了是否有右子树
                i++;
            if (temp >= input[i])
                break;
            input[start] = input[i];
            start = i;//被交换节点的标记
        }
        input[start] = temp;
        //测试
       /* for (int i = 0; i < input.length; i++)
            System.out.print(input[i] + " ");
        System.out.println();*/
    }

    //测试
    public static void main(String[] args) {
        int[] input = {4, 5, 1, 6, 2, 7, 3, 8};
        int k = 8;
        _30GetLeastNumbers_Solution_3 instance = new _30GetLeastNumbers_Solution_3();
        ArrayList<Integer> list = instance.GetLeastNumbers_Solution(input, k);
        System.out.println(list);
    }
}
