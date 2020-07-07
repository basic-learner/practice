package com.gqn.day06.moudle03.HomeWork4;


import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;
import java.util.concurrent.Callable;

public class StudentTest {
    public static void main(String[] args) {

        //构建一个ArrayList集合，存储的是Student对象
        List<Student> ls = new ArrayList<>();
        //给集合中添加一个学生。
        ls.add(new Student(101,"张三",18));
        System.out.println("系统已经存在的学生");

        //调用遍历方法，进行查看系统中已经有的方法
        Chose.bl(ls);

        //界面显示用户选择相应的功能
        System.out.println("请按照提示选择相应功能");
        System.out.println("1、增加学生信息。2、删除学生信息。3、修改学生信息.4、查找学生信息。5、遍历所有学生。6、退出");
        System.out.println("请输入您选择的功能");
        Scanner sc = new Scanner(System.in);

        boolean a = true;
        while (a){
            int next = sc.nextInt();
            switch (next){
                case 1: Chose.add(ls);break;
                case 2: Chose.delete(ls);break;
                case 3: Chose.update(ls);break;
                case 4: Chose.findOut(ls);break;
                case 5: Chose.bl(ls);break;
                //用户输入为6，结束循环
                case 6: a = false;break;
                default:
                    System.out.println("请按照提示的相应功能输入");
                    break;
            }

        }



       // Chose.add(ArrayList1.L);
    }
}
