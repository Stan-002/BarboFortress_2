package family_of_members.view.commands;

import family_of_members.view.ConsoleUI;

/**
 * Класс Finish расширяет Command и предоставляет метод завершения работы в пользовательском интерфейсе
 * консоли.
 */
public class Finish extends Command {
    public Finish(ConsoleUI consoleUI) {
        super(consoleUI);
        description = "Finish work";
    }

    public void execute(){
        consoleUI.finish();
    }
}
