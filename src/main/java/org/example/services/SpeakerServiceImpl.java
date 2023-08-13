package org.example.services;

import org.example.model.Speaker;
import org.example.repository.HibernateSpeakerRepositoryImpl;
import org.example.repository.SpeakerRepository;

import java.util.List;

public class SpeakerServiceImpl implements SpeakerService {

    //! Pain point 2: Hard Code Referencing HibernateSpeakerRepositoryImpl.
    //! Right now, HibernateSpeakerRepositoryImpl is a stub as DB is not yet establish. If DB is ready, we need to change line 14 to new the real repository that connects to the DB and RE-BUILD.
    //* Spring can just let us change configuration w/o re-build anything. By changing configuration, spring change reference to the new class.
    private SpeakerRepository repository = new HibernateSpeakerRepositoryImpl();
    @Override
    public List<Speaker> findAll(){
        return repository.findAll();
    }
}
