package family_of_members.view.commands;

import family_of_members.view.ConsoleUI;

public class SortByDeathDate extends Command {
    public SortByDeathDate(ConsoleUI consoleUI) {
        super(consoleUI);
        description = "Отсортировать список по дате смерти";
    }

    public void execute() {
        consoleUI.sortByDeathDate();
    }
}
