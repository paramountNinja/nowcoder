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
 * 描述：输入一个链表，输出该链表中倒数第k个结点。
 */
 //@formatter:on

public class _15FindKthToTail {
    //此方法遍历了两次链表
    public ListNode FindKthToTail(ListNode head, int k) {//使用05题中的ListNode类
        if (k <= 0) return null;
        //结点个数
        int nodeCount = 0;
        ListNode p = head;
        while (p != null) {
            nodeCount++;
            p = p.next;
        }
        p = head;
        //所需访问的节点下标
        int index = nodeCount - k;
        //如果超过了总长度，越界
        if (index < 0)
            return null;
        while (index > 0) {
            p = p.next;
            index--;
        }
        return p;
    }

    //使用两个指针遍历了一次链表,一个指针先跳k-1步，然后同时往后跳
    public ListNode FindKthToTail_1(ListNode head, int k) {
        if (head == null || k <= 0) return null;
        ListNode p = head;
        ListNode q = head;
        for (int i = 0; i < k - 1; i++) {
            //越界
            if (p.next != null)
                p = p.next;
            else return null;
        }
        while (p.next != null) {
            p = p.next;
            q = q.next;
        }
        return q;
    }
}
