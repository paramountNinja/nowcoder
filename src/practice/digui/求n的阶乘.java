package practice.digui;

import java.util.Scanner;

public class 求n的阶乘 {

    public static long getFactorial(int n) {
        //退出递归条件  base case
        if (n == 1) return 1L;

        return (long) n * getFactorial(n - 1);
    }

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        System.out.println(getFactorial(n));
    }


}
