package rest.controllers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;
import rest.models.Player;
import rest.services.PlayerService;

import javax.validation.Valid;

@RestController
@CrossOrigin(origins = "http://localhost:4200")
public class PlayerController {

    @Autowired
    private final PlayerService service;

    public PlayerController(PlayerService playerService) {
        service = playerService;
    }

    @PostMapping(value = "/player")
    public void addPlayer(@Valid @RequestBody Player player) {
        service.savePlayer(player);
    }
}
