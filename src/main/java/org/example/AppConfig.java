package org.example;

import org.example.repository.HibernateSpeakerRepositoryImpl;
import org.example.repository.SpeakerRepository;
import org.example.services.SpeakerService;
import org.example.services.SpeakerServiceImpl;
import org.springframework.beans.factory.config.BeanDefinition;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Scope;

@Configuration
public class AppConfig {
    @Bean(name = "speakerService")
    @Scope(value = BeanDefinition.SCOPE_SINGLETON) // Define singleton scope to this Bean.
    public SpeakerService getSpeakerService(){
//        SpeakerServiceImpl speakerService = new SpeakerServiceImpl(getSpeakerRepository());

        //* We change to just call constructure with no args
        SpeakerServiceImpl speakerService = new SpeakerServiceImpl();
        return speakerService;
    }

    @Bean (name = "speakerRepository")
    public SpeakerRepository getSpeakerRepository(){
        return new HibernateSpeakerRepositoryImpl();
    }
}
