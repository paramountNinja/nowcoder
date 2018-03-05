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
 * 描述：输入一个字符串,按字典序打印出该字符串中字符的所有排列。
 * 例如输入字符串abc,则打印出由字符a,b,c所能排列出来的所有字符串abc,acb,bac,bca,cab和cba。
 */
 //@formatter:on

import java.util.ArrayList;
import java.util.Collections;

//回溯法   树
public class _28Permutation {
    private ArrayList<String> result = new ArrayList<>();

    public ArrayList<String> Permutation(String str) {
        if (str != null && str.length() > 0) {
            PermutationHelper(str.toCharArray(), 0);//第0层
            Collections.sort(result);
        }
        return result;
    }

    private void PermutationHelper(char[] array, int level) {//参数，str数组，第几层从0开始
        if (level == array.length - 1) {//最后一层的时候，将叶子节点存入ArrayList
            String value = String.valueOf(array);//转化为string
            if (!result.contains(value))//将重复的结果去除
                result.add(value);
        } else {
            for (int i = level; i < array.length; i++) {//每一层的横向
                swap(array, level, i);
                PermutationHelper(array, level + 1);//纵向递归
                swap(array, level, i);//在回到上一层前进行复位，就是将交换值的两个重新换回来
            }
        }
    }

    private void swap(char[] array, int m, int n) {
        char temp = array[m];
        array[m] = array[n];
        array[n] = temp;
    }
}
