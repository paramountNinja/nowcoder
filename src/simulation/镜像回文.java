package simulation;

import java.util.*;

/**
 * @Desc
 * @Author ninja
 * @Date Created on 2020/4/8
 */
public class 镜像回文 {
    private final static Map<Character, Character> map = new HashMap<Character, Character>() {{
        put('1', '1');
        put('2', '5');
        put('3', '8');
        put('4', '7');
        put('6', '9');
        put('5', '2');
        put('8', '3');
        put('7', '4');
        put('9', '6');
    }};

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int num = sc.nextInt();
        List<String> list = new ArrayList<>();
        for (int i = 0; i < num; i++) {
            String s = sc.next();
            list.add(s);
        }
        mirror(list);
    }

    private static void mirror(List<String> list) {
        for (String s : list) {
            if (judge(s)) {
                System.out.println("YES");
            } else {
                System.out.println("NO");
            }
        }
    }

    private static boolean judge(String s) {
        String s1 = new StringBuilder(s).reverse().toString();
        for (int i = 0; i < s1.length(); i++) {
            if (map.get(s.charAt(i)) != s1.charAt(i)) {
                return false;
            }
        }
        return true;
    }
}
