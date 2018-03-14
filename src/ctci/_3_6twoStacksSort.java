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
 * 描述：按升序对栈进行排序（即最大元素位于栈顶），要求最多只能使用一个额外的栈存放临时数据，但不得将元素复制到别的数据结构中。
 * 数组的第一个数为栈顶
 */
 //@formatter:on

import java.util.ArrayList;
import java.util.Stack;

public class _3_6twoStacksSort {
    //构建一个辅助栈存放排好序的（栈头是最大值） 和 一个变量存放临时值
    public ArrayList<Integer> twoStacksSort(int[] numbers) {
        ArrayList<Integer> res = new ArrayList<>();
        if (numbers == null || numbers.length == 0) return res;
        Stack<Integer> stack1 = new Stack<>();//原始栈
        for (int i = numbers.length - 1; i >= 0; i--)
            stack1.push(numbers[i]);
        int temp;//存放临时值
        Stack<Integer> stack2 = new Stack<>();
        while (stack1.size() != 0) {
            temp = stack1.pop();
            while (stack2.size() != 0 && stack2.peek() > temp) {//辅助栈不为空，且栈头元素比临时值大
                stack1.push(stack2.pop());
            }
            stack2.push(temp);
        }

        while (stack2.size() != 0) {
            res.add(stack2.pop());
        }
        return res;
    }
}
