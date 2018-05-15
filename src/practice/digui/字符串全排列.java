package practice.digui;

import java.util.HashSet;
import java.util.Scanner;
import java.util.TreeSet;

/*
打印一个字符串的全排列，（要求不要出现重复的序列）
 */
public class 字符串全排列 {
    public static TreeSet<String> set = new TreeSet<>();

    private static void printAllPermutations(char[] chars, int i) {
        if (i == chars.length) {
            String s = String.valueOf(chars);
            if (!set.contains(s))
                set.add(s);
        }
        for (int j = i; j < chars.length; j++) {
            swap(chars, i, j);
            printAllPermutations(chars, i + 1);
            swap(chars, j, i);//回溯
        }
    }

    private static void swap(char[] chars, int i, int j) {
        char temp = chars[i];
        chars[i] = chars[j];
        chars[j] = temp;
    }

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        String str = sc.nextLine();
        printAllPermutations(str.toCharArray(), 0);
        for (String s : set) {
            System.out.println(s);
        }

    }

}
