package com.example.ktm.config;

import com.example.ktm.enummisc.Types;
import org.aspectj.lang.annotation.After;
import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Before;
import org.springframework.core.Ordered;
import org.springframework.core.annotation.Order;
import org.springframework.stereotype.Component;
import org.springframework.transaction.annotation.Transactional;

@Aspect
@Component
@Order(Ordered.HIGHEST_PRECEDENCE + 1)
public class RoutingAspect {

    @Before("@annotation(transactional)")
    // it checks the readOnly flag and sets the thread-local accordingly
    public void before(Transactional transactional) {

        if (transactional.readOnly()) {
            DataSourceContextHolder.set(Types.DataSourceType.REPLICA);
            System.out.println("Using REPLICA DB");
        } else {
            DataSourceContextHolder.set(Types.DataSourceType.PRIMARY);
            System.out.println("Using PRIMARY DB");
        }
    }

    @After("@annotation(transactional)")
    // always clean up after the method
    public void after(Transactional transactional) {
        DataSourceContextHolder.clear();
    }
}

