package com.zhy.service.proxy;

import org.aspectj.lang.ProceedingJoinPoint;
import org.aspectj.lang.annotation.Around;
import org.aspectj.lang.annotation.Aspect;
import org.springframework.stereotype.Component;

import java.util.Arrays;

@Aspect
@Component
public class ServiceProxy {
    // 环绕代理：如果要进行后续调用需要知道传递的参数，需要知道具体要调用的业务方法
    @Around("execution(* com.zhy.service..*.*(..))")
    public Object aroundInvoke(ProceedingJoinPoint point) throws Throwable {
        // 正常操作要将用户的参数继续向后传递
        System.out.println("【*** BEFORE ***】执行参数：" + Arrays.toString(point.getArgs()));
        Object obj = point.proceed(point.getArgs()) ;
        // 自己来处理参数内容
//        Object obj = point.proceed(new Object[] {"mldnjava"} ) ;
        System.out.println("【*** AFTER ***】返回结果：" + obj);
        return obj ;
    }
}
