package com.finalcase.oaks.OaksFinalCase.repository;

import com.finalcase.oaks.OaksFinalCase.entity.Actor;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.Date;
import java.util.List;

public interface ActorRepository extends JpaRepository<Actor, Integer> {

    List<Actor> findAllByGenre(String genre);
    List<Actor> findByAvailableDaysAfter(Date date);
    List<Actor> findByAvailableDaysBetween(Date dateStart, Date dateEnd);
    List<Actor> findAllByRelevanceGreaterThanEqual(int relevance);
    List<Actor> findAllByPriceLessThanEqual(double price);
    List<Actor> findByPriceLessThanEqualAndRelevanceGreaterThanEqual(double price, int relevance);
    List<Actor> findAllByName(String name);
}
