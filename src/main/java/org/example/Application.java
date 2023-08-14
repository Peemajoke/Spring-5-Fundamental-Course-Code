package org.example;

import org.example.services.SpeakerService;
import org.example.services.SpeakerServiceImpl;
import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;

public class Application {
    public static void main(String[] args) {

        ApplicationContext applicationContext = new AnnotationConfigApplicationContext(AppConfig.class);

//        SpeakerService service = new SpeakerServiceImpl();

        SpeakerService service = applicationContext.getBean("speakerService", SpeakerService.class);

//        System.out.println(service.findAll().get(0).getFirstname());
//        System.out.println(service.findAll().get(0).getLastname());
        System.out.println(service);

        SpeakerService service2 = applicationContext.getBean("speakerService", SpeakerService.class);
        //* We can see that getBean is returned the different bean.
        System.out.println(service2); // the @base16Number is the object address.
    }
}
