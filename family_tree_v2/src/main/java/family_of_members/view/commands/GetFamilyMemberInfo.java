package family_of_members.view.commands;

import family_of_members.view.ConsoleUI;

/**
 * Этот класс Java расширяет команду и получает информацию о членах семьи из пользовательского
 * интерфейса консоли.
 */
public class GetFamilyMemberInfo extends Command {
    public GetFamilyMemberInfo(ConsoleUI consoleUI) {
        super(consoleUI);
        description = "Get a list of family members";
    }

    public void execute(){
        consoleUI.getFamilyMemberInfo();
    }
}
