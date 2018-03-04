package coder.base.sort;

/*
冒泡排序算法

给定一个int数组A，请返回排序后的数组。

测试样例：

[1,2,3,5,2,3]
[1,2,2,3,3,5]
 */
public class _01BubbleSort {

    public static void bubbleSort(int[] array) {
        if (array == null || array.length <= 0) return;
        for (int p = array.length - 1; p >= 0; p--) {
            for (int i = 0; i < p; i++) {//前一个和后面一个比较，故到倒数第二个位置
                if (array[i] > array[i + 1]) {
                    int temp = array[i];
                    array[i] = array[i + 1];
                    array[i + 1] = temp;
                }
            }
        }
    }

    public static void main(String[] args) {
        int[] array = {1, 2, 3, 5, 2, 3, 4, 8, 10, 20, 101, 98};
        _01BubbleSort.bubbleSort(array);
        for (int i = 0; i < array.length; i++) {
            System.out.print(array[i] + " ");
        }
    }
}


//0~n-1比较，并将最大的沉底，
//0~n-2比较，并将最大的沉底，
//...
//时间复杂度O(n^2)
