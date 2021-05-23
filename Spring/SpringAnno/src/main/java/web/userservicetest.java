package web;

import config.Sprintconfihration;
import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;
import service.userservice;

public class userservicetest {

    public static void main(String[] args) {
        //ClassPathXmlApplicationContext app=new ClassPathXmlApplicationContext("DataSource.xml");
        ApplicationContext app=new AnnotationConfigApplicationContext(Sprintconfihration.class);
        userservice userdao = app.getBean(userservice.class);
        userdao.save();



    }
}
