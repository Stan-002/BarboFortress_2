package family_of_members.view.commands;

import family_of_members.view.ConsoleUI;

public class SortByFamilyKind extends Command {

    public SortByFamilyKind(ConsoleUI consoleUI) {
        super(consoleUI);
        description = "Sort list of family members";
    }

    public void execute() {
        consoleUI.sortByKind();
    }
}
