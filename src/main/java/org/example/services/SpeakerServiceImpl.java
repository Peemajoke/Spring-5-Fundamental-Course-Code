package org.example.services;

import org.example.model.Speaker;
import org.example.repository.HibernateSpeakerRepositoryImpl;
import org.example.repository.SpeakerRepository;
import org.springframework.beans.factory.annotation.Autowired;

import java.util.List;

public class SpeakerServiceImpl implements SpeakerService {
    private SpeakerRepository repository;

    public SpeakerServiceImpl(){
        System.out.println("SpeakerServiceImpl no args constructor.");
    }
    public  SpeakerServiceImpl (SpeakerRepository speakerRepository){
        System.out.println("SpeakerServiceImpl repository constructor.");
        repository = speakerRepository;
    }

    @Autowired //* This will inject the speakerRepository bean into this setter automatically. I think in do inject stuff when the speakerService bean get construct.
    public void setRepository(SpeakerRepository repository) {
        System.out.println("SpeakerServiceImpl setter.");
        this.repository = repository;
    }

    @Override
    public List<Speaker> findAll(){
        return repository.findAll();
    }
}
