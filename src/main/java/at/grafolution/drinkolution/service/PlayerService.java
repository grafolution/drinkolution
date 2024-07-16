package at.grafolution.drinkolution.service;


import at.grafolution.drinkolution.model.Player;
import at.grafolution.drinkolution.repository.PlayerRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class PlayerService {

    @Autowired
    private PlayerRepository playerRepository;



    public Player addPlayer(Player player) {
        return playerRepository.save(player);
    }

    public List<Player> getPlayersForSession(String sessionId) {
        return playerRepository.findBySessionId(sessionId);
    }

    public Optional<Player> getPlayerById(Long playerId) {
        return playerRepository.findById(playerId);
    }


    public void deletePlayer(Long playerId) {
        playerRepository.deleteById(playerId);
    }


    public void deletePlayersForSession(String sessionId) {
        List<Player> players = playerRepository.findBySessionId(sessionId);
        playerRepository.deleteAll(players);
    }
}
