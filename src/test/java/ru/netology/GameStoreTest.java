package ru.netology;

import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

public class GameStoreTest {
    GameStore store = new GameStore();
    @Test
    public void shouldAddGame() {


        Game game = store.publishGame("Нетология Баттл Онлайн", "Аркады");

        assertTrue(store.containsGame(game));
    }
    // другие ваши тесты
    @Test
    public void addTwoSimilarGames() {
        Game game1 = store.publishGame("Нетология Баттл Онлайн 1", "Симулятор");
        Game game2 = store.publishGame("GTA V", "Экшен");
        Game game3 = store.publishGame("GTA V", "Экшен");
        Game game4 = store.publishGame("Нетология Баттл Онлайн 4", "Аркады");

        Assertions.assertTrue(store.containsGame(game2));
        Assertions.assertFalse(store.containsGame(game3));
    }
    @Test
    public void addPlayTimeTest() {
        store.addPlayTime("gamer1", 1);
        store.addPlayTime("gamer1", 7 );

        int expected = 8;
        int actual = store.getSumPlayedTime();

        Assertions.assertEquals(expected, actual);
    }
    @Test
    public void getMostPlayerTest() {

        store.addPlayTime("gamer1", 7);
        store.addPlayTime("gamer2", 6);
        store.addPlayTime("gamer3",5);

        String expected = "gamer1";
        String actual = store.getMostPlayer();

        Assertions.assertEquals(expected, actual);

    }
    @Test
    public void getMostPlayerForOneHour() {

        store.addPlayTime("gamer1", 1);
        store.addPlayTime("gamer2", 1);
        store.addPlayTime("gamer3",1);

        String expected = "gamer1";
        String actual = store.getMostPlayer();

        Assertions.assertEquals(expected, actual);

    }
    @Test
    public void getMostPlayerNoGamesPlayed() {

        String expected = null;
        String actual = store.getMostPlayer();

        Assertions.assertEquals(expected, actual);

    }
    @Test
    public void getSumOfPlayedTime() {

        store.addPlayTime("gamer1", 10 );
        store.addPlayTime("gamer2", 6);
        store.addPlayTime("gamer3",6);

        int expected = 22;
        int actual = store.getSumPlayedTime();

        Assertions.assertEquals(expected, actual);

    }
    @Test
    public void getSumOfPlayedTimeNoGamesPlayed() {

        int expected = 0;
        int actual = store.getSumPlayedTime();

        Assertions.assertEquals(expected, actual);

    }
}
