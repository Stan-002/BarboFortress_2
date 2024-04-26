package family_of_members.view.commands;

import family_of_members.view.ConsoleUI;

public class SortByFather extends Command {
    public SortByFather(ConsoleUI consoleUI) {
        super(consoleUI);
        description = "Отсортировать список отцов";
    }

    public void execute(){
        consoleUI.sortByFather();
    }
}
