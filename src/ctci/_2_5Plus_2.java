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
 * 描述：有两个用链表表示的整数，每个结点包含一个数位。
 * 这些数位是反向存放的，也就是个位排在链表的首部。编写函数对这两个整数求和，并用链表形式返回结果。
 * 给定两个链表ListNode* A，ListNode* B，请返回A+B的结果(ListNode*)。
 */
 //@formatter:on
public class _2_5Plus_2 {
    public ListNode plusAB(ListNode a, ListNode b) {
        ListNode preHead = new ListNode(-100);
        ListNode p = preHead;
        int carry = 0;//定义进位
        while (a != null || b != null || carry != 0) {
            int a_value = (a == null) ? 0 : a.val;
            int b_value = (b == null) ? 0 : b.val;
            int sum = a_value + b_value + carry;
            carry = sum / 10;
            ListNode p_next = new ListNode(sum % 10);
            p.next = p_next;
            p = p_next;
            a = (a == null) ? a : a.next;
            b = (b == null) ? b : b.next;
        }
        return preHead.next;
    }

}
