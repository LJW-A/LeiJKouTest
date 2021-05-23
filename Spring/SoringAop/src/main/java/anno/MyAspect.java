package anno;

import org.aspectj.lang.ProceedingJoinPoint;
import org.aspectj.lang.annotation.After;
import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Before;
import org.aspectj.lang.annotation.Pointcut;
import org.springframework.stereotype.Component;

@Component("myAspect")
@Aspect  //告知spring是一个切面类
public class MyAspect {

    @Before("pointcut()")
    public void befoer(){
        System.out.println("前置增强的........");
    }

    public void afterrreting(){
        System.out.println("后置增强的........");
    }

    public Object around(ProceedingJoinPoint pdj) throws Throwable {
        System.out.println("环绕前通知增强........");
        Object proceed = pdj.proceed();
        System.out.println("环绕后通知增强........");
        return proceed;
    }

    public void throwing(){
        System.out.println("异常抛出增强........");
    }

    @After("MyAspect.pointcut()")
    public void after(){
        System.out.println("最终增强........");
    }

    @Pointcut("execution(* anno.*.*(..))")
    public void pointcut(){}
}
