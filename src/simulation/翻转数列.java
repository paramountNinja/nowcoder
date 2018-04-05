package simulation;

import java.util.Scanner;

/*
小Q定义了一种数列称为翻转数列:
给定整数n和m，满足n能被2m整除。对于一串连续递增整数数列1,2,3,4...每隔m个符号翻转一次，最初符号为'-'。
例如n = 8，m = 2，数列就是：-1,-2,+3,+4,-5,-6,+7,+8
而n = 4，m = 1，数列就是-1，+2，-3，+4
小Q现在希望你能帮他算算前n项和为多少。

输入描述：
输入包括两个整数n和m(2<=n<=10^9,1<=m),并且满足n能被2m整除。
输出描述：
输出一个整数，表示前n项和
8 2
8
 */
public class 翻转数列 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        int m = sc.nextInt();
        long sum = n / 2 * m;
        System.out.println(sum);
    }
}
/*
注：找规律，n能被2m整除是关键，隔m个为一组
 */