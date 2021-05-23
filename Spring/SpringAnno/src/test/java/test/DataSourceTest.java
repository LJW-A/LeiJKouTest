package test;

import com.alibaba.druid.pool.DruidDataSource;
import com.alibaba.druid.pool.DruidPooledConnection;
import com.mchange.v2.c3p0.ComboPooledDataSource;
import dao.userDao;
import org.junit.Test;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;
import service.userservice;

import javax.sql.DataSource;
import java.sql.Connection;
import java.util.ResourceBundle;

public class DataSourceTest {


    @Test
    public void test7(){
        ApplicationContext app=new ClassPathXmlApplicationContext("DataSource.xml");
        userservice userdao = app.getBean(userservice.class);

        userdao.save();


    }



    @Test
    ////连接数据库 以读取配置文件xml的方式 数据库的方式进行连接 改变他的命名空间的方式
    public void test6() throws Exception{
        ApplicationContext app=new ClassPathXmlApplicationContext("DataSource.xml");
        DataSource datasourcea = (DataSource) app.getBean("datasourceaa");
        Connection connection = datasourcea.getConnection();
        System.out.println(connection);
        connection.close();

    }


    @Test
    ////连接数据库 以读取配置文件 xml的方式 数据库的方式进行连接 c3p0 Druid
    public void test5() throws Exception{
        ApplicationContext app=new ClassPathXmlApplicationContext("DataSource.xml");
        DataSource datasourcea = (DataSource) app.getBean("datasourcea");
        Connection connection = datasourcea.getConnection();
        System.out.println(connection);
        connection.close();

    }


    @Test
    //连接数据库 以读取配置文件 xml的方式 数据库的方式进行连接 c3p0
    public void test4() throws Exception{
        ApplicationContext app=new ClassPathXmlApplicationContext("DataSource.xml");
        DataSource datasource = app.getBean(DataSource.class);
        Connection connection = datasource.getConnection();
        System.out.println(connection);

    }



    @Test
    //连接数据库 以读取配置文件.properties 数据库的方式进行连接  c3p0
    public void test3() throws Exception{
        //这个API是Java官方提供的一个读取.properties文件的一个API
        ResourceBundle appliection = ResourceBundle.getBundle("appliection");
        //获取连接对象
        String drriver = appliection.getString("jdbc.driver");
        //获取连接地址
        String url = appliection.getString("jdbc.url");
        //获取连接密码
        String pwd = appliection.getString("jdbc.password");
        //获取连接账号
        String userrname = appliection.getString("jdbc.username");

        ComboPooledDataSource dataSource=new ComboPooledDataSource();
        dataSource.setDriverClass(drriver);
        dataSource.setJdbcUrl(url);
        dataSource.setPassword(pwd);
        dataSource.setUser(userrname);
        Connection connection = dataSource.getConnection();
        System.out.println(connection);
        connection.close();


    }

    @Test
    //手动创建druid
    public void test2() throws Exception{
        DruidDataSource datasource=new DruidDataSource();
        datasource.setDriverClassName("com.mysql.jdbc.Driver");
        datasource.setUrl("jdbc:mysql://localhost:3306/ydma");
        datasource.setPassword("123456");
        datasource.setUsername("root");
        DruidPooledConnection connection = datasource.getConnection();
        System.out.println(connection);
        connection.close();


    }



    @Test
    //手动创建c3p0
    public void test1() throws Exception{
        ComboPooledDataSource datasource=new ComboPooledDataSource();
        //连接数据库的名称
        datasource.setDriverClass("com.mysql.jdbc.Driver");
        //连接数据库的地址
        datasource.setJdbcUrl("jdbc:mysql://localhost:3306/ydma");
        //数据困密码
        datasource.setPassword("123456");
        //数据库名
        datasource.setUser("root");
        Connection connection = datasource.getConnection();
        System.out.println(connection);
        connection.close();
    }
}
