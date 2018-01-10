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
 * 描述：输入两个单调递增的链表，输出两个链表合成后的链表，当然我们需要合成后的链表满足单调不减规则。
 */
 //@formatter:on
public class _17Merge {
    public static ListNode Merge(ListNode list1, ListNode list2) {
        if (list1 == null && list2 == null) return null;
        ListNode p1 = list1;
        ListNode p2 = list2;
        //设一个链表前节点,不能设置为null！
        ListNode preHead = new ListNode(-1);
        //合并链表的当前节点
        ListNode p = preHead;
        while (p1 != null && p2 != null) {
            if (p1.val <= p2.val) {
                p.next = p1;
                p = p.next;
                p1 = p1.next;
            } else {
                p.next = p2;
                p = p.next;
                p2 = p2.next;
            }
        }
        if (p1 != null)
            p.next = p1;
        if (p2 != null)
            p.next = p2;
        return preHead.next;
    }

    public static void main(String[] args) {
        ListNode a = new ListNode(1);
        ListNode b = new ListNode(3);
        ListNode c = new ListNode(5);
        ListNode x = new ListNode(2);
        ListNode y = new ListNode(4);
        ListNode z = new ListNode(6);
        a.next = b;
        b.next = c;
        c.next = null;
        x.next = y;
        y.next = z;
        z.next = null;
        ListNode merge = Merge(a, x);
        while (merge != null) {
            System.out.println(merge.val + " ");
            merge = merge.next;
        }

    }
}
