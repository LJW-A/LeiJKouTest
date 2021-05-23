import dao.UserDao;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

public class Damea {
    public static void main(String[] args) {
        //进行一个获取的这个配置文件
        ApplicationContext app=new ClassPathXmlApplicationContext("appliection.xml");
        //获取这个bean里面的id
        UserDao userrdao = (UserDao) app.getBean("userrdao");
        //调用bean里面指定的方法
        userrdao.save();

    }
}
