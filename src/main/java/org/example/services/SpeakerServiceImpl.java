package org.example.services;

import org.example.model.Speaker;
import org.example.repository.HibernateSpeakerRepositoryImpl;
import org.example.repository.SpeakerRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.config.BeanDefinition;
import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Service;

import javax.annotation.PostConstruct;
import java.util.List;

@Service("speakerService")
@Scope(value = BeanDefinition.SCOPE_SINGLETON)
public class SpeakerServiceImpl implements SpeakerService {
    private SpeakerRepository repository;

    public SpeakerServiceImpl(){
        System.out.println("SpeakerServiceImpl no args constructor.");
    }

//    @Autowired
    public  SpeakerServiceImpl (SpeakerRepository speakerRepository){
        System.out.println("SpeakerServiceImpl repository constructor.");
        repository = speakerRepository;
    }

    @Autowired
    public void setRepository(SpeakerRepository repository) {
        System.out.println("SpeakerServiceImpl setter.");
        this.repository = repository;
    }

    @PostConstruct //* This annotated to run this method after any constructor of this class is run successfully.
    //! Code in here should only be about config things after the bean is created. Don't open or close connection here.
    private void initialize(){
        System.out.println("Called after the constructor.");
    }

    @Override
    public List<Speaker> findAll(){
        return repository.findAll();
    }
}
