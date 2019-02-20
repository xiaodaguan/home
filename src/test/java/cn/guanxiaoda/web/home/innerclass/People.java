package cn.guanxiaoda.web.home.innerclass;


/**
 * @author guanxiaoda
 * @date 2019-02-15
 */
public class People {

    public static String name = "people";

    public void printPName() {
        System.out.println(this.name);
    }

    public class Man {
        public String name = People.name;

    }

}
