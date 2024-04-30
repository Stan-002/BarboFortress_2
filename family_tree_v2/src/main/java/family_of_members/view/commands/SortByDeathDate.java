package family_of_members.view.commands;

import family_of_members.view.ConsoleUI;

public class SortByDeathDate extends Command {
    public SortByDeathDate(ConsoleUI consoleUI) {
        super(consoleUI);
        description = "Sort the list by date of death";
    }

    public void execute() {
        consoleUI.sortByDeathDate();
    }
}
