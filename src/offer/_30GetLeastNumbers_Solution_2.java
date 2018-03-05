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
import java.util.Comparator;
import java.util.PriorityQueue;

public class _30GetLeastNumbers_Solution_2 {
    //最大堆的方法：使用jdk中的优先队列,返回的不一定是排好序的
    public ArrayList<Integer> GetLeastNumbers_Solution(int[] input, int k) {
        ArrayList<Integer> list = new ArrayList<>();
        if (input == null || input.length <= 0 || k == 0 || k > input.length) return list;
        PriorityQueue<Integer> maxHeap = new PriorityQueue<>(new Comparator<Integer>() {
            @Override
            public int compare(Integer o1, Integer o2) {
                return o2.compareTo(o1); //最大的放前面,最大堆底层：二叉堆层次遍历一样的插入，然后把插入的元素根据大小往上移动（最大堆时则比上面的元素大就往上移动），直到移不动为止
            }
        });
        for (int i = 0; i < input.length; i++) {
            if (maxHeap.size() != k)
                maxHeap.offer(input[i]);
            else if (maxHeap.peek() > input[i]) {
                maxHeap.poll();
                maxHeap.offer(input[i]);
            }
        }
        for (Integer integer : maxHeap)
            list.add(integer);
        return list;
    }

    //测试
    public static void main(String[] args) {
        int[] input = {4, 5, 1, 6, 2, 7, 3, 8};
        int k = 8;
        _30GetLeastNumbers_Solution_2 instance = new _30GetLeastNumbers_Solution_2();
        ArrayList<Integer> list = instance.GetLeastNumbers_Solution(input, k);
        System.out.println(list);
    }
}
