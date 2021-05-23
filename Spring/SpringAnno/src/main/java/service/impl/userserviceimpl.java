package service.impl;

import dao.userDao;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Component;
import org.springframework.stereotype.Service;
import service.userservice;

import javax.annotation.PostConstruct;
import javax.annotation.PreDestroy;
import javax.annotation.Resource;

//@Component("userservice")
@Service("userservice")
//bean 产生的形式 singleton 单例的
@Scope("singleton")
public class userserviceimpl implements userservice {


    @Value("${jdbc.driver}")
    private String name;

    @Autowired
    //相当于跟那个相关联起来
    //@Qualifier("userdao")
    //相当于跟那个相关联起来
    @Resource(name = "userdao")
    private userDao userDao;

    public void save() {
        System.out.println(name);
        userDao.save();
    }


    //相当于 bean标签里面的  init-method=""属性
    @PostConstruct
    public void init(){
        System.out.println("正在初始化");
    }

    //相当于 bean标签里面的 destroy-method="" 属性
    @PreDestroy
    public  void  destory(){
        System.out.println("正在销毁");
    }
}


