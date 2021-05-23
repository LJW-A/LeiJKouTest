package JDk;

import java.lang.reflect.InvocationHandler;
import java.lang.reflect.Method;
import java.lang.reflect.Proxy;

public class Proxytets {
    public static void main(String[] args) {

        final Target tg=new Target();

        final Advice ad=new Advice();
        //返回值就是一个动态代理的机制
        //里面是需要三个参数
        //利用这个接口去接返回值  因为要调用里面的方法
        TargetJdk o = (TargetJdk)Proxy.newProxyInstance(
                //获取到这个类
                tg.getClass().getClassLoader(),
                //获取到这个接口
                tg.getClass().getInterfaces(),
                //调用代理的任何方法 都是调用 invoke 方法  是一个反射机制
                new InvocationHandler() {
                    public Object invoke(Object proxy, Method method, Object[] args) throws Throwable {
                        //执行前调用的方法
                        ad.after();
                        //调用当前的方法
                        Object invoke = method.invoke(tg, args);
                        //执行后调用的方法
                        ad.before();
                        return invoke;
                    }
                }
        );
        o.save();

    }
}
