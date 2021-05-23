import dao.UserDao;
import dao.pactory.dyfactory;
import org.junit.Test;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

public class SprintTest {

    @Test
    //测试scope属性
    public void test(){
        //进行一个获取的这个配置文件
        ClassPathXmlApplicationContext app=new ClassPathXmlApplicationContext("appliection.xml");
        //获取这个bean里面的id
        //dyfactory bean = app.getBean(dyfactory.class);
        dyfactory bean = (dyfactory) app.getBean("factory");
        //UserDao userrdao1 = (UserDao) app.getBean("userrdao");
        System.out.println(bean.save1());
        System.out.println(bean.getMap());
        System.out.println(bean.getList());


        //System.out.println(userrdao1);
       // app.close();





    }
}
