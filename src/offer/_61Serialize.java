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
 * 描述：请实现两个函数，分别用来序列化和反序列化二叉树
 */
 //@formatter:on
public class _61Serialize {
    public int index = -1;


    //只要保持序列化和反序列化规则一样就行
    String Serialize(TreeNode root) {
        StringBuilder sb = new StringBuilder();//每次递归时产生新的
        if (root == null) {
            sb.append("#,");//空用#表示
            return sb.toString();
        }
        //先序遍历
        sb.append(root.val + ",");
        sb.append(Serialize(root.left));//append上左子树
        sb.append(Serialize(root.right));
        return sb.toString();
    }

    TreeNode Deserialize(String str) {
        index++;//标记位置,每次递归都会往后走一个成为左右子树
        int len = str.length();
        /*if (index >= len) //超过了
            return null;*/
        String[] strings = str.split(",");
        TreeNode node = null;
        if (!strings[index].equals("#")) {//如果不是空格
            node = new TreeNode(Integer.valueOf(strings[index]));
            node.left = Deserialize(str);
            node.right = Deserialize(str);
        }
        return node;
    }
}
