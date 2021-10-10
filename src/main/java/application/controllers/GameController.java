package application.controllers;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
public class GameController {

    @GetMapping("/game")
    public String getGamePage() {
        return "game";
    }

    @GetMapping(value = { "/play"})
    public String getGameNumber(Model model) {
        int userNumber = (int) (Math.random() * 6 + 1);
        int computerNumber = (int) (Math.random() * 6 + 1);

        String userText = "A te számod: " + userNumber;
        String computerText = "A számítógép száma: " + computerNumber;

        String winner = (userNumber > computerNumber ? "Te nyertél!" :
                (userNumber == computerNumber ? "Döntetlen!" : "A számítógép nyert!"));

        model.addAttribute("userText", userText);
        model.addAttribute("computerText", computerText);
        model.addAttribute("winner", winner);
        return "game";
    }

}
