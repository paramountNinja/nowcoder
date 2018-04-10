package simulation;

import java.util.Scanner;

/*
一个整数N分解为两个整数X和Y相乘,且满足X为奇数,Y为偶数
输入第一行正整数t(1<=t<=1000),接下来t行,每行一个正整数N(2<=N<2^63)
如果找到,一次输出X,Y,如果有多解输出Y最小的那组,以空格风格;否则输出No
2
10
5

5 2
No
 */
public class 因式分解 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int t = sc.nextInt();
        long[] N = new long[t];
        for (int i = 0; i < N.length; i++)
            N[i] = sc.nextLong();
        for (int i = 0; i < N.length; i++)
            findXY(N[i]);
    }

    private static void findXY(long N) {
        if (N % 2 == 1)
            System.out.println("No");
        else {
            long X = N;
            while (X % 2 == 0) {
                X /= 2;
            }
            long Y = N / X;
            System.out.println(X + " " + Y);
        }
    }
}
