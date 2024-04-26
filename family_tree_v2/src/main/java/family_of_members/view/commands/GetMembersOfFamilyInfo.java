package family_of_members.view.commands;

import family_of_members.view.ConsoleUI;

/**
 * Этот класс Java расширяет команду и получает информацию о членах семьи из пользовательского
 * интерфейса консоли.
 */
public class GetMembersOfFamilyInfo extends Command {
    public GetMembersOfFamilyInfo(ConsoleUI consoleUI) {
        super(consoleUI);
        description = "Получить список членов семьи";
    }

    public void execute(){
        consoleUI.getMembersOfFamilyListInfo();
    }
}
