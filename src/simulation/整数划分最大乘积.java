package simulation;

import java.util.Scanner;

/*
招行信用卡
给出一个整数n，将n分解为至少两个整数之和，使得这些整数的乘积最大化，输出能够获得的最大的乘积。
例如：
2=1+1，输出1
10=3+3+4，输出36
10
36
 */
public class 整数划分最大乘积 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int num = sc.nextInt();
        if (num % 3 == 0) {
            System.out.println((int) (Math.pow(3, num / 3)));
            return;
        }
        if (num % 3 == 1) {
            int temp = num / 3 - 1;
            System.out.println((int) (Math.pow(3, temp) * 4));
        }
        if (num % 3 == 2) {
            int temp = num / 3;
            System.out.println((int) (Math.pow(3, temp) * 2));
        }
        return;
    }

}
