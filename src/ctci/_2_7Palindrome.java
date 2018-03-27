package ctci;
//@formatter:off
import java.util.Stack; /**
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
 * 描述：请编写一个函数，检查链表是否为回文。给定一个链表ListNode* pHead，请返回一个bool，代表链表是否为回文。
 */
 //@formatter:on
public class _2_7Palindrome {
    public boolean isPalindrome(ListNode pHead) {
        if (pHead == null) return true;
        ListNode p = pHead;
        int count = 0;
        while (p != null) {
            count++;
            p = p.next;
        }
        p = pHead;
        ListNode q = pHead;
        int mid = 1 + (count - 1) / 2;//快指针开始的下标
        while (mid-- > 0)
            q = q.next;
        Stack<Integer> stack = new Stack<>();
        while (q != null) {
            stack.push(q.val);
            q = q.next;
        }
        while (!stack.isEmpty()) {
            Integer data = stack.pop();
            if (data != p.val) return false;
            p = p.next;
        }
        return true;
    }
}

/*
快慢指针+栈
 */
