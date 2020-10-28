package com.finalcase.oaks.OaksFinalCase.service;

import com.finalcase.oaks.OaksFinalCase.entity.Actor;
import com.finalcase.oaks.OaksFinalCase.repository.ActorRepository;
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

    public Actor saveNewActor(String name, String doc, String email, String password, Double price, int relevance, String genre) {
        Actor actor = new Actor(name, doc, email, password, price, relevance, genre);
        return repository.save(actor);
    }

}
