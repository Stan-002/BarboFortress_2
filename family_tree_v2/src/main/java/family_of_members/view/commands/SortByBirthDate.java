package family_of_members.view.commands;

import family_of_members.view.ConsoleUI;

public class SortByBirthDate extends Command {
    public SortByBirthDate(ConsoleUI consoleUI) {
        super(consoleUI);
        description = "Sort the list by date of birth";
    }

    public void execute() {
        consoleUI.sortByBirthDate();
    }
}
