package dao.pactory;

import dao.UserDao;
import dao.dome.Userdaotyest;

public class staticfactory {

    public static UserDao getuserdao(){
        return new Userdaotyest();
    }
}
