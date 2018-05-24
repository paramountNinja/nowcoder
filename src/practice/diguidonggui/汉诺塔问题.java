package practice.diguidonggui;

import java.util.Scanner;

/*
总共3个柱子，n个盘子，从第一个柱子移动到第三个柱子上；移动的过程中，不能大压小
*/
public class 汉诺塔问题 {

    public static void process(int n, String from, String to, String help) {
        if (n == 1) System.out.println("move " + 1 + " from " + from + " to " + to);
        else {
            process(n - 1, from, help, to);
            System.out.println("move " + n + " from " + from + " to " + to);
            process(n - 1, help, to, from);
        }
    }


    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        process(n, "左", "右", "中");
    }
}


/*
                      （from  to help 三个柱子）
1-n-1   from -> help
单n     from -> to
1-n-1   help -> to

一个汉诺塔问题需要2^n -1 步数
因为要求打印所有的步数，所以时间复杂度就是O(2^n)
 */
