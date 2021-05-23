package config;
import com.alibaba.druid.pool.DruidDataSource;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.*;

import javax.sql.DataSource;

@Configuration
@ComponentScan({"config","service","dao"})
@Import(SprintconfigrastionTest.class)
public class Sprintconfihration {


}
