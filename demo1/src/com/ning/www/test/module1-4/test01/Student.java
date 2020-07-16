package com.homeWork.moudle04.test01;


import java.io.Serializable;
import java.util.Objects;
import java.util.Scanner;

public class Student implements Serializable {
    private static final long serialVersionUID = -8974405348545029098L;
    //定义一个学生类
    private int numb;
    private String name;
    private int age;
    //重写构造方法，在创建学生对象的时候，提示输入学生的信息。
    public Student() {
        Scanner sc = new Scanner(System.in);
        System.out.println("请输入学生的学号");
        this.setNumb(sc.nextInt());
        System.out.println("请输入学生的姓名");
        this.name = sc.next();
        System.out.println("请输入学生的年龄");
        this.setAge(sc.nextInt());
    }

    public Student(int numb, String name, int age) {
        this.numb = numb;
        this.name = name;
        this.age = age;
    }

    public int getNumb() {
        return numb;
    }

    public void setNumb(int numb) {
        if(numb > 0){
            this.numb = numb;
        }else {
            throw new NumbException("学生的学号不合理");
        }
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getAge() {
        return age;
    }

    public void setAge(int age) {
        if(age > 6 && age < 20){
            this.age = age;
        }else {
            throw new AgeException("学生的年龄不合理");
        }
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Student that = (Student) o;
        return numb == that.numb &&
                age == that.age &&
                Objects.equals(name, that.name);
    }

    @Override
    public int hashCode() {
        return Objects.hash(numb, name, age);
    }

    //重写toString方法
    @Override
    public String toString() {
        return "HomeWork4Student{" +
                "numb=" + numb +
                ", name='" + name + '\'' +
                ", age=" + age +
                '}';
    }
}
