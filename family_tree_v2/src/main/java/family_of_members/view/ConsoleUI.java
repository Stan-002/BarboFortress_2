package family_of_members.view;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.time.LocalDate;
import java.time.format.DateTimeParseException;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

import family_of_members.model.family_member.Children;
import family_of_members.model.family_member.Gender;
import family_of_members.model.family_member.Pets;
import family_of_members.presenter.Presenter;

/**
 * Класс ConsoleUI в Java представляет собой консольный пользовательский
 * интерфейс с методами
 * сортировки, отображения информации о членах семейства и добавления членов
 * семейства.
 */
public class ConsoleUI implements View {

    private static final String INPUT_ERROR = "Вы ввели неверное значение";
    private Scanner scanner;
    private Presenter presenter;
    private boolean work;
    private MainMenu menu;

    private void serialize(String filePath, String data) {
        try (FileWriter writer = new FileWriter(filePath, true)) {
            writer.write(data + "\n");
        } catch (IOException e) {
            e.printStackTrace(); // или логгирование
        }
    }

    public static void deserialize(String filePath) {
        try (BufferedReader bufferedReader = new BufferedReader(new FileReader(filePath))) {
            String line;
            while ((line = bufferedReader.readLine()) != null) {
                System.out.println(line); // Делайте что-то с прочитанными данными, например, передавайте их в Presenter
            }
        } catch (IOException e) {
            e.printStackTrace(); // Обработка исключений
        }
    }

    public ConsoleUI() {
        scanner = new Scanner(System.in);
        presenter = new Presenter(this);
        work = true;
        menu = new MainMenu(this);
    }

    @Override
    public void printAnswer(String text) {
        System.out.println(text);
    }

    @Override
    public void start() {
        hello();
        while (work) {
            printMenu();
            execute();
        }
    }

    public void finish() {
        System.out.println("It was nice to chat");
        work = false;
    }

    public void sortByKind() {
        presenter.sortByKind();
    }

    public void sortByGender() {
        presenter.sortByGender();
    }

    public void sortByName() {
        presenter.sortByName();
    }

    public void sortByBirthDate() {
        presenter.sortByBirthDate();
    }

    public void sortByDeathDate() {
        presenter.sortByDeathDate();
    }

    public void sortByFather() {
        presenter.sortByFather();
    }

    public void sortByMother() {
        presenter.sortByMother();
    }

    public void sortByChildren() {
        presenter.sortByChildren();
    }

    public void sortByPets() {
        presenter.sortByPets();
    }

    public void getFamilyMemberInfo() {
        presenter.getFamilyMemberListInfo();
    }

