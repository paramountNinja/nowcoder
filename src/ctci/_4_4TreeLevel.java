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
 * 描述：对于一棵二叉树，请设计一个算法，创建含有某一深度上所有结点的链表。
 * 给定二叉树的根结点指针TreeNode* root，以及链表上结点的深度，请返回一个链表ListNode，代表该深度上所有结点的值，
 * 请按树上从左往右的顺序链接，保证深度不超过树的高度，树上结点的值为非负整数且不超过100000。
 */
 //@formatter:on
public class _4_4TreeLevel {
    //刚开始深度为dep，每往下递归一层，深度-1，当dep == 1时，便输出元素
    ListNode pre = new ListNode(-1);
    ListNode p = pre;//一个指针

    public ListNode getTreeLevel(TreeNode root, int dep) {
        if (root == null || dep <= 0) return null;
        if (dep == 1) {
            p.next = new ListNode(root.val);
            p = p.next;
        } else {
            //前序遍历，先左后右实现从左到右打印
            getTreeLevel(root.left, dep - 1);
            getTreeLevel(root.right, dep - 1);
        }
        return pre.next;
    }
}
