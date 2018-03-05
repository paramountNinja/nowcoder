package base.sort;

//选择排序
public class _02SelectionSort {
    public static void selectionSort(int[] array) {
        if (array == null || array.length <= 0) return;

        for (int i = 0; i < array.length; i++) {
            int min_index = i;
            for (int j = i + 1; j < array.length; j++) { //这个循环主要找到最小值的下标
                if (array[j] < array[min_index])
                    min_index = j;
            }
            int temp = array[i];
            array[i] = array[min_index];
            array[min_index] = temp;
        }

    }

    public static void main(String[] args) {
        int[] array = {1, 2, 3, 5, 3, 4, 8, 10, 20, 101, 98, 2};
        _02SelectionSort.selectionSort(array);
        for (int i = 0; i < array.length; i++) {
            System.out.print(array[i] + " ");
        }
    }
}


//0~n-1 选择最小的放最前面
//1~n-1 选择最小的放最前面
//时间复杂度O(n^2)