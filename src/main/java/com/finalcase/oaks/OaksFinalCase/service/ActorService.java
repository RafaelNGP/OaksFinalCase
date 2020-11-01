package com.finalcase.oaks.OaksFinalCase.service;

import com.finalcase.oaks.OaksFinalCase.entity.Actor;
import com.finalcase.oaks.OaksFinalCase.repository.ActorRepository;
import com.finalcase.oaks.OaksFinalCase.util.DateUtil;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.text.ParseException;
import java.util.Date;
import java.util.List;
import java.util.Optional;

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
    public void deleteOneById(Integer id){
        actorRepository.deleteById(id);
    }
    public void deleteAllActors(){
        actorRepository.deleteAll();
    }
    public void addAvailableDays(Integer id, Date date) throws ParseException {
        Actor actor = actorRepository.findById(id).get();
        actor.addAvailableDay(date);
        actorRepository.save(actor);
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
       return actorRepository.findByPriceLessThanEqualAndRelevanceGreaterThanEqual(price, relevance);
    }
    public List<Actor> ListAllByName(String name){
        return actorRepository.findAllByName(name);
    }
    public List<Actor> listByAvailableDays(Date date){
        return actorRepository.findByAvailableDaysIs(date);
    }
    public List<Actor> listByAvailableDaysBetween(Date date1, Date date2){
        return actorRepository.findByAvailableDaysBetween(date1, date2);
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
