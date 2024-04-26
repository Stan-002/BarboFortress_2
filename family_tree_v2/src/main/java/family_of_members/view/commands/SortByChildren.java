package family_of_members.view.commands;

import family_of_members.view.ConsoleUI;

public class SortByChildren extends Command {

    public SortByChildren(ConsoleUI consoleUI) {
        super(consoleUI);
        description = "Отсортировать список детей";
    }

    public void execute() {
        consoleUI.sortByChildren();
    }
}
