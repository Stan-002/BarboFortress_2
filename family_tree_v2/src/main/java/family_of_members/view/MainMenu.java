package family_of_members.view;

import java.util.ArrayList;
import java.util.List;

import family_of_members.view.commands.AddFamilyMember;
import family_of_members.view.commands.Command;
import family_of_members.view.commands.Finish;
import family_of_members.view.commands.GetMembersOfFamilyInfo;
import family_of_members.view.commands.SortByBirthDate;
import family_of_members.view.commands.SortByChildren;
import family_of_members.view.commands.SortByDeathDate;
import family_of_members.view.commands.SortByFamilyKind;
import family_of_members.view.commands.SortByFather;
import family_of_members.view.commands.SortByGender;
import family_of_members.view.commands.SortByMother;
import family_of_members.view.commands.SortByName;
import family_of_members.view.commands.SortByPets;

/**
 * Класс MainMenu представляет систему меню, содержащую список команд и
 * позволяющую выполнять команды
 * по выбору пользователя.
 */
public class MainMenu {
    private List<Command> commandList;

    public MainMenu(ConsoleUI consoleUI) {
        commandList = new ArrayList<>();
        commandList.add(new AddFamilyMember(consoleUI));
        commandList.add(new GetMembersOfFamilyInfo(consoleUI));
        commandList.add(new SortByFamilyKind(consoleUI));
        commandList.add(new SortByGender(consoleUI));
        commandList.add(new SortByName(consoleUI));
        commandList.add(new SortByBirthDate(consoleUI));
        commandList.add(new SortByDeathDate(consoleUI));
        commandList.add(new SortByFather(consoleUI));
        commandList.add(new SortByMother(consoleUI));
        commandList.add(new SortByChildren(consoleUI));
        commandList.add(new SortByPets(consoleUI)); 
        commandList.add(new Finish(consoleUI));
    }

    public String menu() {
        StringBuilder stringBuilder = new StringBuilder();
        for (int i = 0; i < commandList.size(); i++) {
            stringBuilder.append(i + 1);
            stringBuilder.append(". ");
            stringBuilder.append(commandList.get(i).getDescription());
            stringBuilder.append("\n");
        }
        return stringBuilder.toString();
    }

    public void execute(int choice) {
        Command command = commandList.get(choice - 1);
        command.execute();
    }

    public int getSize() {
        return commandList.size();
    }
}
