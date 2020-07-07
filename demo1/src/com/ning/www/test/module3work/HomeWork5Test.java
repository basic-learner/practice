package com.gqn.day06.moudle03;

import java.util.*;

public class HomeWork5Test {
    public static void main(String[] args) {
        //定义一个HashMap集合，key值存放索引，value存放牌
        Map<Integer,String> puKe = new HashMap<>();

        //定义一个ArrayList集合，存放索引值
        List<Integer> puKeIndex = new ArrayList<>();
        List<String> num = List.of("2","1","K","Q","J","10","9","8","7","6","5","4","3");
        List<String> color = List.of("♠","♥","♣","♦");
        int count = 0;
        puKe.put(count,"大王");
        puKeIndex.add(count);
        count++;

        puKe.put(count,"小王");
        puKeIndex.add(count);
        count++;

        //循环遍历将牌放入HashMap集合，将下标放入ArrayList集合。
        for (String s : num) {
            for (String s1 : color) {
                //System.out.print(s+s1+" ");
                puKe.put(count,s+s1);
                puKeIndex.add(count);
                count++;
            }
        }

        //将扑克牌打乱
        Collections.shuffle(puKeIndex);

        //2、定义四个集合
        List<Integer> player1 =new ArrayList<>();
        List<Integer> player2 =new ArrayList<>();
        List<Integer> player3 =new ArrayList<>();
        List<Integer> diPai =new ArrayList<>();

        //遍历每一个索引值，根据索引值将牌发出去。
        for (int i = 0; i < puKeIndex.size(); i++) {
            Integer i1 = puKeIndex.get(i);

            if(i >= 51){
                diPai.add(i1);
            }else if(i % 3 == 0){
                player1.add(i1);
            }else if(i % 3 == 1){
                player2.add(i1);
            }else if(i % 3 == 2){
                player3.add(i1);
            }
        }

        //按照索引值排序
        Collections.sort(player1);
        Collections.sort(player2);
        Collections.sort(player3);
        //调用看牌方法。
        look("玩家一",puKe,player1);
        look("玩家二",puKe,player2);
        look("玩家三",puKe,player3);
        look("底牌",puKe,diPai);

    }

    //定义一个看牌的方法
    public static void look(String name,Map<Integer,String> puKe, List<Integer> puKeIndex ){
        System.out.print("玩家名字："+name+" ");
        //遍历传递进来的索引值，在扑克里面寻找对应的value
        for (Integer keIndex : puKeIndex) {
            String s = puKe.get(keIndex);
            System.out.print(s+" ");
        }
        System.out.println();
    }
}
