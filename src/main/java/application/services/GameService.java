package application.services;

import org.springframework.stereotype.Service;

@Service
public class GameService {

    /*
    int userNumber = (int) (Math.random() * 6 + 1);
        int computerNumber = (int) (Math.random() * 6 + 1);

        String userText = "A te számod: " + userNumber;
        String computerText = "A számítógép száma: " + computerNumber;

        String winner = (userNumber > computerNumber ? "Te nyertél!" :
                (userNumber == computerNumber ? "Döntetlen!" : "A számítógép nyert!"));
     */

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
