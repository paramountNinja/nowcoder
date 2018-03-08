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
import java.util.Iterator;
import java.util.LinkedList;

public class _59Print {
    public ArrayList<ArrayList<Integer>> Print(TreeNode pRoot) {
        ArrayList<ArrayList<Integer>> result = new ArrayList<>();
        if (pRoot == null) return result;
        boolean leftToRight = true;//标记是否从左向右
        LinkedList<TreeNode> queue = new LinkedList();//我需要借助链表的双向性获得反向元素，所以数据肯定先不拿出来
        queue.addLast(null);//层的分隔符
        queue.addLast(pRoot);
        while (queue.size() != 1) {//如果只有一个的话，说明只有一个分隔符
            TreeNode node = queue.removeFirst();
            if (node == null) {//说明是分隔符，我们一次性将所获取对应层要求的顺序获取队列里面的元素
                Iterator<TreeNode> iter = null;//定义一个迭代器
                if (leftToRight) iter = queue.listIterator();//一行顺序
                else iter = queue.descendingIterator();//一行逆序
                leftToRight = !leftToRight;//设置完迭代器将顺序反向
                ArrayList<Integer> list = new ArrayList<>();//用来存放每一行的结果
                while (iter.hasNext())
                    list.add(iter.next().val);
                result.add(list);
                queue.addLast(null);//存放完之后最后面加一个分隔符
            } else {//说明元素要取出了，我们将其左右孩子放入队列
                if (node.left != null) queue.addLast(node.left);
                if (node.right != null) queue.addLast(node.right);
            }
        }
        return result;
    }
}

/*
利用java中的LinkedList的底层实现是双向链表的特点
可用队列实现树的层次遍历
可双向遍历，奇数层时从前向后遍历，偶数层时从后向前遍历
 */
