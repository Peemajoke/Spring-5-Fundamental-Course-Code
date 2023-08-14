package org.example.services;

import org.example.model.Speaker;
import org.example.repository.HibernateSpeakerRepositoryImpl;
import org.example.repository.SpeakerRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.config.BeanDefinition;
import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Service;

import java.util.List;

@Service("speakerService") //* This SpeakerServiceImpl bean is now setup as a service.
@Scope(value = BeanDefinition.SCOPE_SINGLETON)
public class SpeakerServiceImpl implements SpeakerService {
    private SpeakerRepository repository;

    public SpeakerServiceImpl(){
        System.out.println("SpeakerServiceImpl no args constructor.");
    }

//    @Autowired //* We can do constructor injection by just @Autowired here instead of the setter method. It probably looks for a bean with speakerRepository name and pass that as this method's parameter.
    public  SpeakerServiceImpl (SpeakerRepository speakerRepository){
        System.out.println("SpeakerServiceImpl repository constructor.");
        repository = speakerRepository;
    }

    @Autowired //* This will inject the speakerRepository bean into this setter automatically. It probably looks for a bean with speakerRepository name and pass that as this method's parameter. I think in do inject stuff when the speakerService bean get construct.
    public void setRepository(SpeakerRepository repository) {
        System.out.println("SpeakerServiceImpl setter.");
        this.repository = repository;
    }

    @Override
    public List<Speaker> findAll(){
        return repository.findAll();
    }
}
