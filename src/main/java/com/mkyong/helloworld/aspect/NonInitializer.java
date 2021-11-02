package com.mkyong.helloworld.aspect;


import org.aspectj.lang.ProceedingJoinPoint;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Component;

/**
 * Not a javadoc comment.
 * @author GumGum
 */
@Component
public class NonInitializer {
    private static final Logger LOG = LoggerFactory.getLogger(NonInitializer.class);

    public Object doNothing(ProceedingJoinPoint pjp) {
        LOG.info("Doing nothing {}", pjp.getTarget());
        return pjp.getTarget().toString();
    }
}
