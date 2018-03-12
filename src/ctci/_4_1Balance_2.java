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
 * 描述：检查二叉树是否平衡，平衡的定义如下，对于树中的任意一个结点，其两颗子树的高度差不超过1。
 * 给定指向树根结点的指针TreeNode* root，请返回一个bool，代表这棵树是否平衡。
 */
 //@formatter:on

public class _4_1Balance_2 {
    //法二：后序遍历
    private boolean isBalance = true;

    public boolean isBalance(TreeNode root) {
        if (root == null) return true;
        //isBalance(root.left);这两步不要了，因为下面的代码已经实现了后续遍历
        //isBalance(root.right);
        depth(root);
        return isBalance;
    }


    private int depth(TreeNode node) {
        if (node == null) return 0;
        int left = depth(node.left);
        int right = depth(node.right);
        if (Math.abs(left - right) > 1)
            isBalance = false;
        return left - right > 0 ? left + 1 : right + 1;
    }


}
