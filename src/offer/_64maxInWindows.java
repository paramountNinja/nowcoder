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
 * 描述：给定一个数组和滑动窗口的大小，找出所有滑动窗口里数值的最大值。
 * 例如，如果输入数组{2,3,4,2,6,2,5,1}及滑动窗口的大小3，那么一共存在6个滑动窗口，
 * 他们的最大值分别为{4,4,6,6,6,5}；
 * 针对数组{2,3,4,2,6,2,5,1}的滑动窗口有以下6个：
 * {[2,3,4],2,6,2,5,1}， {2,[3,4,2],6,2,5,1}，
 * {2,3,[4,2,6],2,5,1}，{2,3,4,[2,6,2],5,1}，
 * {2,3,4,2,[6,2,5],1}， {2,3,4,2,6,[2,5,1]}。
 */
 //@formatter:on

import java.util.ArrayDeque;
import java.util.ArrayList;
import java.util.Deque;

public class _64maxInWindows {
    //使用双端队列，存的是下标
    public ArrayList<Integer> maxInWindows(int[] num, int size) {
        ArrayList<Integer> res = new ArrayList<>();
        if (size == 0) return res;
        Deque<Integer> queue = new ArrayDeque<>();//双端队列，存下标
        for (int i = 0; i < num.length; i++) {
            int leftCur = i - size + 1;//左边界，依次往后移动一个
            if (queue.size() == 0) queue.addLast(i);
            //如果此时，队列里的下标已经超出了左边界，那么删除
            if (leftCur > queue.peekFirst()) queue.pollFirst();
            //加入新元素时，从后往前依次删除比他小的，直到比他大了，则加入（因为前面大的那个掉出区域后会被弹出）
            while (!queue.isEmpty() && num[queue.peekLast()] <= num[i])
                queue.pollLast();
            queue.addLast(i);
            if (leftCur >= 0)//说明开始达到size个数了
                res.add(num[queue.peekFirst()]);
        }
        return res;
    }
}
