package application.controllers;

import application.services.GameService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
public class GameController {

    private GameService service;

    @Autowired
    public GameController(GameService service) {
        this.service = service;
    }


    @GetMapping("/game")
    public String getGamePage() {
        return "game";
    }


    @GetMapping(value = { "/play"})
    public String getGameNumber(Model model) {
        int userNumber = service.random(1, 6);
        int programNumber = service.random(1, 6);

        String userText = service.getTextWithNumber(true, userNumber);
        String programText = service.getTextWithNumber(false, programNumber);

        String winner = service.getWinnerMsg(userNumber, programNumber);

        model.addAttribute("userText", userText);
        model.addAttribute("programText", programText);
        model.addAttribute("winner", winner);
        return "game";
    }

}
