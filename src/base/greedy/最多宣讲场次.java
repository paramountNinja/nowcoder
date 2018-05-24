package base.greedy;

import java.util.Comparator;
import java.util.PriorityQueue;
import java.util.Scanner;

/*
一些项目要占用一个会议室宣讲， 会议室不能同时容纳两个项目
的宣讲。 给你每一个项目开始的时间和结束的时间(给你一个数
组， 里面 是一个个具体的项目)， 你来安排宣讲的日程， 要求会
议室进行的宣讲的场次最多。 返回这个最多的宣讲场次。
输入:
第一行: 总项目数
第二行: 每个项目开始时间
第三行: 每个项目结束时间
输出:
最多场次数
 */
public class 最多宣讲场次 {
    public static class Pro {
        int s;
        int e;

        public Pro(int s, int e) {
            this.s = s;
            this.e = e;
        }
    }


    private static int findMaxNum(int n, int[] start, int[] end) {
        PriorityQueue<Pro> minHeap = new PriorityQueue<>(new Comparator<Pro>() {
            @Override
            public int compare(Pro o1, Pro o2) {
                return o1.e - o2.e;
            }
        });
        for (int i = 0; i < n; i++)
            minHeap.add(new Pro(start[i], end[i]));

        int res = 0;
        int e = 0;
        while (!minHeap.isEmpty()) {
            Pro cur = minHeap.poll();
            if (cur.s >= e) {
                res++;
                e = cur.e;
            }
        }
        return res;
    }

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        int[] start = new int[n];
        int[] end = new int[n];
        for (int i = 0; i < n; i++)
            start[i] = sc.nextInt();
        for (int i = 0; i < n; i++)
            end[i] = sc.nextInt();
        int max = findMaxNum(n, start, end);
        System.out.println(max);

    }


}





/*
贪心策略:优先安排结束时间早的场次
最小堆或者直接排序
 */