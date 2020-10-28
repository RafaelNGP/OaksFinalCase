package com.finalcase.oaks.OaksFinalCase.repository;

import com.finalcase.oaks.OaksFinalCase.entity.Producer;
import org.springframework.data.jpa.repository.JpaRepository;

public interface ProducerRepository extends JpaRepository<Producer, Integer> {

    //TODO: resolver
//    Producer findBydoc(String doc);
}
