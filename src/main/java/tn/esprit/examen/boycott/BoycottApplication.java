package tn.esprit.examen.boycott;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.EnableAspectJAutoProxy;
import org.springframework.scheduling.annotation.EnableScheduling;

@EnableAspectJAutoProxy
@EnableScheduling
@SpringBootApplication
public class BoycottApplication {

    public static void main(String[] args) {
        SpringApplication.run(BoycottApplication.class, args);
    }

}
