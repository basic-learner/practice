package com.homeWork.moudle04.test02_3;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;

public class RunnableImp implements Runnable {
    //要接受两个传递过来的实参，定义两个成员变量
    private File sourceFile;
    private File descFile;

    public RunnableImp() {
    }

    public RunnableImp(File sourceFile, File descFile) {
        this.sourceFile = sourceFile;
        this.descFile = descFile;
    }

    @Override
    public void run() {
        FileInputStream fis = null;
        FileOutputStream fos = null;
        try {
            //创建FileInputStream类的对象，和源文件相关联
            fis = new FileInputStream(sourceFile);
            //创建FileOutputStream类的对象，和目标文件相关联
            fos = new FileOutputStream(descFile);
            int len = 0;
            byte[] bytes = new byte[1024*8];
            while ((len = fis.read(bytes))!= -1){
                fos.write(bytes,0,len);
            }
            System.out.println("复制成功");
        } catch (IOException e) {
            e.printStackTrace();
        } finally {
            if (null != fos) {
                try {
                    fos.close();
                } catch (IOException e) {
                    e.printStackTrace();
                }
            }
            if (null != fis) {
                try {
                    fis.close();
                } catch (IOException e) {
                    e.printStackTrace();
                }
            }
        }
    }
}
