package com.github.aspects;

import com.github.annotations.Loggable;
import com.github.utils.ObjectFormatUtils;
import org.aspectj.lang.JoinPoint;
import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Before;
import org.aspectj.lang.annotation.Pointcut;

@Aspect
public class LoggableAspect {

    @Pointcut("@annotation(loggable)")
    public void callAt(Loggable loggable) {
    }

    @Pointcut("execution(* *.*(..))")
    public void anyMethod() {
    }

    @Before(value = "anyMethod() && callAt(loggable)", argNames = "joinPoint,loggable")
    public void processLoggable(JoinPoint joinPoint, Loggable loggable) {
        Object[] args = joinPoint.getArgs();
        String message = loggable.message();
        Object[] decoratedArgs = ObjectFormatUtils.decorateToJsonObjectTreeIfPossible(args);
        if(message.contains("%s")){
            message = String.format(message, decoratedArgs);
        }

        System.out.println(message);
    }
}
