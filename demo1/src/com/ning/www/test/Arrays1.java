package com.gqn.day03;

import java.util.Scanner;

/*
*1、定义一个整数型二维数组，输入所有位置的元素值[16][16]
*2、所有行和列所有元素累加和，并打印
*3、实现二维数组从左上角，到右下角  和右下角到左上交所有元素打印
*/
public class Arrays1 {
    public static void main(String[] args) {
        //定义一个16*16的整数型二位数组
        int[][] arr = new int[16][16];

        //输入，使用Scanner
        System.out.println("请为二维数组进行初始化操作");
        Scanner s = new Scanner(System.in);
        //  完成16*16的二维数组创建
        for (int i = 0; i < arr.length; i++) {
            //行输入一个
            int line = s.nextInt();
            arr[i][0] = line;
            for (int i1 = 1; i1 < arr.length; i1++) {
                //列输出一个
                int rank = s.nextInt();
                arr[i][i1] = rank;
                //arr[i][i1] = [line][rank];
            }
        }
        //循环遍历出二维数组
        for (int i = 0; i < arr.length; i++) {
            for (int i1 = 0; i1 <arr.length; i1++) {
                System.out.print(arr[i][i1]);
                System.out.print(" ");
            }
            System.out.println();
        }

        //分别实现二维数组中所有元素行和列的累加并打印
        int line = 0;
        int rank = 0;
        for (int i = 0; i < arr.length; i++) {
            int i1 = 0;
            for (; i1 < arr.length; i1++) {
               line += arr[i][i1];
               rank += arr[i1][i];
            }

            System.out.println("第"+(i+1)+"行的累加值为"+line);
            System.out.println("第"+(i+1)+"列的累加值为"+rank);

            line = 0;
            rank = 0;
        }

        //所有行和列的元素累加和打印
        int leftRightSum = 0;
        int rightLeftSum = 0;
        for (int i = 0; i < arr.length; i++) {
            for (int i1 = 0; i1 < arr.length; i1++) {
              if(i == i1){
                  leftRightSum += arr[i][i1];
              }
              if(15 == (i + i1)){
                  rightLeftSum += arr[i][i1];
              }

            }

        }
        System.out.println("左上角到右下角的累加和"+leftRightSum);
        System.out.println("右上角到右下角的累加和"+rightLeftSum);
    }
}
