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
 * 描述：输入一棵二叉搜索树，将该二叉搜索树转换成一个排序的双向链表。
 * 要求不能创建任何新的结点，只能调整树中结点指针的指向。
 */
 //@formatter:on
public class _27Convert {
    private class TreeNode {
        int val = 0;
        TreeNode left = null;
        TreeNode right = null;

        public TreeNode(int val) {
            this.val = val;
        }
    }

    //思想：递归 中序遍历
    //用一个指针指向链表第一个元素，用另一个指针通过中序遍历往后遍历
    private TreeNode head = null;
    private TreeNode pNode = null;

    public TreeNode Convert(TreeNode pRootOfTree) {
        if (pRootOfTree == null) return null;
        Convert(pRootOfTree.left);
        if (head == null) {
            head = pNode = pRootOfTree;//在最左边这个节点的时候，标记链表head，并将pNode指向第一个节点
        } else {
            //设置双向指向
            pNode.right = pRootOfTree;
            pRootOfTree.left = pNode;
            pNode = pRootOfTree;//遍历的指针往后移动一位
        }
        Convert(pRootOfTree.right);
        return head;
    }
}
