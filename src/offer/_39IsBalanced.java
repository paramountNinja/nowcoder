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
 * 描述：输入一棵二叉树，判断该二叉树是否是平衡二叉树。任意节点左右子树的深度不超过1
 */
 //@formatter:on
public class _39IsBalanced {
    //此方法重复遍历了一个节点
    public boolean IsBalanced_Solution(TreeNode root) {
        if (root == null) return true;
        int left = TreeDepth(root.left);
        int right = TreeDepth(root.right);
        int diff = left - right;
        if (diff > 1 || diff < -1) return false;
        return IsBalanced_Solution(root.left) && IsBalanced_Solution(root.right);
    }

    private int TreeDepth(TreeNode node) {
        if (node == null) return 0;
        int leftDepth = TreeDepth(node.left);
        int rightDepth = TreeDepth(node.right);
        return leftDepth > rightDepth ? leftDepth + 1 : rightDepth + 1;
    }
}
