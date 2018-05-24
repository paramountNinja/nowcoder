package practice.diguidonggui;

/*
一个数组arr都是正数，一个整数aim，如果可以任意选择arr中的数字，能不能累加得到aim，返回true或false

若有负数，sum的范围确定，加个飘逸量offset
 */
public class 数组累加和 {

    public static boolean isSum(int i, int[] arr, int sum, int aim) { //sum是当前累加和
        //base case
        if (i == arr.length) {
            return sum == aim;
        }
        return isSum(i + 1, arr, sum, aim) ||
                isSum(i + 1, arr, sum + arr[i], aim);

    }

    //动态规划表
    public static boolean isSum_2(int[] arr, int aim) {
        boolean[][] dp = new boolean[arr.length + 1][aim + 1];
        for (int i = 0; i < dp.length; i++)
            dp[i][aim] = true;   //这一列全设为true
        for (int i = arr.length - 1; i >= 0; i--) {
            for (int j = aim - 1; j >= 0; j--) {
                if (j + arr[i] <= aim)
                    dp[i][j] = dp[i + 1][j] || dp[i + 1][j + arr[i]];
            }
        }
        return dp[0][0];
    }

    public static void main(String[] args) {
        int[] arr = {2, 3, 8, 9};
        //boolean b = isSum(0, arr, 0, 15);
        boolean b = isSum_2(arr, 19);
        System.out.println(b);
    }
}


/*
每个数字要或不要，叶节点是所有的决定
f(0,0)   第一个0是当前下标，第二个0是当前和

转换为动态规划：

举例f(3,5)无后效性   i,sum是可变参数
 */