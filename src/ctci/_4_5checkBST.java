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

import java.util.Stack;

public class _4_5checkBST {
    //中序遍历判断
    public boolean checkBST(TreeNode root) {
        if (root == null)
            return true;
        Stack<TreeNode> stack = new Stack<TreeNode>();
        TreeNode p = root;
        int pre = 0;// 用于保存中序遍历序列的上一节点值
        boolean isFirst = true;
        while (p != null || !stack.isEmpty()) {
            while (p != null) {
                stack.push(p);
                p = p.left;
            }
            p = stack.pop();
            if (isFirst) {
                pre = p.val;
                isFirst = false;
            } else if (p.val < pre) {
                return false;// 若当前遍历节点的值不大于上一遍历值，则违背了二叉排序树的规则
            } else {
                pre = p.val;
            }
            p = p.right;
        }
        return true;
    }

}
