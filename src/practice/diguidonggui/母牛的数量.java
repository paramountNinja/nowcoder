package practice.diguidonggui;

import java.util.Scanner;

/*
母牛每年生一只母牛，新出生的母牛成长三年后也能每年生一只母牛，假设不会死。求N年后，母牛的数量
 */
public class 母牛的数量 {

    private static long getCowsNum(int n) {
        if (n < 1) return 0;
        if (n == 1 || n == 2 || n == 3) return n;
        return getCowsNum(n - 1) + getCowsNum(n - 3);
    }

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        System.out.println(getCowsNum(n));
    }

}

/*
f(n) =     f(n-1)        +        f(n-3)
数量     前一年的数量              新生的数量
时间复杂度 O(n)  存在一个矩阵乘法的方法O(logn)
 */