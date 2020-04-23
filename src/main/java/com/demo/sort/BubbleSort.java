package com.demo.sort;

import java.util.Arrays;

/**
* @Description: 冒泡排序
* @Param:
* @return:
* @Author: pzq
* @Date:
* @throw:
*/
public class BubbleSort {

    public static void sort(int[] arr) {

        // 记录最后一次元素交换的位置，后边的即为有序序列区
        int lastExchangeIndex = 0;
        // 无序序列区的边界，每次比较只需比较到这里为止
        int sortBorder = arr.length - 1;

        for (int i = 0; i < arr.length -1; i++) {
            // 优化加上标志位
            boolean isSorted = true;

            for (int j = 0; j < sortBorder; j++) {

                if (arr[j] > arr[j+1]) {
                    int temp = arr[j];
                    arr[j] = arr[j+1];
                    arr[j+1] = temp;

                    isSorted = false;
                    lastExchangeIndex = j;
                }
            }

            sortBorder = lastExchangeIndex;

            if (isSorted) {
                break;
            }
        }
    }

    public static void main(String[] args) {
        int[] arr = {5,8,6,3,9,2,1,7};
        sort(arr);
        System.out.println(Arrays.toString(arr));
    }
}
