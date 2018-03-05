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
 * 描述：输入两个链表，找出它们的第一个公共结点
 */
 //@formatter:on

import java.util.Stack;

public class _37FindFirstCommonNode_2 {
    //空间换取时间,使用栈的思想,从后往前找到第一个不同的
    public ListNode FindFirstCommonNode(ListNode pHead1, ListNode pHead2) {
        if (pHead1 == null || pHead2 == null) return null;
        Stack<ListNode> s1 = new Stack<>();
        Stack<ListNode> s2 = new Stack<>();
        pushIntoStack(s1, pHead1);
        pushIntoStack(s2, pHead2);
        ListNode result = null;
        while (s1.peek() == s2.peek()) {
            s1.pop();
            s2.pop();
            //注意空栈的情况
            if (s1.isEmpty()) {
                result = pHead1;
                break;
            }
            if (s2.isEmpty()) {
                result = pHead2;
                break;
            }
        }
        if (result == null)
            result = s1.peek().next;
        return result;

    }

    private void pushIntoStack(Stack<ListNode> s, ListNode p) {
        while (p != null) {
            s.push(p);
            p = p.next;

        }
    }

}
