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
 * 描述：输入一颗二叉树和一个整数，打印出二叉树中结点值的和为输入整数的所有路径。
 * 路径定义为从树的根结点开始往下一直到叶结点所经过的结点形成一条路径。
 */
 //@formatter:on

import java.util.ArrayList;

public class _25FindPath {
    //只有前序遍历是首先打印根节点的  DFS深度优先搜索
    private ArrayList<ArrayList<Integer>> listAll = new ArrayList<>();
    private ArrayList<Integer> list = new ArrayList<>();
    private int sum = 0;

    public ArrayList<ArrayList<Integer>> FindPath(TreeNode root, int target) {
        //to do boundary
        if (root == null) return listAll;
        list.add(root.val);
        sum += root.val;
        if (sum == target && root.left == null && root.right == null)
            listAll.add(new ArrayList<>(list));//这里需要重新new，不然所有的元素都是指向同一个list！
        FindPath(root.left, target);
        FindPath(root.right, target);
        list.remove(list.size() - 1);
        sum -= root.val;
        return listAll;
    }
}
