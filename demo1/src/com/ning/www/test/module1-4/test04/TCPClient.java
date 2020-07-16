package com.homeWork.moudle04.test04;

import java.io.*;
import java.net.Socket;

public class TCPClient {
    public static void main(String[] args) throws IOException {
        /*
        1、首先创建Socket类的对象，构造方法中传递的参数为IP地址和Port
        2、创建对象，参数有字符串和User类的对象
        3、创建对象输出流，参数为网络字节输出流，并发送数据
        4、创建对象输入流，参数传递的是网络字节输入流
        5、关闭网络Socket,关闭对象输出流
         */
        // 1、首先创建Socket类的对象，构造方法中传递的参数为IP地址和Port
        Socket socket = new Socket("127.0.0.1",6666);
        // 2、创建对象输出流，参数有字符串和User类的对象
        UserMessage um = new UserMessage("check",new User("amin","123456"));
        // 3、创建对象输出流，参数为网络字节输出流，并发送数据
        ObjectOutputStream oos = new ObjectOutputStream(socket.getOutputStream());
        oos.writeObject(um);
        System.out.println("客户端发送数据成功");

        //4、创建对象输入流，参数传递的是网络字节输入流
        ObjectInputStream ois = new ObjectInputStream(socket.getInputStream());
        Object o = null;
        try {
            o = ois.readObject();
        } catch (ClassNotFoundException e) {
            e.printStackTrace();
        }
        System.out.println("发送过来的数据是"+o);

        //进行向下转型
        UserMessage um1 = (UserMessage)o;

        //3、对发送过来的对象信息进行判断
        if("admin".equals(um.getUser().getUseName()) && "123456".equals(um.getUser().getPassWord())){
            System.out.println("恭喜你登录成功");

        }else {
            System.out.println("登录失败");
        }
        //关闭网络Socket类对象创建的流,关闭对象输入出流
        oos.close();
        ois.close();
        socket.close();

    }


}

