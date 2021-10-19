package application.services;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class GameServiceTest {

    @Test
    void sayHello() {
        GameService service = new GameService();
        String result = service.sayHello("Tamás");

        assertEquals("Hello, dear Tamás!", result);
    }

}