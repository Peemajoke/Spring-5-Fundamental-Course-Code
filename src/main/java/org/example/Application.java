package org.example;

import org.example.services.SpeakerService;
import org.example.services.SpeakerServiceImpl;

public class Application {
    public static void main(String[] args) {
        SpeakerService service = new SpeakerServiceImpl();

        System.out.println(service.findAll().get(0).getFirstname());
        System.out.println(service.findAll().get(0).getLastname());
    }
}
