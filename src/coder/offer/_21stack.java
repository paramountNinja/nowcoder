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
 * 描述：定义栈的数据结构，请在该类型中实现一个能够得到栈最小元素的min函数。时间复杂度都是O(1)
 */
 //@formatter:on

import java.util.Stack;

public class _21stack {
    //思路：用一个辅助栈存放最小值
    Stack<Integer> dataStack = new Stack<>();
    Stack<Integer> minStack = new Stack<>();
    //标记最小值
    Integer min = null;

    public void push(int node) {
        dataStack.push(node);
        if (min == null || min >= node) {
            minStack.push(node);
            min = node;//update min value
        }
    }

    public void pop() {
        Integer temp = dataStack.pop();
        if (temp == minStack.peek()) {
            minStack.pop();
            min = minStack.peek();//update min value
        }
    }

    public int top() {
        return dataStack.peek();
    }

    public int min() {
        return min;
    }
}
