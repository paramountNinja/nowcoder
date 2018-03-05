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
public class _37FindFirstCommonNode {
    public ListNode FindFirstCommonNode(ListNode pHead1, ListNode pHead2) {
        if (pHead1 == null || pHead2 == null) return null;
        int len1 = getLength(pHead1);
        int len2 = getLength(pHead2);
        int step = len1 - len2;
        ListNode pLong = pHead1;
        ListNode pShort = pHead2;
        if (step < 0) {
            pLong = pHead2;
            pShort = pHead1;
            step = -step;
        }
        for (int i = 0; i < step; i++)
            pLong = pLong.next;
        //到这里两个指针处在同一起跑线上,即后面的节点数量相同
        while (pLong != null && pShort != null && pLong != pShort) {
            pLong = pLong.next;
            pShort = pShort.next;
        }
        //相等即调出循环,到末尾没有公共节点也跳出循环
        return pLong;

    }

    //获得链表长度
    private int getLength(ListNode head) {
        int len = 0;
        while (head != null) {
            len++;
            head = head.next;
        }
        return len;
    }
}
