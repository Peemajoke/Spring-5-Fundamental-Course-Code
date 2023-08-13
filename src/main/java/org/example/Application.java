package org.example;

import org.example.services.SpeakerService;
import org.example.services.SpeakerServiceImpl;

public class Application {
    public static void main(String[] args) {

        //! Pain point 1: Hard Code Referencing SpeakerServiceImpl.
        //! To change to new other class, even if it implements the same interface, rebuild is required.
        //* Spring can make a factory to load SpeakerServiceImpl for us.
        SpeakerService service = new SpeakerServiceImpl();

        System.out.println(service.findAll().get(0).getFirstname());
        System.out.println(service.findAll().get(0).getLastname());
    }
}
