package family_of_members;

import family_of_members.view.ConsoleUI;
import family_of_members.view.View;

/**
 * Класс «App» содержит основной метод, который печатает «Hello World!» на
 * консоль.
 */
public class App {
    public static void main(String[] args) {
        View view = new ConsoleUI();
        view.start();
    }
}