    public void addFamilyMember() {
        System.out.println("Enter the kind of family member");
        String kind = scanner.nextLine();
        if (kind == null) {
            throw new IllegalArgumentException("The sight of a family member cannot be null");
        }

        System.out.println("Specify gender of the family member");
        String genderString = scanner.nextLine();
        if (genderString == null) {
            throw new IllegalArgumentException("The gender of the family member cannot be null");
        }
        Gender gender;
        try {
            gender = Gender.valueOf(genderString.toUpperCase());
        } catch (IllegalArgumentException e) {
            throw new IllegalArgumentException("Wrong gender of a family member");
        }

        System.out.println("Enter the name of a family member");
        String name = scanner.nextLine();
        if (name == null) {
            throw new IllegalArgumentException("Family member's name cannot be null");
        }

        System.out.println("Enter the date of birth of the family member in the format YYYY-MM-DD:");
        LocalDate birthDate = null;
        boolean validInput1 = false;
        while (!validInput1) {
            String birthDateString = scanner.nextLine();
            if (birthDateString == null) {
                throw new IllegalArgumentException("The input string cannot be null");
            }
            try {
                birthDate = LocalDate.parse(birthDateString);
                validInput1 = true;
            } catch (DateTimeParseException e) {
                System.out.println("Invalid date format. Enter the date in YYYY-MM-DD format:");
            }
        }

        System.out
                .println(
                        "Enter the date of death of the family member in YYYY-MM-DD format (or enter 'Alive' if the family member is alive):");
        LocalDate deathDate = null;
        String deathDateString = scanner.nextLine();
        if (deathDateString == null) {
            throw new IllegalArgumentException("The input string cannot be null");
        }
        if (!deathDateString.equalsIgnoreCase("Alive")) {
            boolean validInput2 = true;
            while (!validInput2) {
                try {
                    deathDate = LocalDate.parse(deathDateString);
                    validInput2 = true;
                } catch (DateTimeParseException e) {
                    System.out.println("Invalid date format. Enter date in YYYY-MM-DD format (or enter 'Alive'):");
                    deathDateString = scanner.nextLine();
                    if (deathDateString == null) {
                        throw new IllegalArgumentException("The input string cannot be null");
                    }
                    if (deathDateString.equalsIgnoreCase("Alive")) {
                        // FIXME Если пользователь ввел "Жив", то прекратить проверку формата даты
                        deathDate = null;
                        validInput2 = false;
                    }
                }
            }
        }

        System.out.println("Indicate the father of a family member");
        String father = scanner.nextLine();
        if (father == null) {
            throw new IllegalArgumentException("The father of a family member cannot be null");
        }

        System.out.println("Indicate the mother of a family member");
        String mother = scanner.nextLine();
        if (mother == null) {
            throw new IllegalArgumentException("Family member's mother cannot be null");
        }

        System.out.println("Enter the children of a family member (Input example: name1, name2, name3)");
        String childrenString = scanner.nextLine();
        if (childrenString == null) {
            throw new IllegalArgumentException("The family member's children row cannot be null");
        }
        List<Children> children = new ArrayList<>();
        for (String child : childrenString.split(",")) {
            // Проверка на пустую строку
            if (child.trim().isEmpty()) {
                continue;
            }
            children.add(new Children(child.trim()));
        }

        System.out.println("Enter your family member's pets (Input example: name1, name2, name3)");
        String petsString = scanner.nextLine();
        if (petsString == null) {
            throw new IllegalArgumentException("The family member's pet row cannot be null");
        }
        List<Pets> pets = new ArrayList<>();
        for (String pet : petsString.split(",")) {
            // Проверка на пустую строку
            if (pet.trim().isEmpty()) {
                continue;
            }
            pets.add(new Pets(pet.trim()));
        }

        serialize("MembersOfFamily.txt",
                "Kind:" + kind + ", " +
                        "Gender:" + gender + ", " +
                        "Name:" + name + ", " +
                        "Birth date:" + birthDate + ", " +
                        "Death date:" + deathDate + ", " +
                        "Father:" + father + ", " +
                        "Mother:" + mother + ", " +
                        "Children:" + childrenString + ", " +
                        "Pets:" + petsString + "\n");
        presenter.addFamilyMember(
                kind,
                gender,
                name,
                birthDate,
                deathDate,
                father,
                mother,
                children,
                pets);
    }

    public void readLineFamilyOfMembers() {
        printMenu();
        deserialize("MembersOfFamily.txt");
        execute();
    }

    private void hello() {
        System.out.println("Greetings!");
    }

    private void execute() {
        String line = scanner.nextLine();
        if (checkTextForInt(line)) {
            int numCommand = Integer.parseInt(line);
            if (checkCommand(numCommand)) {
                menu.execute(numCommand);
            }
        }
    }

    private boolean checkTextForInt(String text) {
        if (text.matches("[0-9]+")) {
            return true;
        } else {
            inputError();
            return false;
        }
    }

    private boolean checkCommand(int numCommand) {
        if (numCommand < menu.getSize()) {
            return true;
        } else {
            inputError();
            return false;
        }
    }

    private void printMenu() {
        System.out.println(menu.menu());
    }

    private void inputError() {
        System.out.println(INPUT_ERROR);
    }

}
