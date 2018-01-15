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
 * 描述：输入一个整数数组，判断该数组是不是某二叉搜索树的后序遍历的结果。
 * 如果是则输出Yes,否则输出No。假设输入的数组的任意两个数字都互不相同。
 */
 //@formatter:on
public class _24VerifySquenceOfBST {
    public boolean VerifySquenceOfBST(int[] sequence) {
        if (sequence == null || sequence.length == 0) return false;
        return verify(sequence, 0, sequence.length - 1);
    }

    private boolean verify(int[] sequence, int start, int end) {
        int root = sequence[end];
        int i = start;//遍历sequence的指针
        //左子树的结点小于根结点
        while (sequence[i] < root) {
            i++;
        }
        //右子树结点大于根结点
        for (; i < end; i++) {
            if (sequence[i] < root) {
                return false;
            }
        }
        boolean left = true;
        if (i > start)
            left = verify(sequence, start, i - 1);
        boolean right = true;
        if (i < end)
            right = verify(sequence, i, end - 1);

        return left && right;

    }
}
