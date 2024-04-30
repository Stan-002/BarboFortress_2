package family_of_members.view.commands;

import family_of_members.view.ConsoleUI;

public class SortByGender extends Command {
    public SortByGender(ConsoleUI consoleUI) {
        super(consoleUI);
        description = "Sort list of genders";
    }

    public void execute() {
        consoleUI.sortByGender();
    }
}
