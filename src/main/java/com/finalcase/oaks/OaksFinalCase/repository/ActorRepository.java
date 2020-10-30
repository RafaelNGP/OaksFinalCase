package com.finalcase.oaks.OaksFinalCase.repository;

import com.finalcase.oaks.OaksFinalCase.entity.Actor;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.Date;
import java.util.List;

public interface ActorRepository extends JpaRepository<Actor, Integer> {

    List<Actor> findAllByGenre(String genre);
    List<Actor> findAllByAvailableDaysAfter(Date date);
    List<Actor> findAllByAvailableDaysBetween(Date dateStart, Date dateEnd);
    List<Actor> findAllByRelevanceGreaterThanEqual(int relevance);
    List<Actor> findByPriceLessThan(double price);
}
