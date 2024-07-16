package at.grafolution.drinkolution.controller;

import at.grafolution.drinkolution.model.Player;
import at.grafolution.drinkolution.service.PlayerService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/api/players")
public class PlayerController {



    @Autowired
    PlayerService playerService;

    public PlayerController() {}

    @PostMapping
    public ResponseEntity<Player> addPlayer(@RequestBody Player player) {
        Player createdPlayer = playerService.addPlayer(player);
        return ResponseEntity.ok(createdPlayer);
    }

    @GetMapping("/session/{sessionId}")
    public ResponseEntity<List<Player>> getPlayersForSession(@PathVariable String sessionId) {
        List<Player> players = playerService.getPlayersForSession(sessionId);
        return ResponseEntity.ok(players);
    }

    @GetMapping("/{playerId}")
    public ResponseEntity<Player> getPlayerById(@PathVariable Long playerId) {
        Optional<Player> player = playerService.getPlayerById(playerId);
        return player.map(ResponseEntity::ok).orElseGet(() -> ResponseEntity.notFound().build());
    }

    @DeleteMapping("/{playerId}")
    public ResponseEntity<Void> deletePlayer(@PathVariable Long playerId) {
        playerService.deletePlayer(playerId);
        return ResponseEntity.noContent().build();
    }

    @DeleteMapping("/session/{sessionId}")
    public ResponseEntity<Void> deletePlayersForSession(@PathVariable String sessionId) {
        playerService.deletePlayersForSession(sessionId);
        return ResponseEntity.noContent().build();
    }
}
