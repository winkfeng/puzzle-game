package com.itheima.ui;

import com.itheima.domain.path;

import java.util.Random;

public class ArrayUtil {
    private ArrayUtil() {
    }

//    获取打乱二维数组每个索引的子索引
    public static int[][] twoArray() {
        int[] temp = {0, 1, 2, 3, 4, 5, 6, 7, 8, 9, 10, 11, 12, 13, 14, 15};
        Random r = new Random();
        for (int i = 0; i < temp.length; i++) {
            int index = r.nextInt(temp.length);
            int tmp = temp[i];
            temp[i] = temp[index];
            temp[index] = tmp;
        }
// 创建一个二维数组
        int[][] data = new int[4][4];
        int num = 0;
        for (int i = 0; i < data.length; i++) {
            for (int j = 0; j < data[i].length; j++) {
                data[i][j] = temp[num];
                num++;
            }
        }
        return data;
    }
//    获取路径字段
    public static path getPath() {
        int[][] arr={
                {1,2,3,4,5,6,7,8},
                {1,2,3,4,5,6,7,8,9,10,11,12,13},
                {1,2,3,4,5,6,7,8,9,10},
        };
        Random r = new Random();
        int index1 = r.nextInt(arr.length);
        int index2 = r.nextInt(arr[index1].length);
        if (index1==0){
            return new path("animal","animal"+arr[index1][index2]);
        } else if (index1==1) {
            return new path("girl","girl"+arr[index1][index2]);
        }else{
            return new path("sport","sport"+arr[index1][index2]);
        }
    }
}

