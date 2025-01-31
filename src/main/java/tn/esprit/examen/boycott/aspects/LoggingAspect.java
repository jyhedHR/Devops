package tn.esprit.examen.boycott.aspects;

import lombok.extern.slf4j.Slf4j;
import org.aspectj.lang.JoinPoint;
import org.aspectj.lang.annotation.*;
import org.springframework.stereotype.Component;
@Slf4j
@Component
@Aspect
public class LoggingAspect {

    @Before("execution (* tn.esprit.examen.boycott.services.*.*(..))")
    public void methodEntry(JoinPoint joinPoint){

        log.info("Bienvenue à l'un des services de l'application BOYCOTT : "+joinPoint.getSignature().getName());
    }
}
