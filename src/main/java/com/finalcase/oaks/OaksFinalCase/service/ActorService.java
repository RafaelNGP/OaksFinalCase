package com.finalcase.oaks.OaksFinalCase.service;

import com.finalcase.oaks.OaksFinalCase.entity.Actor;
import com.finalcase.oaks.OaksFinalCase.repository.ActorRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.util.List;

@Component
public class ActorService {

    @Autowired
    private ActorRepository actorRepository;

    public void saveNewActor(Actor actor) {
        actorRepository.save(actor);
    }
    public List<Actor> listAllActors(){
        return actorRepository.findAll();
    }
    public List<Actor> listAllByGenre(String genre){
        return actorRepository.findAllByGenre(genre);
    }

    public List<Actor> listAllByPrice(double price){
        return actorRepository.findByPriceLessThan(price);
    }

    public Actor getById(Integer id) {
        return actorRepository.findById(id).orElseThrow();
    }
}
