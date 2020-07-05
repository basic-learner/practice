package com.gqn.day06.moudle03;

import java.util.*;

public class HomeWork3 {
    public static void main(String[] args) {
        //String s =

        //1.准备一个Map集合,字符串存放在key，出现的次数存放在value
        Map<String,Integer> m = new HashMap<String,Integer>();

        //2.准备一个String类型的对象描述原始字符串
        String s = "123,456,789,123,456";

        //3.使用split方法对原始字符串按照字符串中的，拆分字符串，并在集合中查找
        String[]sArr=s.split(",");
        for (int i = 0; i < sArr.length; i++) {

            // 4.若集合中没有该字符串，则将该字符串和1组成一个键值对放入集合中
            if(!m.containsKey(sArr[i])) {
                m.put(sArr[i], 1);
            }
            // 5.若集合中有该字符串，则将该字符串对应的value值+1
            else {
                m.put(sArr[i], m.get(sArr[i])+1);
            }
        }
        System.out.println("m= "+m);
        //6.获取Map集合中所有的映射关系组成Set集合并遍历
        Set<Map.Entry<String,Integer>> s1 = m.entrySet();
        for(Map.Entry<String,Integer> me1:s1) {
            System.out.println(me1);
            System.out.println(me1.getKey()+"出现了"+me1.getValue()+"次！");
        }




    }
}
