package AOP;

import org.aspectj.lang.ProceedingJoinPoint;

public class MyAspect {

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

    public void after(){
        System.out.println("最终增强........");
    }
}
