package cn.guanxiaoda.web.home.exttest;

import java.lang.reflect.InvocationTargetException;

/**
 * @author guanxiaoda
 * @date 2019-02-15
 */
public class Apple extends Fruit {

//    @Override
    public static void print(){
        System.out.println("apple.");
    }

    public void sprint() throws NoSuchMethodException, InvocationTargetException, IllegalAccessException {
        super.getClass().getMethod("print").invoke(this);
    }


    public static void main(String[] args) throws NoSuchMethodException, InvocationTargetException, IllegalAccessException {
        Apple apple = new Apple();
        Apple.print();
        apple.print();
        apple.getClass().getSuperclass().getMethod("print").invoke(apple);
    }
}
