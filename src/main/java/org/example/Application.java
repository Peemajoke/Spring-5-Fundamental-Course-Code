package org.example;

import org.example.services.SpeakerService;
import org.example.services.SpeakerServiceImpl;
import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;

public class Application {
    public static void main(String[] args) {

        //* We pass the config class (annotated with @Configuration) to load configs in that class into ApplicationContext and load spring up with that configs.
        ApplicationContext applicationContext = new AnnotationConfigApplicationContext(AppConfig.class); // This will create a basic registry with 2 beans in it (speakerService and speakerRepository), and speakerRepository bean is injected into speakerService bean.

//        SpeakerService service = new SpeakerServiceImpl();

        // Pain point 1: Hard Code Referencing SpeakerServiceImpl.
        //* Pain point 1 is now solve as we uses bean that we config instead of hard code referencing.
        SpeakerService service = applicationContext.getBean("speakerService", SpeakerService.class); // This return speakerService bean. Param 2 is class of bean we want to get. This helps the framework ensure that the retrieved bean is of the correct type. If the bean with the given identifier is not of the specified class type, an exception might be thrown.

        System.out.println(service.findAll().get(0).getFirstname());
        System.out.println(service.findAll().get(0).getLastname());
    }
}
