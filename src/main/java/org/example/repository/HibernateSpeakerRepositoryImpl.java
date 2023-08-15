package org.example.repository;

import org.example.model.Speaker;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.config.BeanDefinition;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Repository;

import java.util.ArrayList;
import java.util.Calendar;
import java.util.List;

@Repository("speakerRepository") //* This HibernateSpeakerRepositoryImpl bean is now setup as a repository.
@Scope(value = BeanDefinition.SCOPE_SINGLETON)
public class HibernateSpeakerRepositoryImpl implements SpeakerRepository {

    @Autowired //* Wire Bean named cal. The bean is defined in AppConfig.java which is the calFactory() method.
    private Calendar cal;
    @Autowired
    private Calendar cal2;
    @Override
    public List<Speaker> findAll(){
        List<Speaker> speakers = new ArrayList<>();

        Speaker speaker = new Speaker();
        speaker.setFirstname("Mai");
        speaker.setLastname("Sakurajima");

        //* We can see that the printed date is modified. Therefore, the autowired wire the bean that have been instantiate from the factory bean.
        System.out.println("cal: " + cal.getTime());

        //* These 2 have the same hashCode(), which means that cal and cal2 reference the same object. That is because the instance of Calandar is static.
        System.out.println("cal: " + cal.hashCode());
        System.out.println("cal2: " + cal2.hashCode());

        speakers.add(speaker);

        return speakers;
    }
}
