package dao.impl;

import dao.userDao;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.stereotype.Component;
import org.springframework.stereotype.Repository;

//@Component("userdao")
//dao层的实例化Bean @Repository
@Repository("userdao")
public class userDaoimpl implements userDao {

    public void save() {
        System.out.println("累巨万呢");
    }

}
