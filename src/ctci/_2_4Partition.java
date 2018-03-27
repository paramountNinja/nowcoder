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
 * 描述：编写代码，以给定值x为基准将链表分割成两部分，所有小于x的结点排在大于或等于x的结点之前
 * 给定一个链表的头指针 ListNode* pHead，请返回重新排列后的链表的头指针。注意：分割以后保持原来的数据顺序不变。
 */
 //@formatter:on
public class _2_4Partition {
    public ListNode partition(ListNode pHead, int x) {
        if (pHead == null) return null;
        ListNode preHead = new ListNode(-1);
        preHead.next = pHead;
        ListNode pre = preHead;
        ListNode cur = pHead;
        ListNode npre = new ListNode(-1);
        ListNode ncur = npre;
        while (cur != null) {
            if (cur.val < x) {
                pre.next = cur.next;
                cur.next = null;
                ncur.next = cur;
                ncur = ncur.next;
                cur = pre.next;//更新cur的指向
            } else {
                pre = pre.next;
                cur = pre.next;
            }
        }
        ncur.next = preHead.next;
        return npre.next;
    }
}
