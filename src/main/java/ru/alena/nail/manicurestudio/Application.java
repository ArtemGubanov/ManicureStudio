package ru.alena.nail.manicurestudio;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

/**
 * Класс запуска приложения
 *
 * @author Gubanov Artyom.
 */
@SpringBootApplication // то же самое, что @Configuration @EnableAutoConfiguration @ComponentScan
//@EnableAutoConfiguration
public class Application {

    public static void main(String[] args) {
        SpringApplication.run(Application.class, args);
    }

}
