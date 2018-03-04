package coder.base.sort;

//快速排序
public class _05QuickSort {
    public static void quickSort(int[] array) {
        if (array == null || array.length <= 0) return;
        quick(array, 0, array.length - 1);

    }

    private static void quick(int[] array, int start, int end) {
        if (start < end) {
            int index = quick_core(array, start, end);
            quick(array, start, index - 1);
            quick(array, index + 1, end);
        }
    }


    //划分位置
    private static int quick_core(int[] array, int start, int end) {
        int key = array[end];
        int i = start - 1;
        while (start < end) {
            if (array[start] <= array[end]) {
                int temp = array[i + 1];
                array[i + 1] = array[start];
                array[start] = temp;
                i++;
            }
            start++;
        }
        int temp = array[i + 1];
        array[i + 1] = array[end];
        array[end] = temp;
        return i + 1;
    }


    public static void main(String[] args) {
        int[] array = {54, 35, 48, 36, 27, 12, 44, 44, 8, 14, 26, 17, 28};
        _05QuickSort.quickSort(array);
        for (int i = 0; i < array.length; i++) {
            System.out.print(array[i] + " ");
        }
    }
}


//随机选择一个数，小的放左边，大的放右边
//两边分别递归的调用该方法

//划分值放在最后的位置，最前面设定划分池
//从头开始遍历，如果当前数大于划分值，则不动；如果小于划分值，则跟划分池外的第一个数交换，划分值扩大1
//遍历完之后，划分值和划分池外面的第一个数交换
//O(n*logn)