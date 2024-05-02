package family_of_members;

import family_of_members.view.ConsoleUI;
import family_of_members.view.View;


/**
 * Класс App в Java создает объект ConsoleUI и запускает представление.
 */
public class App {
    public static void main(String[] args) {
        View view = new ConsoleUI();
        view.start();
    }
}
