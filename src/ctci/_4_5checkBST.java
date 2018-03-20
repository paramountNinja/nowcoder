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
 * 描述：请实现一个函数，检查一棵二叉树是否为二叉查找树。
 * 给定树的根结点指针TreeNode* root，请返回一个bool，代表该树是否为二叉查找树。
 */
 //@formatter:on


public class _4_5checkBST {
    //中序遍历 保存上一个元素的值
    int last = Integer.MIN_VALUE;

    public boolean checkBST(TreeNode root) {
        if (root == null) return true;
        if (!checkBST(root.left)) return false;   //左  如果上一层返回的是false,则直接返回false
        if (root.val < last) return false;
        last = root.val;
        if (!checkBST(root.right)) return false;   //右
        return true;
    }
}
