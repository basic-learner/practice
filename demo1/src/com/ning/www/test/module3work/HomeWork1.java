package com.gqn.day06.moudle03;

public class HomeWork1 {
    public static void main(String[] args) {
        /*编程统计字符串"ABCD123!@#$%ab"中大写字母、小写字母、数字其他字符的个数并打印出来"中大写字母、小写字母、数字其他字符的个数并打印出来
      *控制台打印程序的执行流程和最后结果，例如发现大写字母XXX，目前大写字母已有X个。
      *
      * 1、创建一个字符缓冲对象
      * 2、依次接收每个字符，并判断类型
      * 3、将判断好的类型累加到一个数组里面，打印数组长度
      */

      String s = new String("ABCD123!@#$%ab");

      //1、先将构建好的字符串转换为byte[],循环遍历出每个元素，根据ASCLL码来判断
        byte[] b = s.getBytes();
        int big = 0;
        int small = 0;
        int num = 0;
        int other = 0;
        for (int i = 0; i < b.length; i++) {
            if(b[i] >= 97 && b[i] <= 122){
                small++;
                System.out.println("发现小写字母："+(char)b[i]+",目前已有小写字母"+small+"个");
            }else if(b[i] >= 65 && b[i] <= 90){
                big++;
                System.out.println("发现大写字母："+(char)b[i]+",目前已有小写字母"+big+"个");
            }else if(b[i] >= 48 && b[i] <= 57){
                num++;
                System.out.println("发现数字："+(char)b[i]+",目前已有小写字母"+num+"个");
            }else {
                other++;
                System.out.println("发现其他字符："+(char)b[i]+",目前已有其他字符"+other+"个");
            }

        }
        System.out.println("============================================");
        System.out.println("共计大写字母"+big+"个"+"，小写字母"+small+"个"+"，数字"+num+"个"+"，其他"+other+"个");

    }
}
