package com.demo.sort;

import java.util.Arrays;

/**
* @Description: 快速排序，时间复杂度O（logn）
* @Author: pzq
* @Date:
*/
public class QuickSort {

    /**
     * 快排
     * @param arr
     * @param startIndex
     * @param endIndex
     */
    public static void quickSort(int[] arr, int startIndex, int endIndex) {
        // 递归结束条件：startIndex大于或者等于endIndex时
        if (startIndex >= endIndex) {
            return;
        }

        // 得到基准元素的位置
        int partition = singlePartition(arr, startIndex, endIndex);
        // 根据基准元素，分成两部分进行递归排序
        quickSort(arr, startIndex, partition - 1);
        quickSort(arr, partition + 1, endIndex);
    }

    /**
     * 分治双边循环
     * @param arr
     * @param startIndex
     * @param endIndex
     * @return
     */
    public static int partition(int[] arr, int startIndex, int endIndex) {
        // 取第一个位置元素，作为基准元素
        int pivot = arr[startIndex];
        int left = startIndex;
        int right = endIndex;

        while (left != right) {

            // 控制right指针比较并左移
            while (left < right && pivot < arr[right]) {
                right --;
            }

            // 控制left指针比较并右移
            while (left < right && pivot >= arr[left]) {
                left ++;
            }

            // 交换left指针和right指针的元素
            if (left < right) {
                int temp = arr[left];
                arr[left] = arr[right];
                arr[right] = temp;
            }
        }
        arr[startIndex] = arr[left];
        arr[left] = pivot;

        return left;
    }

    /**
     * 单边循环
     * @param arr
     * @param startIndex
     * @param endIndex
     * @return
     */
    public static int singlePartition(int[] arr, int startIndex, int endIndex) {
        // mark代表小于基准元素的区域边界
        int pivot = arr[startIndex];
        int mark = startIndex;

        for (int i = startIndex + 1; i <= endIndex; i++) {
            if (arr[i] < pivot) {
                mark ++;
                int p = arr[i];
                arr[i] = arr[mark];
                arr[mark] = p;
            }
        }

        arr[startIndex] = arr[mark];
        arr[mark] = pivot;
        return mark;
    }

    public static void main(String[] args) {
        int[] arr = {5,8,6,3,9,2,1,7};
        quickSort(arr, 0, arr.length - 1);
        System.out.println(Arrays.toString(arr));
    }
}
