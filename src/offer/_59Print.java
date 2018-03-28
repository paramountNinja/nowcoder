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
 * 描述：请实现一个函数按照之字形打印二叉树，
 * 即第一行按照从左到右的顺序打印，第二层按照从右至左的顺序打印，第三行按照从左到右的顺序打印，其他行以此类推。
 */
 //@formatter:on

import java.util.ArrayList;
import java.util.Deque;
import java.util.LinkedList;

public class _59Print {

    public ArrayList<ArrayList<Integer>> Print(TreeNode pRoot) {
        boolean flag = true;//true 正
        ArrayList<ArrayList<Integer>> res = new ArrayList<>();
        if (pRoot == null) return res;
        Deque<TreeNode> qu = new LinkedList<>();
        qu.add(pRoot);
        while (!qu.isEmpty()) {
            int len = qu.size();
            ArrayList<Integer> line = new ArrayList<>();
            for (int i = 0; i < len; i++) {
                TreeNode temp;
                if (flag) {
                    temp = qu.pollFirst();
                    line.add(temp.val);
                    if (temp.left != null) qu.add(temp.left);
                    if (temp.right != null) qu.add(temp.right);
                } else {
                    temp = qu.pollLast();
                    line.add(temp.val);
                    if (temp.right != null) qu.addFirst(temp.right);
                    if (temp.left != null) qu.addFirst(temp.left);
                }
            }

            res.add(line);
            flag = !flag;
        }
        return res;
    }
}

/*
利用java中的LinkedList的底层实现是双向链表的特点
可用队列实现树的层次遍历
可双向遍历，奇数层时从前向后遍历,新元素从左向右插到最后面
           偶数层时从后向前遍历，新元素从右向走插到最前面
 */
