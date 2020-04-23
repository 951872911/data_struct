package com.demo.sort;

import java.util.Arrays;

/**
 * 插入排序，时间复杂度O（logn）
 */
public class InsertSort {

    /**
    * @Description: 插入排序
    * @Param:
    * @return:
    * @Author: pzq
    * @Date:
    * @throw:
    */
    public static void sort(int[] arr) {

        for (int i = 1; i < arr.length; i++) {

            // 插入的数
            int insertVal = arr[i];
            // 被插入的位置，准备和前一个数比较
            int index = i - 1;

            // 如果被插入的值，小于前一个值，将arr[index]向后移动
            while (index >= 0 && insertVal < arr[index]) {
                arr[index+1] = arr[index];
                // index向前移动
                index --;
            }

            // 把插入的数放入合适的位置
            arr[index+1] = insertVal;
        }
    }


    public static void main(String[] args) {
        int[] arr = {5,8,6,3,9,2,1,7};
        sort(arr);
        System.out.println(Arrays.toString(arr));
    }
}
