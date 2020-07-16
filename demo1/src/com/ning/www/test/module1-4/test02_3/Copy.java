package com.homeWork.moudle04.test02_3;


import java.io.File;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;


public class Copy {
    //将该接口提升为类层级，方便方法的使用
    static ExecutorService es;
    public static void main(String[] args) {
        /*
        1、首先创建一个File类的对象和源文件关联
        2、创建一个线程池
        3、创建一个File类的对象和目标文件相关联
        4、成员方法：copy,实参为源文件夹和目标文件夹
        5、如果是文件则直接拷贝，如果是目录则先在目标文件夹中创建对应文件夹。
        6、创建一个线程池
        7、写一个Runnable的实现类，重写方法中实现文件复制功能
             自己写作业时卡克的点：public FileInputStream​(File file)
             参数
                file - 要打开以供阅读的文件。
                异常
                FileNotFoundException - 如果文件不存在，则是目录而不是常规文件，或者由于某些其他原因无法打开进行读取。
                SecurityException - 如果存在安全管理器且其 checkRead方法拒绝对该文件的读访问权。
         */
        //1、首先创建一个File类的对象和源文件关联
        File sourceFile = new File("f:/源文件");
        //2、创建一个线程池
        es = Executors.newFixedThreadPool(10);
        //3、创建一个File类的对象和目标文件相关联
        File descFile = new File("f:/目标文件");
        if(!descFile.exists()){
            descFile.mkdirs();
        }
        //调用方法
        copy(sourceFile,descFile);

    }
    // 3、成员方法：copy,实参为源文件夹和目标文件夹
    public static void copy(File sourceFile,File descFile){
        File[] files = sourceFile.listFiles();
        //4、如果是文件则直接拷贝，如果是目录则先在目标文件夹中创建对应文件夹。

        for (File file : files) {
            if(file.isFile()){
                //获取文件的名称，到descFile创建对应的文件，并将任务打包给线程池
                String SourceName = file.getName();
                File createNewFile = new File(descFile,SourceName);
                //将获取到的文件源路径信息和目标路径信息发送给线程池
                es.submit(new RunnableImp(file,createNewFile));
            }
            if(file.isDirectory()){
                //获取文件的名称，在目标文件夹中创建对应的文件夹
                String sourceName = file.getName();
                File createNewDir = new File(descFile,sourceName);
                // 递归到下层目录拷贝
                if(createNewDir.mkdirs()){
                    copy(file, createNewDir);
                }
            }
        }

    }
}

