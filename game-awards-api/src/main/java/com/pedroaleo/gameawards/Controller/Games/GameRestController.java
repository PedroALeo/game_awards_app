package com.pedroaleo.gameawards.Controller.Games;

import com.pedroaleo.gameawards.Controller.BaseRestController;
import com.pedroaleo.gameawards.domain.model.Game;
import com.pedroaleo.gameawards.service.GameService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
public class GameRestController extends BaseRestController {

    @Autowired
    private GameService businessLayer;

    @GetMapping("games")
    public ResponseEntity<List<Game>> findAll(){
        List<Game> games = businessLayer.findAll();
        return ResponseEntity.ok(games);
    }

    @GetMapping("games/{id}")
    public ResponseEntity<Game> findById(@PathVariable Long id){
        return ResponseEntity.ok(businessLayer.findById(id));
    }

    @PostMapping("games")
    public ResponseEntity<Game> insert(@RequestBody Game game){
        businessLayer.insert(game);
        return ResponseEntity.ok(game);
    }

    @PutMapping("games/{id}")
    public ResponseEntity<Game> update(@PathVariable Long id, @RequestBody Game game){
        businessLayer.update(id, game);
        return ResponseEntity.ok(game);
    }

    @PatchMapping("games/{id}/vote")
    public ResponseEntity<Game> update(@PathVariable Long id){
        businessLayer.vote(id);
        return ResponseEntity.ok().build();
    }

    @DeleteMapping("games/{id}")
    public ResponseEntity<Game> delete(@ PathVariable Long id){
        businessLayer.delete(id);
        return ResponseEntity.ok().build();
    }
}
