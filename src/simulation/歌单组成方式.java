package simulation;

import java.util.Scanner;

/*
小Q有X首长度为A的不同的歌和Y首长度为B的不同的歌，现在小Q想用这些歌组成一个总长度正好为K的歌单，每首歌最多只能在歌单中出现一次
在不考虑歌单内歌曲先后顺序的情况下，请问有多少种组成歌单的方法。
输入：
第一行表示歌单的总长度
接下来的一行包括四个正整数，分别表示歌的第一种长度A(A<=10) 和数量X(X<=100)以及歌的第二种长度B(B<=10) 和数量Y(Y<=100),保证A不等于B
输出描述：
输出一个整数，表示组成歌单的方法取模。因为答案可能会很大，输出对1000000007取模的结果
5
2 3 3 3

9
 */
public class 歌单组成方式 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int K = sc.nextInt();//歌单长度为K
        int A = sc.nextInt();//A长度的歌,每首歌都不同
        int X = sc.nextInt();//X首
        int B = sc.nextInt();//B长度的歌,...
        int Y = sc.nextInt();//Y首

        int[][] dp = new int[X + Y + 1][K + 1]; //6首歌曲长度为5的方法数,为了数字对应行列都加1
        //i首歌曲,组成长度为0的方法数 = 1
        for (int row = 0; row < X + Y + 1; row++)
            dp[row][0] = 1;
        for (int i = 1; i < X + Y + 1; i++) { // i是歌曲数
            for (int j = 1; j < K + 1; j++) { //j是长度
                if (i <= X) {
                    if (j - A >= 0)
                        dp[i][j] = (dp[i - 1][j] + dp[i - 1][j - A]) % 1000000007;
                    else
                        dp[i][j] = dp[i - 1][j] % 1000000007;
                } else if (i <= X + Y) {
                    if (j - B >= 0)
                        dp[i][j] = (dp[i - 1][j] + dp[i - 1][j - B]) % 1000000007;
                    else
                        dp[i][j] = dp[i - 1][j] % 1000000007;
                }
            }
        }
        System.out.println(dp[X + Y][K]);
    }
}
/*
6首歌组成5的方法 = 5首歌组成5的方法 + 5首歌组成(5-一首歌长度)的方法
                                   (这个加上一首歌正好可以组成6首歌)
或者:
6首歌组成5的方法 = 5首歌组成5的方法
 */