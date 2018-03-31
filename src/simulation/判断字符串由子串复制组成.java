package simulation;

import java.util.Scanner;

/*
给出一个非空的字符串，判断这个字符串是否是由它的一个子串进行多次首尾拼接构成的。
例如:abcabcabc满足条件输出子串，而abcab不满足条件输出false
 */
public class 判断字符串由子串复制组成 {

    public static boolean check(String a, String sub) {
        int sub_length = sub.length();
        if (a.length() % sub_length != 0) return false;
        int epoch = a.length() / sub_length;
        for (int i = 0; i < epoch; i++) {
            if (!sub.equals(a.substring(sub_length * i, sub_length * i + sub_length)))
                return false;
        }
        return true;
    }

    public static void main(String args[]) {
        Scanner scan = new Scanner(System.in);
        String a = scan.next();
        String result = "";
        boolean flag = false;
        for (int i = 0; i < (a.length() / 2); i++) {
            String sub = a.substring(0, i + 1);
            if (check(a, sub)) {
                flag = true;
                result = sub;
            }
        }
        System.out.print(flag ? result : "false");
    }
}



