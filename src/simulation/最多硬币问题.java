package simulation;

import java.util.Arrays;
import java.util.Scanner;

/*
给定几个数(5) 要求从中选出最多的个数使得他们的和大于给定的值(9) 并且从中减去任何一个数都会比给定值小，返回最多几个数

5 9
1 1 7 2 1
3
 */
public class 最多硬币问题 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int count = sc.nextInt();//个数
        int total = sc.nextInt();//给定值
        int[] coins = new int[count];
        for (int i = 0; i < coins.length; i++) {
            coins[i] = sc.nextInt();
        }
        Arrays.sort(coins);  //排序
        int[] sum = new int[coins.length]; //当前的和
        sum[0] = coins[0];
        int p = 0;
        for (int i = 1; i < coins.length; i++) {
            sum[i] = sum[i - 1] + coins[i];
            if (sum[i] >= total) { //加到超过给定的值为止
                p = i;
                break;
            }
        }

        int preSum = sum[p];
        for (int i = p; i >= 0; i--) {
            if (preSum - coins[i] >= total) { //每一次减去当前位置上的值，如果比给定值大则确定减去
                preSum -= coins[i];
                p--;
            }
        }
        System.out.println(p + 1);
    }
}
