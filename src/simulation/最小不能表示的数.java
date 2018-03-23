package simulation;
/*
输入一串由'0'~'9'组成的字符串，从中选取字符组成数字，例如输入112，可以组成11,12,112,211..但不能组成111,100...
输出最小的不能表示的正整数
样例：
55
1
样例：
0123456789
11
样例：
123456789
10
样例：
12346789
5
样例：
9988776554433221100
66
 */

import java.util.Scanner;

//基本思路：哪个数出现的次数最少，那么就在他个数上追加一个自身的数组成最小不能表示的数，0特殊考虑
public class 最小不能表示的数 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        char[] chars = sc.nextLine().toCharArray();
        int[] number = new int[10];//存放每个数字出现的次数，下标对应数字本身
        for (char c : chars) {
            int i = c - '0';
            number[i]++;
        }
       /* //查看1-9是否有缺的数，如果就输出这个数
        for (int i = 1; i <= 9; i++) {
            if (number[i] == 0) {
                System.out.println(i);
                return;
            }
        }*/
        //寻找最少的数
        int min = 0;//最少数量对应数的下标
        for (int i = 0; i <= 9; i++) {
            if (number[i] < number[min]) {
                min = i;
            }
        }
        if (min == 0) {//说明最少的数是0
            for (int i = 1; i <= 9; i++) {
                if (number[i] == number[0]) {//数量和0的数量相等
                    for (int j = 0; j <= number[i]; j++) {
                        System.out.print(i);
                    }
                    return;
                }
            }
            //到这里说明其他数都比0多,最小数为1000...
            System.out.print(1);
            for (int i = 0; i <= number[0]; i++) {
                System.out.print(0);
            }
        } else {//最少的不是0
            for (int k = 0; k <= number[min]; k++) {
                System.out.print(min);
            }
            return;
        }

    }


    private static void print(int[] number) {
        for (int i : number) {
            System.out.print(i + "\t");
        }
    }
}
