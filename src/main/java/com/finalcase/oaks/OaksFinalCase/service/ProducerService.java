package com.finalcase.oaks.OaksFinalCase.service;

import com.finalcase.oaks.OaksFinalCase.entity.Actor;
import com.finalcase.oaks.OaksFinalCase.entity.Producer;
import com.finalcase.oaks.OaksFinalCase.entity.Profile;
import com.finalcase.oaks.OaksFinalCase.repository.ActorRepository;
import com.finalcase.oaks.OaksFinalCase.repository.ProducerRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

@Component
public class ProducerService {

    @Autowired
    ProducerRepository producerRepository;

    @Autowired
    ActorRepository actorRepository;

    public Producer getById(Integer id) {
        return producerRepository.findById(id).orElseThrow();
    }

    public void saveNewProducer(Producer producer) {
        producerRepository.save(producer);
    }

    public void addReservedActorToProducer(Integer idActor, Integer idProducer) {
        Producer producer = producerRepository.findById(idProducer).get();
        Actor actor = actorRepository.findById(idActor).get();

        producer.addReservedActor(actor);
    }

    public void removeReservedActorToProducer(Integer idActor, Integer idProducer) {
        Producer producer = producerRepository.findById(idProducer).get();
        Actor actor = actorRepository.findById(idActor).get();

        producer.removeReservedActor(actor);
    }

    public void deleteProducer(Integer id) {
        Producer producer = producerRepository.findById(id).get();
        producerRepository.delete(producer);
    }

}
