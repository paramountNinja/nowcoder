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
public class _2_5Plus {
    public ListNode plusAB(ListNode a, ListNode b) {
        int one = 0;
        int two = 0;
        int tens = 0;//10的次方
        while (a != null) {
            one += a.val * Math.pow(10, tens);
            a = a.next;
            tens++;
        }
        tens = 0;
        while (b != null) {
            two += b.val * Math.pow(10, tens);
            b = b.next;
            tens++;
        }
        int c = one + two;
        ListNode preHead = new ListNode(-1);
        ListNode p = preHead;
        int place_value = Integer.MIN_VALUE;//一个位置上的值
        while (c > 0) {
            place_value = c % 10;
            ListNode nextNode = new ListNode(place_value);
            p.next = nextNode;
            p = p.next;
            c /= 10;
        }
        return preHead.next;
    }

}
