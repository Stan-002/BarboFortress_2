package family_of_members.view.commands;

import family_of_members.view.ConsoleUI;

public class SortByChildren extends Command {

    public SortByChildren(ConsoleUI consoleUI) {
        super(consoleUI);
        description = "Sort list of children";
    }

    public void execute() {
        consoleUI.sortByChildren();
    }
}
