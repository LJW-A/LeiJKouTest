package test;

import AOP.TargetInterface;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration("classpath:appliectionContext.xml")
public class targetTest {

    @Autowired
    private TargetInterface tar;

    @Test
    public void test1(){
        tar.save();
    }
}
