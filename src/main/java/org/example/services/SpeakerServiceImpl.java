package org.example.services;

import org.example.model.Speaker;
import org.example.repository.HibernateSpeakerRepositoryImpl;
import org.example.repository.SpeakerRepository;

import java.util.List;

public class SpeakerServiceImpl implements SpeakerService {

    // Pain point 2: Hard Code Referencing HibernateSpeakerRepositoryImpl.
    private SpeakerRepository repository;

    public  SpeakerServiceImpl (SpeakerRepository speakerRepository){
        repository = speakerRepository;
    }

    //* Pain point 2 is now gone as SpeakerRepository is needed to be injected rather than hard code by new SpeakerRepository();
    public void setRepository(SpeakerRepository repository) {
        this.repository = repository;
    }

    @Override
    public List<Speaker> findAll(){
        return repository.findAll();
    }
}
