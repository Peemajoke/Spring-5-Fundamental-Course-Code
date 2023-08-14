package org.example;

import org.example.repository.HibernateSpeakerRepositoryImpl;
import org.example.repository.SpeakerRepository;
import org.example.services.SpeakerService;
import org.example.services.SpeakerServiceImpl;
import org.springframework.beans.factory.config.BeanDefinition;
import org.springframework.context.annotation.*;

@Configuration
@ComponentScan({"org.example"}) //* To denote where to look for the bean to auto wire.
public class AppConfig {
    //* Auto-wiring wired dependencies for us by just adding annotations (annotation that specified that this class is bean (@Service, @Repository), annotation to use which function for auto-wiring (@Autowired), and @ComponentScan to tell spring where to look for beans and to do auto-wire). We don't even have to specified behavior of wiring like what we commented in this class.
    /*
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
     */
}
