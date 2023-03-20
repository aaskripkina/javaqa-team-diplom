package ru.netology;

import static org.junit.jupiter.api.Assertions.*;
import org.junit.jupiter.api.Test;

public class PlayerTest {

    @Test
    public void shouldSumGenreIfOneGame() {
        GameStore store = new GameStore();
        Game game = store.publishGame("Нетология Баттл Онлайн", "Аркады");

        Player player = new Player("Petya");
        player.installGame(game);
        player.play(game, 3);

        int expected = 3;
        int actual = player.sumGenre(game.getGenre());
        assertEquals(expected, actual);
    }
    @Test
    public void shouldCheckOnPlayWithoutInstall() {
        GameStore store = new GameStore();
        Game game = store.publishGame("TF2", "Аркады");

        Player player = new Player("Tima");
      assertThrows(RuntimeException.class, () -> player.play(game, 4));
    }
    @Test
    public void shouldCheckPlayToSumHoursSameGenreGames() {
        GameStore store = new GameStore();
        Game game = store.publishGame("Баттл", "Аркады");
        Game game2 = store.publishGame("TF2", "Аркады");

        Player player = new Player("Tima");
        player.installGame(game);
        player.installGame(game2);
        player.play(game,2);
        player.play(game2,7);

        int expected = 9;
        int actual = player.sumGenre("Аркады");
        assertEquals(expected, actual);
    }
    @Test
    public void mostPlayerByGenre() {
        GameStore store = new GameStore();
        Game game = store.publishGame("Нетология Баттл Баттл", "Аркады");
        Game game2 = store.publishGame("TF2", "Шутер");

        Player player = new Player("Tima");
        player.installGame(game);
        player.installGame(game2);
        player.play(game, 7);
        player.play(game2, 3);

        Game expected = game;
        Game actual = player.mostPlayerByGenre("Аркады");

        assertEquals(expected, actual);
    }
    @Test
    public void shouldInstallGame() {
        GameStore store = new GameStore();
        Game game = store.publishGame("Нетология Баттл Онлайн", "Аркады");

        Player player = new Player("Tima");
        player.installGame(game);
        player.play(game, 2);
        player.installGame(game);

        int expected = 2;
        int actual = player.sumGenre("Аркады");

        assertEquals(expected, actual);
    }

}
