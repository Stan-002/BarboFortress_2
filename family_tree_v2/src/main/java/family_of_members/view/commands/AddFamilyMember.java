package family_of_members.view.commands;

import family_of_members.view.ConsoleUI;

/**
 * Класс AddFamilyMember расширяет класс Command и предоставляет команду для добавления члена семьи
 * через пользовательский интерфейс консоли.
 */
public class AddFamilyMember extends Command{

    public AddFamilyMember(ConsoleUI consoleUI) {
        super(consoleUI);
        description = "Add a family member";
    }

    public void execute(){
        consoleUI.addFamilyMember();
    }
}
