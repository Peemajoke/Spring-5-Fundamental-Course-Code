package org.example.repository;

import org.example.model.Speaker;

import java.util.ArrayList;
import java.util.List;

//* Having Impl in the class name to indicate that this class implement interface. The benefits is that We can swap the implementation class for testing purposes by make a stub, then extract interface of the stub making this class will remain the same.
public class HibernateSpeakerRepositoryImpl implements SpeakerRepository {
    @Override
    public List<Speaker> findAll(){
        List<Speaker> speakers = new ArrayList<>();

        Speaker speaker = new Speaker();
        speaker.setFirstname("Mai");
        speaker.setLastname("Sakurajima");

        speakers.add(speaker);

        return speakers;
    }
}
