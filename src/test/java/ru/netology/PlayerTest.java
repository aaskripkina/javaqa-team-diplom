
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
    public void mostPlayerByGenre() {
        GameStore store = new GameStore();
        Game game = store.publishGame("Нетология Баттл Онлайн", "Аркады");
        Game game2 = store.publishGame("TF2", "Шутер");

        Player player = new Player("Petya");
        player.installGame(game);
        player.installGame(game2);
        player.play(game, 7);
        player.play(game, 3);

        Game[] expected = {game};
        Game[] actual = player.mostPlayerByGenre("Аркады");
        assertArrayEquals(expected, actual);
    }
    @Test
    public void mostPlayerByGenreWithMinesTimeAndDifGenre() {
        GameStore store = new GameStore();
        Game game = store.publishGame("Нетология Баттл Онлайн", "Аркады");
        Game game2 = store.publishGame("TF2", "Шутер");

        Player player = new Player("Tima");
        player.installGame(game);
        player.play(game, -4);

        Game[] expected = player.mostPlayerByGenre("Экшн");
        String actual = null;

        assertEquals(expected, actual);
    }

}
