package ru.alena.nail.manicurestudio;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.builder.SpringApplicationBuilder;
import org.springframework.boot.web.support.SpringBootServletInitializer;

/**
 * Класс запуска приложения для Tomcat.
 * Данный клас наследуется от SpringBootServletInitializer для того,
 * чтобы была возможность загружать приложение Spring, т.к. web.xml не используется
 *
 * @author Gubanov Artyom.
 */
@SpringBootApplication // то же самое, что @Configuration @EnableAutoConfiguration @ComponentScan
public class TomcatApplication extends SpringBootServletInitializer {

    @Override
    protected SpringApplicationBuilder configure(SpringApplicationBuilder application) {
        return application.sources(TomcatApplication.class);
    }

    public static void main(String[] args) throws Exception {
        SpringApplication.run(TomcatApplication.class, args);
    }

}
