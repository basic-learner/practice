package com.gqn.day06.moudle03.HomeWork4;

import java.security.PublicKey;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class Chose {

    //调用add方法，先创建一个学生对象，自动调用构造方法，对学生信息进行赋值，然后将创建的对象添加到集合中
    public static void add(List<Student> ls){
        Student s = new Student();
        ls.add(s);
        System.out.println("学生信息添加完成");
        System.out.println("请按照提示进行下一步操作");
    }
    //调用delete方法，学号作为学生的唯一信息，
    public static void delete(List<Student> ls){
        System.out.println("请输入你要删除学生对象的学号");
        Scanner sc = new Scanner(System.in);
        int next = sc.nextInt();
       //遍历集合，
        for (int i = 0; i < ls.size(); i++) {
            if(ls.get(i).getNumb() == next){
                ls.remove(i);
                System.out.println("学生的信息删除成功");
                System.out.println("请按照提示进行下一步操作");
            }else {
                System.out.println("对不起，学生系统中没有该学生的信息。");
                System.out.println("请重新输入2，进入学生信息删除操作");
            }
        }
    }

    //修改信息
    public static void update(List<Student> ls){
        System.out.println("请输入你要修改学生对象的学号");
        Scanner sc = new Scanner(System.in);
        int next = sc.nextInt();
        //遍历集合，
        for (int i = 0; i < ls.size(); i++) {
            if (ls.get(i).getNumb() == next) {
                //创建学生对象，并完成赋值
                Student s = new Student();
                //修改指定位置的学生对象
                ls.set(i,s);
                System.out.println("学生的信息修改成功");
                System.out.println("请按照提示进行下一步操作");
            } else {
                System.out.println("对不起，学生系统中没有该学生的信息。");
                System.out.println("请重新输入3，进入学生信息修改操作");
            }
        }
    }

    //查找信息
    public static void findOut(List<Student> ls){
        System.out.println("请输入你要查找学生对象的学号");
        Scanner sc = new Scanner(System.in);
        int next = sc.nextInt();
        //遍历集合，
        for (int i = 0; i < ls.size(); i++) {
            if (ls.get(i).getNumb() == next) {
                //根据索引值，返回集合中元素对象
                System.out.println(ls.get(i));
               // System.out.println("以上为该学生的信息");
                System.out.println("请按照提示进行下一步操作");
            } else {
                System.out.println("对不起，学生系统中没有该学生的信息。");
                System.out.println("请重新输入4，进入学生信息查询操作");
            }
        }
    }

    //5、遍历信息
    public static void bl(List<Student> ls){
        for (Student l : ls) {
            System.out.println(l);
        }
        System.out.println("请按照提示进行下一步操作");
    }




}
