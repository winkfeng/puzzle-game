package com.itheima.util;

import java.util.Random;

public class CodeUtil {
   private CodeUtil(){}
    public static String getCode(){
       // 验证码获取 验证码规则长度6 4位大写或者小写字母和1位数字组成,同个字母可重复,数字可以出现在任何位置
//       添加大小写字母数组
        Random r=new Random();
        char arr [] = new char[52]; // 字母数组
        for (int i = 0; i < arr.length; i++) {
            if(i<=25){
                arr[i]=(char)(i+'A');
            }else{
                arr[i]=(char)(i-26+'a');
            }
        }
//       生成5个随机字母取下标作拼接
        StringBuilder sb=new StringBuilder();
        for (int i = 0; i < 5; i++) {
            int index = r.nextInt(arr.length);
            sb.append(arr[index]);
        }
//        拼接数字
        int number=r.nextInt(10);
        sb.append(number);
//        转为字符数组
        char[]newArr=sb.toString().toCharArray();
//        获取字符数组随机下标
        int index=r.nextInt(newArr.length);
//        交换位置
            char temp=newArr[newArr.length-1];
            newArr[newArr.length-1]=newArr[index];
            newArr[index]=temp;


    return new String(newArr);
    };
}
