package com.finalcase.oaks.OaksFinalCase.repository;

import com.finalcase.oaks.OaksFinalCase.entity.Actor;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface ActorRepository extends JpaRepository<Actor, Integer> {

    List<Actor> findAllByGenre(String genre);
}