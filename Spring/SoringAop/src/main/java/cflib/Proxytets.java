package cflib;


import org.springframework.cglib.proxy.Enhancer;
import org.springframework.cglib.proxy.MethodInterceptor;
import org.springframework.cglib.proxy.MethodProxy;

import java.lang.reflect.Method;

public class Proxytets {
    public static void main(String[] args) {

        final Target tg=new Target();

        final Advice ad=new Advice();
        //返回值就是一个动态代理的机制  基于cglib
        //创建一个增强器
        Enhancer enhancer=new Enhancer();
        //设置一个父类
        enhancer.setSuperclass(Target.class);

        //设置他的回调函数
        enhancer.setCallback(new MethodInterceptor() {
            public Object intercept(Object o, Method method, Object[] objects, MethodProxy methodProxy) throws Throwable {

                ad.after();
                Object invoke = method.invoke(tg, objects);
                ad.before();

                return invoke;
            }
        });
        Target o =(Target) enhancer.create();
        o.save();

    }
}
