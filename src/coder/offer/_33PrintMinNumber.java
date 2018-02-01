package coder.offer;

import java.util.Arrays;
import java.util.Comparator;

public class _33PrintMinNumber {
    public String PrintMinNumber(int[] numbers) {
        if (numbers == null || numbers.length <= 0) return "";
        String[] strs = new String[numbers.length];
        for (int i = 0; i < numbers.length; i++)//转化为String数组
            strs[i] = String.valueOf(numbers[i]);
        Arrays.sort(strs, new Comparator<String>() {
            @Override
            public int compare(String s1, String s2) {
                String c1 = s1 + s2;
                String c2 = s2 + s1;
                return c1.compareTo(c2);//谁小放前面，比的是拼接的，放的是原来的s1和s2
            }
        });
        StringBuilder sb = new StringBuilder();
        for (int i = 0; i < strs.length; i++) {
            sb.append(strs[i]);
        }
        return sb.toString();
    }
}

//解题思路：
//先将整型数组转换成String数组，然后将String数组排序，最后将排好序的字符串数组拼接出来。关键就是制定排序规则。
//排序规则如下：
//若ab > ba 则 a > b，
//若ab < ba 则 a < b，
//若ab = ba 则 a = b；
//解释说明：
//比如 "3" < "31"但是 "331" > "313"，所以要将二者拼接起来进行比较