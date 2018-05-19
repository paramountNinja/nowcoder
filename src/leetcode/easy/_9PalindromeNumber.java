package leetcode.easy;

import java.util.ArrayList;
import java.util.List;

/*
Determine whether an integer is a palindrome. An integer is a palindrome when it reads the same backward as forward.

Example 1:

Input: 121
Output: true
Example 2:

Input: -121
Output: false
Explanation: From left to right, it reads -121. From right to left, it becomes 121-. Therefore it is not a palindrome.
Example 3:

Input: 10
Output: false
Explanation: Reads 01 from right to left. Therefore it is not a palindrome.
Follow up:

Coud you solve it without converting the integer to a string?


 */
public class _9PalindromeNumber {
    //将整数拆分成list，然后比较对应位置的值，但题中指出不使用String的方法
    public boolean isPalindrome(int x) {
        List<Integer> list = new ArrayList<>();
        if (x < 0) return false;
        while (x != 0) {
            list.add(x % 10);
            x /= 10;
        }
        for (int i = 0; i <= list.size() / 2 - 1; i++) {
            if (list.get(i) != list.get(list.size() - 1 - i))
                return false;
        }
        return true;
    }

    //为确保不越界，翻转一半看和另一半是否一致   time: O(log_10 n)
    public boolean isPalindrome_2(int x) {
        if (x < 0 || (x % 10 == 0 && x != 0)) return false;
        int reverse_half = 0; //后半段反转的结果
        while (reverse_half < x) { //超过一半或者相等时停止
            reverse_half = reverse_half * 10 + x % 10;
            x /= 10;
        }
        //偶数位正好相等，奇数位时/10
        return (x == reverse_half) || (x == reverse_half / 10);
    }


}
