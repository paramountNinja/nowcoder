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
 * 描述：请实现一种数据结构SetOfStacks，由多个栈组成，其中每个栈的大小为size，当前一个栈填满时，新建一个栈。
 * 该数据结构应支持与普通栈相同的push和pop操作。
 * 给定一个操作序列int[][2] ope(C++为vector&ltvector&ltint>>)，每个操作的第一个数代表操作类型，
 * 若为1，则为push操作，后一个数为应push的数字；若为2，则为pop操作，后一个数无意义。
 * 请返回一个int[][]，为完成所有操作后的SetOfStacks，顺序应为从下到上，默认初始的SetOfStacks为空。保证数据合法。
 */
 //@formatter:on

import java.util.ArrayList;
import java.util.Stack;

public class _2_9SetOfStacks {
    public ArrayList<ArrayList<Integer>> setOfStacks(int[][] ope, int size) {
        ArrayList<ArrayList<Integer>> res = new ArrayList<>();
        if (ope == null) return res;
        ArrayList<Integer> curStack = new ArrayList<>(size);
        res.add(curStack);
        for (int i = 0; i < ope.length; i++) {
            switch (ope[i][0]) {
                //push
                case 1:
                    if (curStack.size() < size)
                        curStack.add(ope[i][1]);
                    else {
                        curStack = new ArrayList<>(size);
                        res.add(curStack);
                        curStack.add(ope[i][1]);
                    }
                    break;
                //pop
                case 2:
                    if (!curStack.isEmpty())
                        curStack.remove(curStack.size() - 1);
                    else {
                        res.remove(res.size() - 1);//删除最后一个栈
                        curStack = res.get(res.size() - 1);//当前栈指向最后一个栈
                        curStack.remove(curStack.size() - 1);
                    }
                    break;
            }
        }
        return res;
    }
}
