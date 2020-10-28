package com.finalcase.oaks.OaksFinalCase.service;

import com.finalcase.oaks.OaksFinalCase.entity.Actor;
import com.finalcase.oaks.OaksFinalCase.entity.Producer;
import com.finalcase.oaks.OaksFinalCase.repository.ActorRepository;
import com.finalcase.oaks.OaksFinalCase.repository.ProducerRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

@Component
public class ActorService {

    @Autowired
    private ActorRepository actorRepository;
    ActorRepository repository;

    public Actor getById(Integer id) {
        return repository.findById(id).orElseThrow();
    }

    public Actor saveNewActor(String name, String doc) {
        Actor actor = new Actor(name, doc);
        return repository.save(actor);
    }

}
