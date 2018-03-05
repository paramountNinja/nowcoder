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
 * 描述：一个整型数组里除了两个数字之外，其他的数字都出现了两次。请写程序找出这两个只出现一次的数字。
 */
 //@formatter:on

import java.util.HashMap;
import java.util.Map;

public class _40FindNumsAppearOnce {
    //num1,num2分别为长度为1的数组。传出参数
    //将num1[0],num2[0]设置为返回结果
    public void FindNumsAppearOnce(int[] array, int num1[], int num2[]) {
        Map<Integer, Integer> map = new HashMap<>();
        for (int i = 0; i < array.length; i++) {
            if (map.get(array[i]) == null)
                map.put(array[i], 1);
            else
                map.put(array[i], map.get(array[i]) + 1);
            int index = 0;
            for (Integer key : map.keySet()) {
                if (map.get(key) == 1 && index == 0) {
                    num1[0] = key;
                    index++;
                } else if (map.get(key) == 1 && index == 1) {
                    num2[0] = key;
                    break;
                }
            }
            //map的另外一种遍历方法
            /*for (Map.Entry<Integer, Integer> entry : map.entrySet()) {
                if (entry.getValue() == 1 && index == 0) {
                    num1[0] = entry.getKey();
                    index++;
                } else if (entry.getValue() == 1 && index == 1) {
                    num2[0] = entry.getKey();
                    break;
                }
            }*/
        }
    }
}
