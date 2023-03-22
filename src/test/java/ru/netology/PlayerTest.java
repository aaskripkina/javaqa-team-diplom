
package ru.netology;

import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

public class PlayerTest {
    GameStore store = new GameStore();
    Player player = new Player("Tima");

    Game game = store.publishGame("Нетология Баттл Онлайн", "Аркады");
    Game game2 = store.publishGame("TF2", "Шутер");


    @Test
    public void shouldSumGenreIfOneGame() {
        GameStore store = new GameStore();
        Game game = store.publishGame("Нетология Баттл Онлайн", "Аркады");

        Player player = new Player("Tima");
        player.installGame(game);
        player.play(game, 3);

        int expected = 3;
        int actual = player.sumGenre(game.getGenre());
        Assertions.assertEquals(expected, actual);
    }
    // другие ваши тесты
    @Test   // Проверка в игре без установки
    public void shouldCheckOnPlayWithoutInstall() {
        GameStore store = new GameStore();
        Game game = store.publishGame("TF2", "Шутер");

        Player player = new Player("Tima");

        assertThrows(RuntimeException.class, () -> player.play(game, 4));
    }

    @Test   // Проверка суммирования, если наиграно 0 часов
    public void shouldSumGenreIfPlayTimeZero() {
        GameStore store = new GameStore();
        Game game = store.publishGame("Нетология Баттл Онлайн", "Аркады");
        Game game2 = store.publishGame("TF2", "Шутер");

        Player player = new Player("Tima");
        player.installGame(game);
        player.installGame(game2);
        player.play(game, 0);
        player.play(game2, 0);
        int expected = 0;
        int actual = player.sumGenre(game.getGenre());
        assertEquals(expected, actual);
    }

    @Test   // Проверка суммирования часов, для одного жанра игр
    public void shouldCheckPlayToSumHoursSameGenreGames() {
        GameStore store = new GameStore();
        Game game = store.publishGame("Баттл", "Аркады");
        Game game2 = store.publishGame("TF2", "Аркады");

        Player player = new Player("Tima");
        player.installGame(game);
        player.installGame(game2);
        player.play(game, 2);
        player.play(game2, 7);

        int expected = 9;
        int actual = player.sumGenre("Аркады");
        assertEquals(expected, actual);
    }
    @Test   // Счетчик после после повторной установки игры
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

    @Test   // Жанр с большим кол-во сыгранного времени
    public void mostPlayerByGenre() {
        GameStore store = new GameStore();
        Game game = store.publishGame("Нетология Баттл Онлайн", "Аркады");
        Game game2 = store.publishGame("TF2", "Шутер");

        Player player = new Player("Petya");
        player.installGame(game);
        player.installGame(game2);
        player.play(game, 7);
        player.play(game2, 3);

        Game expected = game;
        Game actual = player.mostPlayerByGenre("Аркады");

        assertEquals(expected, actual);
    }

    @Test
    public void mostPlayerByGenreWithMinesTimeAndDifGenre() {
        GameStore store = new GameStore();
        Game game = store.publishGame("Нетология Баттл Онлайн", "Аркады");

        Player player = new Player ("Tima");
        player.installGame(game);

        int expected = 0;
        int actual = player.sumGenre(game2.getGenre());
        Assertions.assertEquals(expected, actual);
    }

}
