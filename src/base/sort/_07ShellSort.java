package base.sort;

//希尔排序
public class _07ShellSort {
    public static void shellSort(int[] a) {
        if (a == null || a.length <= 0) return;
        int n = a.length;
        for (int gap = n / 2; gap > 0; gap /= 2) {//gap为步长
            for (int i = gap; i < n; i++) {
                int temp = a[i];//保存当前位置的值
                int k = i - gap;//标记每次向前移动步长的位置
                while (k >= 0 && temp < a[k]) {//未到头且比前面位置的小
                    a[k + gap] = a[k];//后面的数设为前面的数,从此开始的后几步思想和堆里面的思想有点像，就是把最小的放前
                    k -= gap;
                }
                a[k + gap] = temp;//将temp值放入移动到的位置，即前面的数比他小了，移不动了
            }
        }

    }

    public static void main(String[] args) {
        int[] array = {4, 5, 3, 0, 1, 7, 2, 6};
        _07ShellSort.shellSort(array);
        for (int i = 0; i < array.length; i++) {
            System.out.print(array[i] + " ");
        }
    }
}


//希尔排序是插入排序的改良，核心：设置步长

