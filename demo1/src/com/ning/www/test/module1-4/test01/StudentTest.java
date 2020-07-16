package com.homeWork.moudle04.test01;


import java.io.*;
import java.util.ArrayList;
import java.util.Scanner;

public class StudentTest {
   // private static final long serialVersionUID = 6125448892822760604L;
    public static Scanner sc;
    //准备一个集合，接受到文件中读取到的文件信息
    static ArrayList<Student> list = new ArrayList<>() ;
    public static void main(String[] args) {
        list.add(new Student(2016,"张三",18));
        //系统启动时，将文件内容导出给集合
        ObjectInputStream ois = null;
        try {
            FileInputStream fis = new FileInputStream("f:/1.txt");
            ois = new ObjectInputStream(fis);
            list = (ArrayList<Student>)ois.readObject();

        }catch(StreamCorruptedException e) {
            System.out.println("=========================");
        }catch(EOFException e){
            System.out.println("读取成功");
        } catch (Exception e ) {
            e.printStackTrace();
        } finally {
            if (null != ois) {
                try {
                    ois.close();
                } catch (IOException e) {
                    e.printStackTrace();
                }
            }
        }
        //循环遍历集合
        for (Student student : list) {
            System.out.println(student);
        }
        System.out.println("========================");
        //界面显示用户选择相应的功能
        System.out.println("请按照提示选择相应功能");
        System.out.println("1、增加学生信息。2、删除学生信息。3、修改学生信息.4、查找学生信息。5、遍历所有学生。6、退出");
        System.out.println("请输入您选择的功能");
        sc = new Scanner(System.in);
        boolean a = true;

        //choice();


        while (a){
            int next = sc.nextInt();
            switch (next){
                case 1: Chose.add(list);break;
                case 2: Chose.delete(list);break;
                case 3: Chose.update(list);break;
                case 4: Chose.findOut(list);break;
                case 5: Chose.bl(list);break;
                //用户输入为6，结束循环
                case 6: a = false;break;
                default:
                    System.out.println("请按照提示的相应功能输入");
                    break;
            }
        }

        //创建对象传输流：每次结束把集合中的文件写到
        ObjectOutputStream oop = null;
        try {
            oop = new ObjectOutputStream(new FileOutputStream("f:/1.txt"));
            oop.writeObject(list);
            System.out.println("文件提交成功");
        } catch (IOException e) {
            e.printStackTrace();
        } finally {
            if (null != oop) {
                try {
                    oop.close();
                } catch (IOException e) {
                    e.printStackTrace();
                }
            }
        }
    }



}
