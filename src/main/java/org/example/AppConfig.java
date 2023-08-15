package org.example;

import org.example.repository.HibernateSpeakerRepositoryImpl;
import org.example.repository.SpeakerRepository;
import org.example.services.SpeakerService;
import org.example.services.SpeakerServiceImpl;
import org.example.util.CalendarFactory;
import org.springframework.beans.factory.config.BeanDefinition;
import org.springframework.context.annotation.*;

import java.util.Calendar;

@Configuration
@ComponentScan({"org.example"}) //* To denote where to look for the bean to auto wire.
public class AppConfig {
    //* When this bean is wired, it uses the CalendarFactory to create an instance of Calendar, which is also a bean, and wire that instance.
    @Bean(name = "cal")
    public CalendarFactory calFactory(){
        CalendarFactory factory = new CalendarFactory();
        factory.addDays(2);
        return factory;
    }

    @Bean
    public Calendar cal() throws Exception{
        return calFactory().getObject();
    }
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
