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
 * 描述：有家动物收容所只收留猫和狗，但有特殊的收养规则，收养人有两种收养方式，
 * 第一种为直接收养所有动物中最早进入收容所的，
 * 第二种为选择收养的动物类型（猫或狗），并收养该种动物中最早进入收容所的。
 * 给定一个操作序列int[][2] ope代表所有事件。
 * 若第一个元素为1，则代表有动物进入收容所，第二个元素为动物的编号，正数代表狗，负数代表猫；
 * 若第一个元素为2，则代表有人收养动物，第二个元素若为0，则采取第一种收养方式，若为1，则指定收养狗，若为-1则指定收养猫。
 * 请按顺序返回收养的序列。若出现不合法的操作，即没有可以符合领养要求的动物，则将这次领养操作忽略。
 * 测试样例：[[1,1],[1,-1],[2,0],[2,-1]]
 * 返回：[1,-1]
 */
 //@formatter:on

import java.util.ArrayList;
import java.util.Stack;

public class _3_7CatDogAsylum {
    public ArrayList<Integer> asylum(int[][] ope) {
        ArrayList<Integer> out = new ArrayList<>(); //收养
        ArrayList<Integer> in = new ArrayList<>();  //动物进入收容所
        if (ope == null || ope.length == 0) return out;
        for (int i = 0; i < ope.length; i++) {//遍历每一行
            switch (ope[i][0]) {
                case 1: //进入收容所
                    in.add(ope[i][1]);
                    break;
                case 2: //收养
                    if (ope[i][1] == 0) {//猫狗
                        for (int j = 0; j < in.size(); j++) {
                            if (in.get(j) != 0) {
                                out.add(in.get(j));
                                in.remove(j);//收养掉的删除
                                break;
                            }
                        }
                    } else if (ope[i][1] == 1) {//狗
                        for (int j = 0; j < in.size(); j++) {
                            if (in.get(j) > 0) {
                                out.add(in.get(j));
                                in.remove(j);//收养掉的删除
                                break;
                            }
                        }
                    } else if (ope[i][1] == -1) {//猫
                        for (int j = 0; j < in.size(); j++) {
                            if (in.get(j) < 0) {
                                out.add(in.get(j));
                                in.remove(j);
                                break;
                            }
                        }
                    }
                    break;
            }
        }
        return out;
    }


}
