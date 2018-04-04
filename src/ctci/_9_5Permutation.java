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
 * 描述：编写一个方法，确定某字符串的所有排列组合。
 * 给定一个string A和一个int n,代表字符串和其长度，请返回所有该字符串字符的排列，保证字符串长度小于等于11且字符串中字符均为大写英文字符，排列中的字符串按字典序从大到小排序。(不合并重复字符串)
 * 测试样例："ABC"返回：["CBA","CAB","BCA","BAC","ACB","ABC"]
 */
 //@formatter:on

import java.util.ArrayList;
import java.util.Collections;

public class _9_5Permutation {


    public ArrayList<String> getPermutation(String A) {
        ArrayList<String> res = new ArrayList<>();
        if (A == null) return res;
        char[] chars = A.toCharArray();
        helper(res, chars, 0);
        Collections.sort(res);
        Collections.reverse(res);
        return res;
    }

    private void helper(ArrayList<String> res, char[] chars, int toFixed) {//第二个参数是对于下一轮需要固定住的位置
        if (toFixed == chars.length - 1) {//到最后一个字符了，这时候可以存入结果集
            String s = String.valueOf(chars);
            res.add(s);//题目要求不合并重复字符串
        } else {
            for (int i = toFixed; i < chars.length; i++) {
                swap(chars, i, toFixed);
                helper(res, chars, toFixed + 1);
                swap(chars, toFixed, i);//回溯到上一层
            }
        }
    }

    private void swap(char[] chars, int i, int j) {
        char temp = chars[i];
        chars[i] = chars[j];
        chars[j] = temp;
    }

    public static void main(String[] args) {
        _9_5Permutation one = new _9_5Permutation();
        ArrayList<String> list = one.getPermutation("abc");
        System.out.println(list);
    }
}
 /*
    固定一个字符，求后面子串的排列
    确定递归的出口：只剩一个字符的时候
 */