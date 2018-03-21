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
public class _4_6Successor_2 {
    TreeNode pre = new TreeNode(-1);//前驱指针

    public int findSucc(TreeNode root, int p) {
        if (root == null) return -1;//空
        int left = findSucc(root.left, p);//一路到最左边叶子节点,得到的是左儿子的值
        if (left == -1) {
            //pre指向最左边，root为后继节点
            if (pre.val == p) {
                return root.val;
            }
            pre = root;//如果前一个节点不是，则pre指向root的对象
            return findSucc(root.right, p);
        }
        //如果找不到则返回上一层的根节点
        return left;
    }
}
