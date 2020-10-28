package com.finalcase.oaks.OaksFinalCase.service;

import com.finalcase.oaks.OaksFinalCase.entity.Actor;
import com.finalcase.oaks.OaksFinalCase.repository.ActorRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

@Component
public class ActorService {

    @Autowired
    private ActorRepository actorRepository;

    public Actor getActor(){
        return actorRepository.getOne();
    }

    public void saveActor(Actor actor){
        actorRepository.save(actor);
    }
}
