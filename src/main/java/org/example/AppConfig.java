package org.example;

import org.example.repository.HibernateSpeakerRepositoryImpl;
import org.example.repository.SpeakerRepository;
import org.example.services.SpeakerService;
import org.example.services.SpeakerServiceImpl;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

//* This is use for config our app instead of ApplicationCOntext.xml. This class is POJO.
@Configuration // Uses to tells Spring that this class is a config.
public class AppConfig {
    @Bean(name = "speakerService") // This gives Bean a name. Usually uses camelCase. It will be an important factor in AutoWiring
    public SpeakerService getSpeakerService(){
        SpeakerServiceImpl speakerService = new SpeakerServiceImpl(getSpeakerRepository());

        // We use getSpeakerRepository() instead of new getSpeakerRepository() create it as a Bean and to get the full benefit of ez Singleton setup.
//        speakerService.setRepository(getSpeakerRepository()); //* This solved pain point 2 as we change our repository to be injected through setter injection rather than hardcode new instance.
        return speakerService;
    }

    @Bean (name = "speakerRepository")
    public SpeakerRepository getSpeakerRepository(){
        return new HibernateSpeakerRepositoryImpl();
    }
}
