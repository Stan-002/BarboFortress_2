package family_of_members.view.commands;

import family_of_members.view.ConsoleUI;

public class SortByPets extends Command {

    public SortByPets(ConsoleUI consoleUI) {
        super(consoleUI);
        description = "Отсортировать список питомцей";
    }

    public void execute() {
        consoleUI.sortByPets();
    }
}
