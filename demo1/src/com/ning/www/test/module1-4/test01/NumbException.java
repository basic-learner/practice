package com.homeWork.moudle04.test01;

public class NumbException extends RuntimeException {
    private static final long serialVersionUID = 7107306602063439652L;
    /*
    //实现流程：
           自定义XxxException实现类继承Exception类或者它的子类
           提供两个构造方法：一个无参构造，一个以字符串为参数的构造方法
      异常的产生：
            throw new 异常类型（实参）；
     */
    public NumbException(){}

    public NumbException(String message){
        super(message);
    }
}
