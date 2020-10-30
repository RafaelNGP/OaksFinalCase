package com.finalcase.oaks.OaksFinalCase.service;

import com.finalcase.oaks.OaksFinalCase.entity.Actor;
import com.finalcase.oaks.OaksFinalCase.repository.ActorRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.util.Date;
import java.util.List;

@Component
public class ActorService {

    @Autowired
    private ActorRepository actorRepository;

    public void saveNewActor(Actor actor) {
        actorRepository.save(actor);
    }

    public void saveListActors(List<Actor> actors){
        actorRepository.saveAll(actors);
    }
    public List<Actor> listAllActors(){
        return actorRepository.findAll();
    }
    public List<Actor> listAllByGenre(String genre){
        return actorRepository.findAllByGenre(genre);
    }
    public List<Actor> listAllByPrice(double price){
        return actorRepository.findAllByPriceLessThanEqual(price);
    }
    public List<Actor> listAllByRelevance(int relevance){
        return actorRepository.findAllByRelevanceGreaterThanEqual(relevance);
    }
    public List<Actor> listAllByPriceAndRelevance(double price, int relevance){
       return actorRepository.findAllByPriceLessThanEqualAndRelevanceGreaterThanEqual(price, relevance);
    }

    //TODO: arrumar a lista de datas
    public List<Actor> listByAvailableDays(Date date){
        return actorRepository.findAllByAvailableDaysAfter(date);
    }

    public Actor getById(Integer id) {
        return actorRepository.findById(id).orElseThrow();
    }

    //Filtro por quantidade de atores e orçamento

    public List<Actor> listAllByBudgetAndQuantityOfActors(double buget, int quantityOfActors) {
        double maximumPrice = buget/quantityOfActors;
        return listAllByPrice(maximumPrice);
    }
}
