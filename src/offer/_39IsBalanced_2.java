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
public class _39IsBalanced_2 {
    //每个节点只遍历一次的解法 后序遍历的时候记录深度
    private boolean isBalanced = true;

    public boolean IsBalanced_Solution(TreeNode root) {
        getDepth(root);
        return isBalanced;
    }

    private int getDepth(TreeNode node) {
        if (node == null) return 0;
        int left = getDepth(node.left);
        int right = getDepth(node.right);
        if (Math.abs(left - right) > 1)//遍历到这个点的时候，如果他不平衡则设为false
            isBalanced = false;
        return right > left ? right + 1 : left + 1;
    }


}
