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
 * 描述：一个二维数组，左到右、上到下递增，找一个数
 */
 //@formatter:on
public class _3SearchIn2dArray {
    public boolean Find(int target, int[][] array) {
        if (array == null) return false;
        int rows = array.length;
        int cols = array[0].length;
        int x = rows - 1;
        int y = 0;
        while (x >= 0 && y <= cols - 1) {
            if (array[x][y] == target) return true;
            else if (target > array[x][y]) y++;
            else x--;
        }
        return false;
    }
}
