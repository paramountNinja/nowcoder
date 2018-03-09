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
 * 描述：如何得到一个数据流中的中位数？如果从数据流中读出奇数个数值，那么中位数就是所有数值排序之后位于中间的数值。
 * 如果从数据流中读出偶数个数值，那么中位数就是所有数值排序之后中间两个数的平均值。
 */
 //@formatter:on

import java.util.Comparator;
import java.util.PriorityQueue;

public class _63GetMedian {
    //大根堆 小根堆解决问题
    private int count = 0;
    private PriorityQueue<Integer> minHeap = new PriorityQueue<>();
    private PriorityQueue<Integer> maxHeap = new PriorityQueue<>(15, new Comparator<Integer>() {
        @Override
        public int compare(Integer o1, Integer o2) {
            return o2 - o1;
        }
    });


    public void Insert(Integer num) {
        if (count % 2 == 0) {//总数为偶数，新加入的元素先入到大根堆，由大根堆筛选出堆中最大的元素，放入最小堆
            maxHeap.offer(num);//插入大根堆
            Integer filteredMaxNum = maxHeap.poll();
            minHeap.offer(filteredMaxNum);
        } else {//说明总数为奇数，由于上面的操作使得最小堆的数量多，那么新元素先放入最小堆，过滤出最小值，放入最大堆
            minHeap.offer(num);
            Integer filteredMinNum = minHeap.poll();
            maxHeap.offer(filteredMinNum);
        }
        count++;
    }

    public Double GetMedian() {
        if (count % 2 == 0) {//偶数
            return (maxHeap.peek() + minHeap.peek()) / 2.0;
        } else {
            return Double.valueOf(minHeap.peek());
        }
    }

}
