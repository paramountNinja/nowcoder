package coder.base.sort;

//归并排序算法之递归
public class _04MergeSort {

    //核心代码
    private static void merge_core(int[] array, int start, int mid, int end, int[] temp) {
        int p = start;//两个指针
        int q = mid + 1;
        int k = 0;//temp的下标
        while (p <= mid && q <= end) {
            if (array[p] <= array[q])
                temp[k++] = array[p++];
            else
                temp[k++] = array[q++];
        }
        while (p <= mid)//说明第一段有剩余
            temp[k++] = array[p++];
        while (q <= end)
            temp[k++] = array[q++];
        //将temp数组拷贝回数组中
        for (int i = 0; i < k; i++)
            array[start + i] = temp[i];

    }

    //递归版本////////////////////////////////////////////////////////////////
    public static void mergeSort(int[] array) {
        if (array == null || array.length <= 0) return;
        int[] temp = new int[array.length];//合并时需要用的一个temp数组
        merge(array, 0, array.length - 1, temp);

    }

    private static void merge(int[] array, int start, int end, int[] temp) {
        int mid = start + (end - start) / 2;
        if (start < end) {//注意条件，结束递归
            merge(array, start, mid, temp);
            merge(array, mid + 1, end, temp);
            merge_core(array, start, mid, end, temp);//排序核心
        }

    }


    //非递归版本////////////////////////////////////////////////////////////////
    public static void mergeSort_noRecurse(int[] array) {
        if (array == null || array.length <= 0) return;
        int[] temp = new int[array.length];//合并时需要用的一个temp数组
        int k = 1;
        while (k <= array.length) {//长度为k的子序列两两归并
            merge_noRecurse(array, temp, k);
            k *= 2;

        }
    }

    private static void merge_noRecurse(int[] array, int[] temp, int k) {
        int i = 0;//标记本次排序从头往后哪个位置了
        while (i + k * 2 <= array.length) { //两组合并，可能有剩下的
            int start = i;
            int end = i + k * 2 - 1;
            int mid = i + k - 1;//这里的是固定的，移动k个

            merge_core(array, start, mid, end, temp);
            i += k * 2;
        }
        //上面循环退出说明没有k * 2个数了
        //归并最后两个序列,一组是k个，若多余k个说明有两组，即在k~k*2之间;若没有k个就不需要合并了
        if (array.length - i > k) {
            int start = i;
            int end = array.length - 1;
            int mid = i + k - 1;//这里的是固定的，移动k个
            merge_core(array, start, mid, end, temp);

        }

    }


    public static void main(String[] args) {
        int[] array = {8, 7, 6, 500, 40, 2, 3, 1, 100, 87, 890};
        _04MergeSort.mergeSort_noRecurse(array);
        for (int i = 0; i < array.length; i++) {
            System.out.print(array[i] + " ");
        }
    }
}

//O(n*logn)