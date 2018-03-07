package offer;
//@formatter:off
import java.util.List; /**
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
 * 描述：在一个排序的链表中，存在重复的结点，请删除该链表中重复的结点，重复的结点不保留，返回链表头指针。
 * 例如，链表1->2->3->3->4->4->5 处理后为 1->2->5
 */
 //@formatter:on
public class _56deleteDuplication {
    public ListNode deleteDuplication(ListNode pHead) {
        ListNode preHead = new ListNode(-1);
        preHead.next = pHead;
        ListNode pre = preHead;//标记前面一个节点
        ListNode compare = pHead;//待比较节点
        while (compare != null && compare.next != null) {
            if (compare.val == compare.next.val) {//如果和后面一个数相等
                int temp = compare.val;
                while (compare != null && temp == compare.val) {//只要当前点等于temp即相同的值,compare就往后移动一个
                    compare = compare.next;
                }
                pre.next = compare;//pre接上后面的compare
            } else {//和后面一个数不等，此时可以移动pre了
                pre = compare;
                compare = compare.next;
            }

        }

        return preHead.next;
    }
}
