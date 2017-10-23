package ru.alena.nail.manicurestudio;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

/**
 * Класс запуска приложения для SpringBoot.
 * Данный клас наследуется от SpringBootServletInitializer для того,
 * чтобы была возможность загружать приложение Spring, т.к. web.xml не используется
 *
 * @author Gubanov Artyom.
 */
@SpringBootApplication // то же самое, что @Configuration @EnableAutoConfiguration @ComponentScan
public class Application {

    public static void main(String[] args) {
        SpringApplication.run(Application.class, args);
    }

}
