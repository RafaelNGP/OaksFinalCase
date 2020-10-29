package com.finalcase.oaks.OaksFinalCase.service;

import com.finalcase.oaks.OaksFinalCase.entity.Actor;
import com.finalcase.oaks.OaksFinalCase.entity.Producer;
import com.finalcase.oaks.OaksFinalCase.repository.ProducerRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.util.List;

@Component
public class ProducerService {

    @Autowired
    ProducerRepository producerRepository;

    public Producer getById(Integer id) {
        return producerRepository.findById(id).orElseThrow();
    }
    public void saveNewProducer(Producer producer) {
        producerRepository.save(producer);
    }
    public Producer getByDoc(String doc) {
        return producerRepository.findBydoc(doc);
    }
    public List<Actor> addReservedActorToProducer (Actor actor, Producer producer) {
        return producer.addReservedActor(actor);
    }
}
