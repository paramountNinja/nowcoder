package base.greedy;

import java.util.Arrays;
import java.util.Comparator;

/*
字符串拼接，找到字典序最小的结果
 */
public class 字符串数组拼接 {
    public static class MyComparator implements Comparator<String> {

        @Override
        public int compare(String s1, String s2) {
            return (s1 + s2).compareTo(s2 + s1);
        }
    }

    private static String lowestString(String[] strs) {
        if (strs == null || strs.length == 0) return "";
        Arrays.sort(strs, new MyComparator());
        StringBuilder sb = new StringBuilder();
        for (String s : strs) {
            sb.append(s);
        }
        return sb.toString();
    }

    public static void main(String[] args) {
        String[] strs1 = {"jibw", "ji", "jp", "bw", "jibw"};
        System.out.println(lowestString(strs1));

        String[] strs2 = {"ba", "b"};
        System.out.println(lowestString(strs2));

    }


}


/*
贪心策略：str1.str2 <= str2.str1?str1放前:str2放前

比较器设置需要有传递性：
a.b <= b.a
b.c <= c.b
推出
a.c <= c.a
 */