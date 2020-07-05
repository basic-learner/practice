package com.gqn.day06.moudle03;

import java.util.jar.JarOutputStream;

public class HomeWork2 {
    public static void main(String[] args) {
        /*
        编程获取两个指定字符串中最大相同字串
        提示：将短的那个串进行长度依次递减的字串与较长的串比较
         */
        /*
        1、首先创建两个字符串对象
        2、比较两个字符串的长度，确定短的字符串，使用短的字符串的字串长度依次递减和长串进行比较。
         */
        String s1 = new String("asdafghjla");
        String s2 = new String("aaasdfg");
        String sub = getSonString(s1,s2);
        System.out.println();
        System.out.println("最大相同子字符串是："+sub);
    }

    private static String getSonString(String s1, String s2) {
        String max = null;
        String min = null;
        String sub = " ";
        if (s1.length() > s2.length()) {
            max = s1;
            min = s2;
        } else {
            max = s2;
            min = s1;
        }
      a:  for (int i = 0; i < min.length(); i++) {
            for (int j = 0; j <= i; j++) {

                String substring = min.substring(j, min.length() - i + j);//从小的字符串开始，从左向右移位比较

                System.out.print(substring+" ");

                //一但发现存在子字符串，终止循环。
                if (max.contains(substring)) {
                    sub = substring;
                    break a;
                }
            }

        }

        return sub;

    }

}







