package family_of_members.view.commands;

import family_of_members.view.ConsoleUI;

/**
 * Абстрактный класс Command представляет команду с описанием и методом выполнения, предназначенную для
 * расширения для конкретных реализаций команды.
 */
public abstract class Command {
    String description;
    ConsoleUI consoleUI;

    public Command(ConsoleUI consoleUI) {
        this.consoleUI = consoleUI;
    }

    public String getDescription() {
        return description;
    }

    public abstract void execute();
}
