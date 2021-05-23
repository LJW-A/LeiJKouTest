package config;

import com.alibaba.druid.pool.DruidDataSource;
import com.alibaba.druid.pool.DruidPooledConnection;
import com.mchange.v2.c3p0.ComboPooledDataSource;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Import;
import org.springframework.context.annotation.PropertySource;

import javax.sql.DataSource;
import java.sql.Connection;

@PropertySource("classpath:appliection.properties")
public class SprintconfigrastionTest {

    @Value("${jdbc.driver}")
    private String dirver;

    @Value("${jdbc.url}")
    private String url;

    @Value("${jdbc.password}")
    private String name;

    @Value("${jdbc.username}")
    private String pwd;


    @Bean("dataSource")
    public DataSource getdatasource()throws Exception{
        ComboPooledDataSource datasource=new ComboPooledDataSource();
        //连接数据库的名称
        datasource.setDriverClass(dirver);
        //连接数据库的地址
        datasource.setJdbcUrl(url);
        //数据困密码
        datasource.setPassword(name);
        //数据库名
        datasource.setUser(pwd);
        return datasource;

    }


}
