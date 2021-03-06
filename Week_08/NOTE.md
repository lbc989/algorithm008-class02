学习笔记

/**

* 冒泡排序 稳定

* **最佳情况：T(n) = O(n)  最差情况：T(n) = O(n2)  平均情况：T(n) = O(n2)**

 */
    public static int[] bubbleSort(int[] array) {
if (array.length == 0)
    return array;
for (int i = 0; i < array.length; i++)
    for (int j = 0; j < array.length - 1 - i; j++)
if (array[j + 1] < array[j]) {
    int temp = array[j + 1];
    array[j + 1] = array[j];
    array[j] = temp;
}
return array;
    }



/**

* 选择排序 不稳定

* **最佳情况：T(n) = O(n2)  最差情况：T(n) = O(n2)  平均情况：T(n) = O(n2)**

*/
    public static int[] selectionSort(int[] array) {
if (array.length == 0)
    return array;
for (int i = 0; i < array.length; i++) {
    int minIndex = i;
    for (int j = i; j < array.length; j++) {
if (array[j] < array[minIndex]) //找到最小的数
    minIndex = j; //将最小数的索引保存
    }
    int temp = array[minIndex];
    array[minIndex] = array[i];
    array[i] = temp;
}
return array;
    }



/**

* 插入排序 稳定

* **最佳情况：T(n) = O(n)  最坏情况：T(n) = O(n2)  平均情况：T(n) = O(n2)**

*/   

 public static int[] insertionSort(int[] array) {
        if (array.length == 0)
            return array;
        int current;
        for (int i = 0; i < array.length - 1; i++) {
            current = array[i + 1];
            int preIndex = i;
            while (preIndex >= 0 && current < array[preIndex]) {
                array[preIndex + 1] = array[preIndex];
                preIndex--;
            }
            array[preIndex + 1] = current;
        }
        return array;
    }



/**

* 希尔排序 不稳定

* **最佳情况：T(n) = O(nlog2 n)  最坏情况：T(n) = O(nlog2 n)  平均情况：T(n) =O(nlog2n)**　

*/   

public static int[] ShellSort(int[] array) {
int len = array.length;
int temp, gap = len / 2;
while (gap > 0) {
    for (int i = gap; i < len; i++) {
temp = array[i];
int preIndex = i - gap;
while (preIndex >= 0 && array[preIndex] > temp) {
    array[preIndex + gap] = array[preIndex];
    preIndex -= gap;
}
array[preIndex + gap] = temp;
    }
    gap /= 2;
}
return array;
    }



/**
     * 归并排序 稳定
     * **最佳情况：T(n) = O(n)  最差情况：T(n) = O(nlogn)  平均情况：T(n) = O(nlogn)**

​     */
​    public static int[] MergeSort(int[] array) {
​        if (array.length < 2) return array;
​        int mid = array.length / 2;
​        int[] left = Arrays.copyOfRange(array, 0, mid);
​        int[] right = Arrays.copyOfRange(array, mid, array.length);
​        return merge(MergeSort(left), MergeSort(right));
​    }
​    /**
     * 归并排序——将两段排序好的数组结合成一个排序数组
          *
          * @param left
               * @param right
               * @return
                    */
                public static int[] merge(int[] left, int[] right) {
        int[] result = new int[left.length + right.length];
        for (int index = 0, i = 0, j = 0; index < result.length; index++) {
                    if (i >= left.length)
                result[index] = right[j++];
                    else if (j >= right.length)
                result[index] = left[i++];
                    else if (left[i] > right[j])
                result[index] = right[j++];
                    else
                result[index] = left[i++];
        }
        return result;
                }



/**
   * 快速排序方法 不稳定
   * **最佳情况：T(n) = O(nlogn)  最差情况：T(n) = O(n2)  平均情况：T(n) = O(nlogn)**　
        */
            public static int[] QuickSort(int[] array, int start, int end) {
        if (array.length < 1 || start < 0 || end >= array.length || start > end) return null;
        int smallIndex = partition(array, start, end);
        if (smallIndex > start)
            QuickSort(array, start, smallIndex - 1);
        if (smallIndex < end)
            QuickSort(array, smallIndex + 1, end);
        return array;
            }
            /**
        * 快速排序算法——partition
          */
              public static int partition(int[] array, int start, int end) {
          int pivot = (int) (start + Math.random() * (end - start + 1));
          int smallIndex = start - 1;
          swap(array, pivot, end);
          for (int i = start; i <= end; i++)
              if (array[i] <= array[end]) {
          smallIndex++;
          if (i > smallIndex)
              swap(array, i, smallIndex);
              }
          return smallIndex;
              }

    /**
     * 交换数组内两个元素
     * @param array
     * @param i
     * @param j
     */
    public static void swap(int[] array, int i, int j) {
        int temp = array[i];
        array[i] = array[j];
        array[j] = temp;
    }