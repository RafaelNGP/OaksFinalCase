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
    ProducerRepository repository;

    public Producer getById(Integer id) {
        return repository.findById(id).orElseThrow();
    }

    public Producer saveNewProducer(String name, String doc) {
        Producer producer = new Producer(name, doc);
        return repository.save(producer);
    }

    //TODO: resolver
//    public Producer getByDoc(String doc) {
//        return repository.findByDoc(doc);
//    }

    public List<Actor> addReservedActorToProducer (Actor actor, Producer producer) {
        return producer.addReservedActor(actor);
    }
}
