package com.finalcase.oaks.OaksFinalCase.controller;

import com.finalcase.oaks.OaksFinalCase.entity.Producer;
import com.finalcase.oaks.OaksFinalCase.service.ProducerService;
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

    @PatchMapping("/addActor")
    public ResponseEntity<Producer> addReservedActor(@RequestParam("idActor") Integer idActor,
                                     @RequestParam("idProducer") Integer idProducer) {

        producerService.addReservedActorToProducer(idActor, idProducer);
        return ResponseEntity.ok().body(producerService.getById(idProducer));
    }

    @PatchMapping("/removeActor")
    public ResponseEntity<Producer> removeReservedActor(@RequestParam("idActor") Integer idActor,
                                                     @RequestParam("idProducer") Integer idProducer) {

        producerService.removeReservedActorToProducer(idActor, idProducer);
        return ResponseEntity.ok().body(producerService.getById(idProducer));
    }

    @GetMapping("/{id}")
    public ResponseEntity<Producer> getProducerById(@PathVariable (value = "id") Integer id){
        return ResponseEntity.accepted().body(producerService.getById(id));
    }

    @DeleteMapping("/delete/{id}")
    public ResponseEntity<String> deleteProducer(@PathVariable (value = "id") Integer id) {
        producerService.deleteProducer(id);
        return ResponseEntity.ok().body("Producer deleted.");
    }

}
