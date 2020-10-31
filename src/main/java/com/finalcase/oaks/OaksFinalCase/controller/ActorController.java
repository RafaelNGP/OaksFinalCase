package com.finalcase.oaks.OaksFinalCase.controller;

import com.finalcase.oaks.OaksFinalCase.entity.Actor;
import com.finalcase.oaks.OaksFinalCase.service.ActorService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.net.URI;
import java.util.Date;
import java.util.List;
import java.util.UUID;

@RestController
@RequestMapping("/actors")
public class ActorController {

    @Autowired
    private ActorService actorService;

    @PostMapping("/save")
    public ResponseEntity<Actor> saveActor(@RequestBody Actor actor){
        actorService.saveNewActor(actor);
        return ResponseEntity.created(URI.create(UUID.randomUUID().toString())).body(actor);
    }

    @PostMapping("/saveList")
    public ResponseEntity<List<Actor>> saveMoreActors(@RequestBody List<Actor> actors){
        actorService.saveListActors(actors);
        return ResponseEntity.created(URI.create(UUID.randomUUID().toString())).body(actors);
    }

    @DeleteMapping("/removeOne/{id}")
    public ResponseEntity<String> deleteOneActor(@PathVariable(value = "id") Integer id){
        actorService.deleteOneById(id);
        return ResponseEntity.ok().body("Successfully removed actor from Database!");
    }

    @DeleteMapping("/removeAll")
    public ResponseEntity<String> deleteAllActors(){
        actorService.deleteAllActors();
        return ResponseEntity.ok().body("Successfully removed all actors from Database!");
    }

    @GetMapping("/all")
    public ResponseEntity<List<Actor>> getAllActors() {
        return ResponseEntity.accepted().body(actorService.listAllActors());
    }

    @GetMapping("/byGenre")
    public ResponseEntity<List<Actor>> getAllByGenre(@RequestParam String genre){
        return ResponseEntity.accepted().body(actorService.listAllByGenre(genre));
    }

    @GetMapping("/byPrice")
    public ResponseEntity<List<Actor>> getAllByPrice(@RequestParam double price){
        return ResponseEntity.accepted().body(actorService.listAllByPrice(price));
    }

    @GetMapping("/byRelevance")
    public ResponseEntity<List<Actor>> findAllByRelevance(@RequestParam int relevance){
        return ResponseEntity.accepted().body(actorService.listAllByRelevance(relevance));
    }

    @GetMapping("/byPriceRelevance")
    public ResponseEntity<List<Actor>> findAllByPriceAndRelevance(@RequestParam(value = "price") double price,
                                                                  @RequestParam(value = "relevance") int relevance){
        return ResponseEntity.accepted().body(actorService.listAllByPriceAndRelevance(price, relevance));
    }

    @GetMapping("/byName")
    public ResponseEntity<List<Actor>> findAllByName(@RequestParam String name){
        return ResponseEntity.accepted().body(actorService.ListAllByName(name));
    }

    //TODO: Corrigir o date
    @GetMapping("/byDate")
    public List<Actor> findAllByAvailableDays(@RequestParam Date availableDays){
        return actorService.listByAvailableDays(availableDays);
    }

    @GetMapping("/{id}")
    public ResponseEntity<Actor> GetActorByID(@PathVariable (value="id")Integer id){
        return ResponseEntity.accepted().body(actorService.getById(id));
    }

    @GetMapping("/byBudgetAndQuantity")
    public ResponseEntity<List<Actor>> getAllByPrice(@RequestParam double budget, @RequestParam int quantityOfActors){
        return ResponseEntity.accepted().body(actorService.listAllByBudgetAndQuantityOfActors(budget, quantityOfActors));
    }
}
