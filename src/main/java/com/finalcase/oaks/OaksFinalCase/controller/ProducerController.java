package com.finalcase.oaks.OaksFinalCase.controller;

import com.finalcase.oaks.OaksFinalCase.entity.Actor;
import com.finalcase.oaks.OaksFinalCase.entity.Producer;
import com.finalcase.oaks.OaksFinalCase.service.ProducerService;
import org.hibernate.annotations.Parameter;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/producer")
public class ProducerController {

    @Autowired
    private ProducerService producerService;

    @PostMapping("/save")
    public ResponseEntity<Producer> saveProducer(@RequestBody Producer producer){
        producerService.saveNewProducer(producer);
        return ResponseEntity.ok(producer);
    }

    //TODO arrumar
    @PostMapping("/addActor")
    public void addReservedActor(@RequestParam("idActor") Integer idActor,
                                 @RequestParam("idProducer") Integer idProducer) {
        producerService.addReservedActorToProducer(idActor, idProducer);
    }

    @GetMapping("/{id}")
    public ResponseEntity<Producer> GetProducerById(@PathVariable (value = "id") Integer id){
        return ResponseEntity.accepted().body(producerService.getById(id));
    }




}
