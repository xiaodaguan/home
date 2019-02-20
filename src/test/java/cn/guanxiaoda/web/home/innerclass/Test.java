package cn.guanxiaoda.web.home.innerclass;

/**
 * @author guanxiaoda
 * @date 2019-02-15
 */
public class Test {

    public static void main(String[] args) {
        Fruit.Apple apple = new Fruit.Apple();
        People p = new People();
        People.Man man = p.new Man();
        p.printPName();
        System.out.println(man.name);
    }
}
