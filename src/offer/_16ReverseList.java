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
 * 描述：输入一个链表，反转链表后，输出链表的所有元素。
 */
 //@formatter:on
public class _16ReverseList {
    public ListNode ReverseList(ListNode head) {
        if (head == null || head.next == null)
            return head;
        ListNode pre = null;
        ListNode p = head;
        ListNode post = p.next;
        while (post != null) {
            //当前节点指向前一个节点
            p.next = pre;
            //依次更新移动标记指针
            pre = p;
            p = post;
            post = post.next;
        }
        //最后一个节点指向前面
        p.next = pre;
        return p;
    }

    //将上述代码进行优化，思路一样
    public ListNode ReverseList_1(ListNode head) {
        if (head == null || head.next == null)
            return head;
        ListNode p = head;
        ListNode pre = null;
        ListNode post = null;
        while (p != null) {
            post = p.next;
            p.next = pre;
            pre = p;
            p = post;
        }
        return pre;
    }
}
