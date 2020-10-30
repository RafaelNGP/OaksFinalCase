package com.finalcase.oaks.OaksFinalCase.service;

import com.finalcase.oaks.OaksFinalCase.entity.Actor;
import com.finalcase.oaks.OaksFinalCase.repository.ActorRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import javax.xml.crypto.Data;
import java.util.Date;
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

    //TODO: arrumar a lista de datas
    public List<Actor> listByAvailableDays(Date date){
        return actorRepository.findAllByAvailableDaysAfter(date);
    }

    public List<Actor> listByRelevance(int relevance){
        return actorRepository.findAllByRelevanceGreaterThanEqual(relevance);
    }

    public Actor getById(Integer id) {
        return actorRepository.findById(id).orElseThrow();
    }
}
