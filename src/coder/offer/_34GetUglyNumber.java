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
 * 描述：把只包含因子2、3和5的数称作丑数（Ugly Number）。例如6、8都是丑数，但14不是，因为它包含因子7。 习惯上我们把1当做是第一个丑数。
 * 求按从小到大的顺序的第N个丑数。
 */
 //@formatter:on
public class _34GetUglyNumber {
    //测试,此方法超时
    public int GetUglyNumber_Solution(int index) {
        if (index <= 0) return 0;
        int number = 0;//从1开始一个个尝试,在循环中从1开始
        int i = 0;//次数
        while (i < index) {
            number++;
            if (isUglyNumber(number))
                i++;
        }
        return number;
    }

    //判断是不是丑数
    private boolean isUglyNumber(int number) {
        while (number % 2 == 0)
            number /= 2;
        while (number % 3 == 0)
            number /= 3;
        while (number % 5 == 0)
            number /= 5;
        if (number == 1)
            return true;
        return false;
    }

    //丑数应该是另一个丑数乘以2,3,5
    //每次我们只用比较3个数：用于乘2的最小的数、用于乘3的最小的数，用于乘5的最小的数
    public int GetUglyNumber_Solution2(int index) {
        if (index < 7) return index;
        int[] array = new int[index];
        array[0] = 1;//把第一个位置放上1
        int t2 = 0, t3 = 0, t5 = 0;
        for (int i = 1; i < index; i++) {
            array[i] = findMin(array[t2] * 2, array[t3] * 3, array[t5] * 5);
            if (array[t2] * 2 == array[i]) t2++;
            if (array[t3] * 3 == array[i]) t3++;
            if (array[t5] * 5 == array[i]) t5++;
        }
        return array[index - 1];
    }

    private int findMin(int a, int b, int c) {
        return Math.min(a, Math.min(b, c));
    }
}
