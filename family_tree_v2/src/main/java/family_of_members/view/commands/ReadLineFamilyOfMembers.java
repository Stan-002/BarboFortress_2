package family_of_members.view.commands;

import family_of_members.view.ConsoleUI;

/**
 * Этот класс Java расширяет команду и считывает данные из файла с помощью consoleUI.
 */
public class ReadLineFamilyOfMembers extends Command {

    public ReadLineFamilyOfMembers(ConsoleUI consoleUI) {
        super(consoleUI);
        description = "Прочитать данные из файла";
    }

    public void execute() {
        consoleUI.readLineFamilyOfMembers();
    }
}
