package practice.greedy;

import java.util.Comparator;
import java.util.PriorityQueue;
import java.util.Scanner;

/*
输入：
        参数0， 总共有n个代做项目
        参数1， 正数数组costs          costs[i]表示i号项目的花费(小于数组里的数的时候表示能做该项目)
        参数2， 正数数组profits        profits[i]表示i号项目在扣除花费之后还能挣到的钱(利润)
        参数3， 正数k                  k表示你不能并行、 只能串行的最多做k个项目
        参数4， 正数m                  m表示你初始的资金
        说明： 你每做完一个项目， 马上获得的收益， 可以支持你去做下一个项目。

输出： 你最后获得的最大钱数。
 */
public class 做项目获得最大钱数 {
    //成本和利润的类
    public static class Node {
        int c;
        int p;

        public Node(int c, int p) {
            this.c = c;
            this.p = p;
        }
    }


    private static int getMaxMoney(int n, int[] costs, int[] profits, int k, int m) {
        //用来过滤比当前money小的项目
        PriorityQueue<Node> minHeap = new PriorityQueue<>(new Comparator<Node>() {
            @Override
            public int compare(Node o1, Node o2) {
                return o1.c - o2.c;
            }
        });
        //用来先做当前最大利润的项目
        PriorityQueue<Node> maxHeap = new PriorityQueue<>(new Comparator<Node>() {
            @Override
            public int compare(Node o1, Node o2) {
                return o2.p - o1.p;
            }
        });
        for (int i = 0; i < n; i++) {
            minHeap.add(new Node(costs[i], profits[i]));
        }
        for (int j = 0; j < k; j++) {
            while (!minHeap.isEmpty() && minHeap.peek().c <= m) {
                maxHeap.add(minHeap.poll());
            }
            if (maxHeap.isEmpty()) {
                return m;
            }
            m += maxHeap.poll().p;
        }
        return m;
    }


    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();//总项目数
        int[] costs = new int[n];
        int[] profits = new int[n];
        for (int i = 0; i < n; i++)
            costs[i] = sc.nextInt();
        for (int i = 0; i < n; i++)
            profits[i] = sc.nextInt();
        int k = sc.nextInt();//最多做的项目数
        int m = sc.nextInt();//初始资金
        int maxMoney = getMaxMoney(n, costs, profits, k, m);
        System.out.println(maxMoney);
    }


}




/*
IPO(公开募股)问题
greedy
小根堆  过滤出能做的项目
大根堆  先做利润大的项目
 */