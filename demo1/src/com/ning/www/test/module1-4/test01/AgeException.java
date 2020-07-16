package com.homeWork.moudle04.test01;

public class AgeException extends RuntimeException {
    private static final long serialVersionUID = -5801944590136090603L;
    //两个构造方法
    public  AgeException(){}

    public  AgeException(String message){
        super(message);
    }
}
