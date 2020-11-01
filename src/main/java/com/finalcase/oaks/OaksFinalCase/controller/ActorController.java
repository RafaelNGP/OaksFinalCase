package com.finalcase.oaks.OaksFinalCase.controller;

import com.finalcase.oaks.OaksFinalCase.entity.Actor;
import com.finalcase.oaks.OaksFinalCase.service.ActorService;
import com.finalcase.oaks.OaksFinalCase.util.DateUtil;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.net.URI;
import java.text.ParseException;
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

    @GetMapping("/byDate")
    public List<Actor> findByAvailableDays(@RequestParam("date") String availableDays) throws ParseException {
        return actorService.listByAvailableDays(DateUtil.parseStringToDate(availableDays));
    }

    @GetMapping("byDates")
    public List<Actor> findByDatesBetween(@RequestParam("date1") String date1,
                                          @RequestParam("date2") String date2) throws ParseException {
    var data1 = DateUtil.parseStringToDate(date1);
    var data2 = DateUtil.parseStringToDate(date2);
    return actorService.listByAvailableDaysBetween(data1, data2);
    }

    @GetMapping("/{id}")
    public ResponseEntity<Actor> GetActorByID(@PathVariable (value="id")Integer id){
        return ResponseEntity.accepted().body(actorService.getById(id));
    }

    @GetMapping("/byBudgetAndQuantity")
    public ResponseEntity<List<Actor>> getAllByPrice(@RequestParam double budget, @RequestParam int quantityOfActors){
        return ResponseEntity.accepted().body(actorService.listAllByBudgetAndQuantityOfActors(budget, quantityOfActors));
    }

    @PatchMapping("/{id}/addAvailable")
    public ResponseEntity<Actor> addAvailDays(@PathVariable("id") Integer id,
                                                 @RequestParam("availed") String date) throws ParseException {
        var parseDate = DateUtil.parseStringToDate(date);
        actorService.addAvailableDay(id, parseDate);
        actorService.removeContractedDay(id, parseDate);
        return ResponseEntity.ok().body(actorService.getById(id));
    }

    @PatchMapping("/{id}/addContracted")
    public ResponseEntity<Actor> addContDays(@PathVariable("id") Integer id,
                                              @RequestParam("contracted") String date) throws ParseException {
        var parseDate = DateUtil.parseStringToDate(date);
        actorService.addContractedDay(id, parseDate);
        actorService.removeAvailableDay(id, parseDate);
        return ResponseEntity.ok().body(actorService.getById(id));
    }
}
