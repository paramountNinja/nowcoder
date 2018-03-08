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
 * 描述：从上到下按层打印二叉树，同一层结点从左至右输出。每一层输出一行。
 */
 //@formatter:on

import java.util.ArrayList;
import java.util.LinkedList;

public class _60Print {
    ArrayList<ArrayList<Integer>> Print(TreeNode pRoot) {
        ArrayList<ArrayList<Integer>> result = new ArrayList<>();
        if (pRoot == null) return result;
        LinkedList<TreeNode> queue = new LinkedList();
        queue.addLast(pRoot);
        while (queue.size() != 0) {
            //记录当前的值
            int lo = 0;
            int hi = queue.size() - 1;
            ArrayList<Integer> list = new ArrayList<>();
            while (lo++ <= hi) {//将当前队列里面的元素拿出打印,这样做不需要另外定义分隔符号
                TreeNode node = queue.removeFirst();//移除的同时加入它的左右子树
                if (node.left != null) queue.addLast(node.left);
                if (node.right != null) queue.addLast(node.right);
                list.add(node.val);
            }
            result.add(list);
        }
        return result;
    }
}
