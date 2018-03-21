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
 * 描述：请设计一个算法，寻找二叉树中指定结点的下一个结点（即中序遍历的后继）。
 * 给定树的根结点指针TreeNode* root和结点的值int p，请返回值为p的结点的后继结点的值。
 * 保证结点的值大于等于零小于等于100000且没有重复值，若不存在后继返回-1。
 */
 //@formatter:on
public class _4_6Successor {
    boolean flag = false;//当flag为真时，则表示找到了该数

    public int findSucc(TreeNode root, int p) {
        return helper(root, p);
    }

    private int helper(TreeNode root, int p) {
        if (root == null) return -1;
        int left = helper(root.left, p);//返回的是左儿子的值
        if (left != -1) return left;
        if (flag == true) return root.val;//找到这个值了（其实已经是这个值的下一个节点了，因为在后面一句话置true）则返回当前的值，那么到了上一层被上一句代码拦截，就返回left
        if (root.val == p) flag = true;
        return helper(root.right, p);
    }
}
