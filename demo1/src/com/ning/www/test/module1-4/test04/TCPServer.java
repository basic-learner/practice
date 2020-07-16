package com.homeWork.moudle04.test04;


import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.net.ServerSocket;
import java.net.Socket;

public class TCPServer {
    /*
    1、创建ServerSocket类的对象，构造方法中申请的端口号，调用accept()方法使服务器处于监听状态并返回Socket类对象
    2、创建对象输入流，参数传递的是网络字节输入流
    3、对发送过来的对象信息进行判断
    4、创建对象输出流，参数是网络字节输出流对象
    5、对客户端发来的数据进行判断,并给服务器发送内容
     */
    public static void main(String[] args) throws IOException, ClassNotFoundException {
        //1、创建ServerSocket类的对象，构造方法中申请的端口号，调用accept()方法使服务器处于监听状态并返回Socket类对象
        ServerSocket ss = new ServerSocket(6666);
        Socket socket = ss.accept();
        // 2、创建对象输入流，参数传递的是网络字节输入流
        ObjectInputStream ois = new ObjectInputStream(socket.getInputStream());
        Object o = ois.readObject();
        System.out.println("发送过来的数据是"+o);

        //进行向下转型
        UserMessage um = (UserMessage)o;

        //3、对发送过来的对象信息进行判断
         if("admin".equals(um.getUser().getUseName()) && "123456".equals(um.getUser().getPassWord())){
             um.setS("success");

         }else {
             um.setS("fail");
         }
         //4、创建对象输出流，参数是网络字节输出流对象
        ObjectOutputStream oos = new ObjectOutputStream(socket.getOutputStream());
         oos.writeObject(um);
         //5、关闭流
        oos.close();
        socket.close();
        ss.close();

    }
}

