package dao.dome;

import dao.UserDao;

public class Userdaotyest implements UserDao {

    public void save() {
        System.out.println("这就是一个调用");
    }


    public void save1() {
        System.out.println("创建");
    }


    public void save2() {
        System.out.println("销毁");
    }

}
