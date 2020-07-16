package com.homeWork.moudle04.test02_3;



import java.io.File;

public class DDelete2 {
    public static void main(String[] args) {
        /*
        1、创建File类的对象和指定目录相关联。
        2、对指定目录进行遍历，分为文件夹和文件两种情况
        3、若是文件夹采用递归继续遍历，若是文件直接删除
         */
        show1();
    }
    public static void show1() {
        //1、创建File类的对象和指定目录相关联。
        File file = new File("f:/目标文件");
        //进行目录判断，若该目录不存在，则不用执行以下代码
        if(!file.exists()){
            System.out.println("你输入的目录不存在！");
        }
        delete(file);
    }

    //采用递归的方式，进行删除
    public static void delete(File file){
        //2、对指定目录进行遍历，分为文件夹和文件两种情况
        File[] files = file.listFiles();


        for (File file1 : files) {
            //对集合下的目录和文件进行一个遍历
            System.out.println(file1);
            //如果是文件直接删除
            if(file1.isFile()){
                file1.delete();
                System.out.println("文件夹"+file+"删除成功");
            }
            if(file1.isDirectory()){
                //如果当前是一个文件夹，则进行递归
                delete(file1);
            }
        }
    }
}

