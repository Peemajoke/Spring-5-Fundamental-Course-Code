package org.example.repository;

import org.example.model.Speaker;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.beans.factory.config.BeanDefinition;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Profile;
import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Repository;

import java.util.ArrayList;
import java.util.Calendar;
import java.util.List;

@Repository("speakerRepository") //* This HibernateSpeakerRepositoryImpl bean is now setup as a repository.
@Scope(value = BeanDefinition.SCOPE_SINGLETON)
@Profile("dev")
public class HibernateSpeakerRepositoryImpl implements SpeakerRepository {

    @Autowired
    private Calendar cal;
    @Autowired
    private Calendar cal2;

    @Value("#{ T(java.lang.Math).random() * 100 }")
    private double seedNum; //* This seedNum will be injected during runtime by the @Value.

    @Override
    public List<Speaker> findAll(){
        List<Speaker> speakers = new ArrayList<>();

        Speaker speaker = new Speaker();
        speaker.setFirstname("Mai");
        speaker.setLastname("Sakurajima");
        speaker.setSeedNum(seedNum); //* When the method findAll is called, the seedNum will be set to speaker and we can get the value out for debugging values that set during runtime.

        System.out.println("cal: " + cal.getTime());

//        System.out.println("cal: " + cal.hashCode());
//        System.out.println("cal2: " + cal2.hashCode());

        speakers.add(speaker);

        return speakers;
    }
}
