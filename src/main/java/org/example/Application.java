package org.example;

import org.example.services.SpeakerService;
import org.example.services.SpeakerServiceImpl;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

public class Application {
    public static void main(String[] args) {
        //* Create applicationContext to boostrap our app with config from applicationContext.xml
        ApplicationContext applicationContext = new ClassPathXmlApplicationContext("applicationContext.xml");

        //        SpeakerService service = new SpeakerServiceImpl();
        //* Get bean from appContext.
        SpeakerService service = applicationContext.getBean("speakerService", SpeakerService.class);

        System.out.println(service.findAll().get(0).getFirstname());
        System.out.println(service.findAll().get(0).getLastname());
    }
}
