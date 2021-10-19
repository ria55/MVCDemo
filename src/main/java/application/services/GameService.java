package application.services;

import org.springframework.stereotype.Service;

@Service
public class GameService {

    public String sayHello(String name) {
        return "Hello, dear " + name + "!";
    }

    public String getTextWithNumber(boolean isForUser, int number) {
        if (isForUser) {
            return "A te számod: " + number;
        }
        return "A program száma: " + number;
    }

    public String getWinnerMsg(int userNum, int progNum) {
        if (userNum > progNum) {
            return "Te nyertél!";
        } else if (userNum < progNum) {
            return "A program nyert!";
        }
        return "Döntetlen!";
    }

    public int random(int min, int max) {
        return (int) (Math.random() * max + min);
    }

}
