package practice.recursiveANDdynamic;

import java.util.Scanner;

/*
打印字符串的全部子序列，包括空字符串
 */
public class 字符串全部子序列 {

    public static void printAllSub(char[] chars, int i, String res) {
        if (i == chars.length) {
            System.out.println(res);
            return;
        }
        printAllSub(chars, i + 1, res);
        printAllSub(chars, i + 1, res + String.valueOf(chars[i]));
    }

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        String s = sc.nextLine();
        printAllSub(s.toCharArray(), 0, "");
    }
}

/*
abc
第一个位置要不要a; 第二个位置要不要b;第三个位置要不要c 打印叶子节点
                a               ""
           ab       a       b        ""
       abc   ab   ac   a  bc  b     c   ""
 */
