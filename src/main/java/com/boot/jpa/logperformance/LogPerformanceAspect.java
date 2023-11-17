package com.boot.jpa.logperformance;

import org.aspectj.lang.ProceedingJoinPoint;
import org.aspectj.lang.annotation.Around;
import org.aspectj.lang.annotation.Aspect;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Component;


@Aspect
@Component
public class LogPerformanceAspect {

    private static final Logger logger = LoggerFactory.getLogger(LogPerformanceAspect.class);

    private final long maxExecutionTimeMs;

    public LogPerformanceAspect(@Value("${max.execution.time.ms:600000}") long maxExecutionTimeMs) {
        this.maxExecutionTimeMs = maxExecutionTimeMs;
    }

    @Around("@annotation(LogPerformance)")
    public Object logPerformance(ProceedingJoinPoint joinPoint) throws Throwable {
        long startTime = System.currentTimeMillis();
        Object result;

        try {
            result = joinPoint.proceed();
        } finally {
            long endTime = System.currentTimeMillis();
            long executionTime = endTime - startTime;

            if (executionTime > maxExecutionTimeMs) {
                logger.error("{} exceeded the time limit. Execution time: {} ms", joinPoint.getSignature(), executionTime);
            } else {
                logger.info("{} executed in {} ms", joinPoint.getSignature(), executionTime);
            }
        }

        return result;
    }
}
