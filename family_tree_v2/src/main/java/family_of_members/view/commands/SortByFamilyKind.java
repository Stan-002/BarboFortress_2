package family_of_members.view.commands;

import family_of_members.view.ConsoleUI;

public class SortByFamilyKind extends Command {

    public SortByFamilyKind(ConsoleUI consoleUI) {
        super(consoleUI);
        description = "Отсортировать список членов семьи";
    }

    public void execute() {
        consoleUI.sortByKind();
    }
}
