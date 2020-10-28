package com.finalcase.oaks.OaksFinalCase.repository;

import com.finalcase.oaks.OaksFinalCase.entity.Actor;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.Date;
import java.util.List;

public interface ActorRepository extends JpaRepository<Actor, Integer> {

    List<Actor> findAllByGenre(String genre);
    //TODO: solucionar aqui os Date para Actor
//    List<Actor> findByStartDateAfter(Date date);
//    List<Actor> findByStartDateBetween(Date date1, Date date2);
    List<Actor> findByPriceLessThan(double price);
}
