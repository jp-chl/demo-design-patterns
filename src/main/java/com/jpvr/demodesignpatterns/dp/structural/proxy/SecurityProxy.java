package com.jpvr.demodesignpatterns.dp.structural.proxy;

import java.lang.reflect.InvocationHandler;
import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;
import java.lang.reflect.Proxy;

public class SecurityProxy implements InvocationHandler {

    private Object obj;

    private SecurityProxy(Object obj) {
        this.obj = obj;
    } // end private constructor

    @Override
    public Object invoke(Object proxy, Method method, Object[] args) {

        Object result = null;

        try {
            if ( method.getName().toLowerCase().contains("post")) {

                throw new IllegalAccessException("Posts are currently not allowed");
            } else {
                result = method.invoke(obj, args);
            }
        } catch (IllegalAccessException e) {
            e.printStackTrace();
        } catch (InvocationTargetException e) {
            e.printStackTrace();
        } catch (Exception e) {
            throw new RuntimeException("unexpected invocation exception: ", e);
        }

        return result;
    } // end Object invoke(Object proxy, Method method, Object[] args)

    public static Object newInstance(Object object) {

        final ClassLoader classLoader = object.getClass().getClassLoader();
        final Class<?>[] interfaces = object.getClass().getInterfaces();
        final SecurityProxy securityProxy = new SecurityProxy(object);

        final Object o = Proxy.newProxyInstance(classLoader,
                interfaces,
                securityProxy);

        return o;

    } // end static Object newInstance(Object object)
} // end class SecurityProxy implements InvocationHandler
