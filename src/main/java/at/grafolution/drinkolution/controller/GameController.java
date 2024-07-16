package at.grafolution.drinkolution.controller;



import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/api/games")
public class GameController {

//
//
//    @PostMapping
//    public ResponseEntity<Game> addGame(@RequestBody Game game) {
//        Game createdGame = addGameUseCase.execute(game);
//        return ResponseEntity.ok(createdGame);
//    }
//
//    @GetMapping
//    public ResponseEntity<List<Game>> getAllGames() {
//        List<Game> games = getAllGamesUseCase.execute();
//        return ResponseEntity.ok(games);
//    }
//
//    @GetMapping("/{id}")
//    public ResponseEntity<Game> getGameById(@PathVariable Long id) {
//        Optional<Game> game = getGameByIdUseCase.execute(id);
//        return game.map(ResponseEntity::ok).orElseGet(() -> ResponseEntity.notFound().build());
//    }
//
//    @DeleteMapping("/{id}")
//    public ResponseEntity<Void> deleteGame(@PathVariable Long id) {
//        deleteGameUseCase.execute(id);
//        return ResponseEntity.noContent().build();
//    }
}
