package family_of_members.view.commands;
import family_of_members.view.ConsoleUI;
import family_of_members.view.commands.SortByMother;

public class SortByMother extends Command {
    public SortByMother(ConsoleUI consoleUI) {
        super(consoleUI);
        description = "Отсортировать список матерей";
    }

    public void execute(){
        consoleUI.sortByMother();
    }
}
