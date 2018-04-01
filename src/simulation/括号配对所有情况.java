package simulation;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

/*
给出正整数n，请给出所有的包含n个'('和n个')'的字符串，使得'('和')'可以完全匹配。
例如：'(())()','()()()'都是合法的。  '())()('不合法
请按照字典序给出所有合法的字符串
例如：
2
(()),()()
 */
public class 括号配对所有情况 {
    private static void helper(List<String> res, String curStr, int left, int right) {
        if (left == 0 && right == 0) {//说明一种情况结束
            res.add(curStr);
        }
        if (left > 0) {
            curStr = curStr + "(";
            helper(res, curStr, left - 1, right);
            curStr = curStr.substring(0, curStr.length() - 1);//回溯
        }
        if (right > 0 && right > left) {
            curStr = curStr + ")";
            helper(res, curStr, left, right - 1);
        }
    }

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        List<String> res = new ArrayList<>();
        helper(res, "", n, n);//n个(  n个)
        for (int i = 0; i < res.size(); i++) {
            if (i == res.size() - 1) {
                System.out.print(res.get(i));
            } else
                System.out.print(res.get(i) + ",");
        }
    }


}
