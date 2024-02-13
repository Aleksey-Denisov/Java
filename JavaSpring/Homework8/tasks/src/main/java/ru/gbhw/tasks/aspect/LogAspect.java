package ru.gbhw.tasks.aspect;


import org.aspectj.lang.ProceedingJoinPoint;
import org.aspectj.lang.annotation.Around;
import org.aspectj.lang.annotation.Aspect;
import org.springframework.stereotype.Component;

import java.lang.reflect.Array;
import java.util.Arrays;

@Aspect
@Component
public class LogAspect {
    @Around("@annotation(TrackUserAction)")
    public Object callLog(ProceedingJoinPoint point) throws Throwable {
        System.out.println("Вызов метода: " + point.getSignature().getName()
                + ", с вргументами: " + Arrays.toString(point.getArgs()));
        return point.proceed();
    }
}
