package com.finalcase.oaks.OaksFinalCase.service;

import com.finalcase.oaks.OaksFinalCase.entity.Producer;
import com.finalcase.oaks.OaksFinalCase.repository.ProducerRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

@Component
public class ProducerService {

    @Autowired
    ProducerRepository repository;

    public Producer getById(Integer id) {
        return repository.findById(id).orElseThrow();
    }
}
