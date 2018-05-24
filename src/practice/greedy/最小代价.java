package practice.greedy;

import java.util.PriorityQueue;
import java.util.Scanner;

/*
一块金条切成两半， 是需要花费和长度数值一样的铜板的。 比如
长度为20的 金条， 不管切成长度多大的两半， 都要花费20个铜
板。 一群人想整分整块金条，怎么分最省铜板？
例如,给定数组{10,20,30}， 代表一共三个人， 整块金条长度为
10+20+30=60. 金条要分成10,20,30三个部分。 如果， 先把长
度60的金条分成10和50， 花费60 再把长度50的金条分成20和30，
花费50 一共花费110铜板。
但是如果， 先把长度60的金条分成30和30， 花费60 再把长度30
金条分成10和20， 花费30 一共花费90铜板。
输入一个数组， 返回分割的最小代价。
 */
public class 最小代价 {
    public static int lessMoney(int[] array) {
        PriorityQueue<Integer> pQue = new PriorityQueue();//默认自然顺序,最小堆
        for (int a : array)
            pQue.add(a);
        int money = 0;
        int cur = 0;
        while (pQue.size() > 1) {
            cur = pQue.poll() + pQue.poll();
            money += cur;
            pQue.add(cur);
        }
        return money;
    }


    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        int[] a = new int[n];
        for (int i = 0; i < n; i++)
            a[i] = sc.nextInt();
        System.out.println(lessMoney(a));
    }
}


/*
    greedy+最小堆(优先队列)
    哈夫曼编码 逆向思维
*/