package base.sort;

//堆排序
public class _06HeapSort {

    public static void heapSort(int[] array) {
        int n = array.length;

        //先进行堆初始化
        for (int i = n / 2 - 1; i >= 0; --i) //从最后一个父节点开始，依次往前面的父节点初始化
            heapAdjust(array, i, n - 1);
        for (int i = n - 1; i > 0; i--) {//调整的次数

            int temp = array[0];//将最大值交换到最后面，此时最后一个数已经为现堆中的最大值
            array[0] = array[i];
            array[i] = temp;
            heapAdjust(array, 0, i - 1);
        }

    }


    //这是堆调整的过程，而非初始化堆的过程
    private static void heapAdjust(int[] array, int parent, int n) {
        int temp = array[parent];//保存父节点的值
        for (int i = 2 * parent + 1; i <= n; i = 2 * i + 1) {//从子节点开始找子树依次往后遍历（找子节点中大的）
            if (i < n && array[i] < array[i + 1])//i<n不能漏掉，以防最后一个越界
                i++;
            if (temp > array[i]) //说明最上方的数依然是最大的数，所以最大堆依然是成立的，故不需要继续调整 其实就是将temp这个点插入到合适的位置
                break;
            array[parent] = array[i];
            parent = i;//坐标指向孩子
        }
        array[parent] = temp;//此时的parent指向的是当前坐标


    }


    public static void main(String[] args) {
        int[] array = {4, 5, 3, 0, 1, 7, 2, 6};
        _06HeapSort.heapSort(array);
        for (int i = 0; i < array.length; i++) {
            System.out.print(array[i] + " ");
        }
    }
}


/*将数组调整为大根堆，此时最大值在上方（对应的数组顺序是层次遍历）
  将最大值和数组中的最后一个数交换位置，此时最大值固定，脱离最大堆
  对剩下的堆进行最大堆的调整，重复上面的步骤
 */

/*
    堆化数组的过程：
        从最后一个父节点开始，向前遍历每一个父节点，每一次调用调整最大堆核心代码（从最后一个父节点开始，调整好几次）

    调整最大堆的过程（核心代码）
        从第一个节点开始，保存父节点的值，找到他的两个儿子中大的那个，如果父 > 子 ，调出循环；如果父 < 子，则用子的值替换父的值
        然后往下找子节点，同上覆盖值，直到合适的位置，将之前保存的父亲的值插入，即小值下沉的过程

*/

