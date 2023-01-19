package com.github.aspects;

import com.github.utils.ObjectFormatUtils;
import org.aspectj.lang.JoinPoint;
import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Before;
import org.aspectj.lang.annotation.Pointcut;

import java.util.Objects;

@Aspect
public class PlaywrightAspect {

    @Pointcut("execution(public * com.microsoft.playwright.impl.PageImpl.*(..))")
    private void executionPlaywrightAspect() {
    }

    @Before(value = "executionPlaywrightAspect()", argNames = "joinPoint")
    public void processPlaywrightMethods(JoinPoint joinPoint) {
        Object[] args = joinPoint.getArgs();
        Object[] decoratedArgs = ObjectFormatUtils.decorateToJsonObjectTreeIfPossible(joinPoint.getArgs());

        String methodName = joinPoint.getSignature().getName();
        String clazzName = joinPoint.getThis().getClass().getSimpleName();
        methodName += Objects.nonNull(args) && args.length > 0 ? String.format("(%s)", ObjectFormatUtils.joinByComma(decoratedArgs)) : "()";
        String message = clazzName + "." + methodName;
        System.out.println("---> " + message);
    }
}
