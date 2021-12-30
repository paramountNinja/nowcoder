package base.sort;

//插入排序(其实质也需要移动)
public class _03InsertionSort {
    public static void insertionSort(int[] array) {
        if (array == null || array.length <= 0) return;

        for (int i = 1; i < array.length; i++) {
            int current = i;//标记该数移动到哪个位置了
            for (int j = i - 1; j >= 0; j--) {//依次跟前面的数比较
                if (array[current] < array[j]) {
                    int temp = array[j];
                    array[j] = array[current];
                    array[current] = temp;
                    current--;
                } else {
                    break;
                }

            }
        }

    }


    public static void main(String[] args) {
        int[] array = {10, 9, 8, 8, 7, 12, 19, 20, 20};
        _03InsertionSort.insertionSort(array);
        for (int i = 0; i < array.length; i++) {
            System.out.print(array[i] + " ");
        }
    }

    /**
     * 通用方法：会交换元素
     *
     * @param a
     * @param <T>
     */
    public static <T extends Comparable<T>> void insertionSort_general(T[] a) {
        for (int i = 0; i < a.length; i++) {
            for (int j = i; j - 1 >= 0; j--) {
                if (a[j].compareTo(a[j - 1]) < 0) {
                    T tmp = a[j];
                    a[j] = a[j - 1];
                    a[j - 1] = tmp;
                } else {
                    break;
                }
            }
        }
    }

    /**
     * 最终版：不交换，取出数据依次后移，插入到准确位置
     *
     * @param a
     * @param <T>
     */
    public static <T extends Comparable<T>> void insertionSort_final(T[] a) {
        for (int i = 0; i < a.length; i++) {
            T tmp = a[i];
            int j;
            for (j = i; j - 1 >= 0 && tmp.compareTo(a[j - 1]) < 0; j--) {
                a[j] = a[j - 1];
            }
            a[j] = tmp;
        }
    }
}


//1和0比较，若小往前移动
//2依次和前面的比较，插入到对应的位置
//O(n^2)