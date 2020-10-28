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

    public Producer saveNewProducer(String name, String doc, String email, String password) {
        Producer producer = new Producer(name, doc, email, password);
        return repository.save(producer);
    }

    public Producer getByDoc(String doc) {
        return repository.findBydoc(doc);
    }

    public List<Actor> addReservedActorToProducer (Actor actor, Producer producer) {
        return producer.addReservedActor(actor);
    }
}
