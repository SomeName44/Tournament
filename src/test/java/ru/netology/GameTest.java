package ru.netology;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

public class GameTest {
    Game game = new Game();
    Player player1 = new Player(5879, "Max", 1);
    Player player2 = new Player(3000, "Smart", 2);
    Player player3 = new Player(274, "Smash", 22);
    Player player4 = new Player(15, "Driver", 5);
    Player player5 = new Player(01, "Smoky Gay", 0);
    Player player6 = new Player(9999, "Smart", 9);
    Player player7 = new Player(673, "Next", 1);

    @BeforeEach
    public void addPlayers() throws NotRegisteredException {
        game.registration(player1);
        game.registration(player2);
        game.registration(player3);
        game.registration(player4);
        game.registration(player5);
        game.registration(player7);
    }
    @Test
    public void comparePlayersWhenFirstIsWeakerThanSecond() throws NotRegisteredException {

        int expected = 2;
        int actual = game.round("Smart", "Smash");
        Assertions.assertEquals(expected, actual);
    }

    @Test
    public void comparePlayersWhenFirstIsStrongerThanSecond() throws NotRegisteredException {

        int expected = 1;
        int actual = game.round("Smart", "Max");
        Assertions.assertEquals(expected, actual);
    }

    @Test
    public void comparePlayersOfEqualStrength() throws NotRegisteredException {

        int expected = 0;
        int actual = game.round("Next", "Max");
        Assertions.assertEquals(expected, actual);
    }

    @Test
    public void compareStrengthsPlayersIfBothAreUnregistered() {
        Assertions.assertThrows(NotRegisteredException.class, () -> {
            game.round("", "");
        });
    }

    @Test
    public void compareStrengthPlayersIfFirstIsUnregistered() {
        Assertions.assertThrows(NotRegisteredException.class, () -> {
            game.round("John", "Smoky Gay");
        });
    }
    @Test
    public void compareStrengthPlayersIfSecondIsUnregistered() {
        Assertions.assertThrows(NotRegisteredException.class, () -> {
            game.round("Max", "Brandon");
        });
    }
    @Test
    public void compareStrengthsPlayersNamesNotIncluded() {
        Assertions.assertThrows(NotRegisteredException.class, () -> {
            game.round("John", "Brandon");
        });
    }
    @Test
    public void addPlayerWhoseNameAlreadyUse() {
        Assertions.assertThrows(NotRegisteredException.class, () -> {
            game.registration(player6);
        });
    }
}
