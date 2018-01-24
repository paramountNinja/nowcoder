package coder.base;

import java.util.Comparator;
import java.util.PriorityQueue;

//测试jdk中二叉堆的插入数据和删除数据的过程（基于最大堆）
public class HeapTest {
    public PriorityQueue<Integer> getQueue(int[] input) {
        PriorityQueue<Integer> maxHeap = new PriorityQueue<>(new Comparator<Integer>() {
            @Override
            public int compare(Integer o1, Integer o2) {
                return o2.compareTo(o1); //最大的放前面
            }
        });
        for (int i = 0; i < input.length; i++) {
            maxHeap.offer(input[i]);
        }
        //maxHeap.poll();
        //maxHeap.poll();
        //maxHeap.poll();
        //maxHeap.poll();
        return maxHeap;
    }


    public static void main(String[] args) {
        int[] input = {4, 5, 1, 6, 2, 7, 3, 8};
        HeapTest instance = new HeapTest();
        PriorityQueue<Integer> queue = instance.getQueue(input);
        System.out.println(queue);
    }
}

/**
 * 总结：（以最大堆举例）
 * 二叉堆除了最底层外，是完全充满的，从左往右填充
 * 当插入数据时，先插在最后面，然后与上一层数据相比，如果比他大则互换，直到不能换为止
 * 当删除数据时，删除根节点上的值，然后用最后一个值赋值给根节点，下一层的比根节点大的值和他互换，依次下沉
 */
