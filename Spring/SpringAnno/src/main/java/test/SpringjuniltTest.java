package test;

import config.Sprintconfihration;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;
import service.userservice;

@RunWith(SpringJUnit4ClassRunner.class)
//@ContextConfiguration("classpath:DataSource.xml")
@ContextConfiguration(classes={Sprintconfihration.class})
public class SpringjuniltTest {

    @Autowired
    private userservice us;

    @Test
    public  void test1(){
        us.save();

    }


}
