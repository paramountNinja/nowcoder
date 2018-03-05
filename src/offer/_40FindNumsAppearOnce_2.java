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

 public class _40FindNumsAppearOnce_2 {
     //时间复杂度为O(n),空间复杂度为O(1) 使用异或：相同为0，相异为1
     public void FindNumsAppearOnce(int[] array, int num1[], int num2[]) {
         //先异或所有的数
         int xorResult = 0;
         for (int i = 0; i < array.length; i++)
             xorResult ^= array[i];
         //找到二进制第一个1的位置，做为分组条件
         int index = findFirst1(xorResult);
         for (int i = 0; i < array.length; i++) {
             if (isBit1(array[i], index))
                 num1[0] ^= array[i];
             else
                 num2[0] ^= array[i];
         }
     }

     private boolean isBit1(int target, int index) {
         return ((target >> index) & 1) == 1;
     }

     private int findFirst1(int xorResult) {
         int index = 0;
         while ((xorResult & 1) == 0) {
             xorResult >>= 1;//往右移动一位
             index++;
         }
         return index;
     }
 }
