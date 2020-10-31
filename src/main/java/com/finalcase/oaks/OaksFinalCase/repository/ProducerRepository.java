package com.finalcase.oaks.OaksFinalCase.repository;

import com.finalcase.oaks.OaksFinalCase.entity.Actor;
import com.finalcase.oaks.OaksFinalCase.entity.Producer;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import java.util.List;

public interface ProducerRepository extends JpaRepository<Producer, Integer> {

    Producer findByDoc(String doc);

    @Modifying
    @Query("UPDATE Producer c SET c.reservedActors = :actors WHERE c.id = :id")
    void addReservedActors(@Param("actor") List<Actor> actor, @Param("id") Integer id);
}
