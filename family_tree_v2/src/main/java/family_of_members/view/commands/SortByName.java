package family_of_members.view.commands;

import family_of_members.view.ConsoleUI;

/**
 * Класс SortByName расширяет Command и предоставляет команду для сортировки списка по имени в
 * пользовательском интерфейсе консоли.
 */
public class SortByName extends Command {
    public SortByName(ConsoleUI consoleUI) {
        super(consoleUI);
        description = "Sort list by name";
    }

    public void execute(){
        consoleUI.sortByName();
    }
}
