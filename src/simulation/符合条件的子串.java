package simulation;

import java.util.Scanner;

/*
给定字符串str，给定一个整数n，得到字符串中连续出现次数为给定整数的所有子串，括号前两个数字是对应的下标位置
例如：
输入：abbcccddeefffgggcc 2
输出  (2,3,bb),(7,8,dd),(9,10,ee),(17,18,cc)
 */
public class 符合条件的子串 {
    public static StringBuilder sb = new StringBuilder();

    public static String getConform(String str, int n) {
        int i = 1;
        int len = 1;
        for (; i < str.length(); i++) {
            if (str.charAt(i) == str.charAt(i - 1)) {
                len++;
            } else {
                if (len == n) {//发现不同，若此时刚好是n个
                    sb.append("(").append(i - n).append(",").append(i - 1).append(",");
                    for (int j = 0; j < n; j++) {
                        sb.append(str.charAt(i - 1));
                    }
                    sb.append("),");
                }
                len = 1;
            }
        }
        if (len == n) {
            sb.append("(").append(i - n).append(",").append(i - 1).append(",");
            for (int j = 0; j < n; j++) {
                sb.append(str.charAt(i - 1));
            }
            sb.append(")");
        }
        return sb.toString();
    }


    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        String str = sc.next();
        int n = sc.nextInt();

        String res = getConform(str, n);
        System.out.println(res);
    }
}
