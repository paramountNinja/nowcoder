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
 * 描述：输入一个整数n，输出fibonacci的第n项  把中间项存起来，减少每次重复计算的开销 迭代
 */
 //@formatter:on
public class _09Fibonacci_2 {
    public int Fibonacci(int n) {
        if (n <= 1) return n;
        int firstNum = 0;
        int secondNum = 1;
        int thirdNum = 0;
        for (int i = 2; i <= n; i++) {
            thirdNum = firstNum + secondNum;
            firstNum = secondNum;
            secondNum = thirdNum;
        }

        return thirdNum;
    }

    public static void main(String[] args) {
        _09Fibonacci_2 instance = new _09Fibonacci_2();
        int i = instance.Fibonacci(5);
        System.out.println(i);
    }
}
