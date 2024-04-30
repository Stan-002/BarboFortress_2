package family_of_members.view.commands;
import family_of_members.view.ConsoleUI;
import family_of_members.view.commands.SortByMother;

public class SortByMother extends Command {
    public SortByMother(ConsoleUI consoleUI) {
        super(consoleUI);
        description = "Sort list of mothers";
    }

    public void execute(){
        consoleUI.sortByMother();
    }
}
