package family_of_members.view;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.time.LocalDate;
import java.time.format.DateTimeParseException;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

import family_of_members.model.family_member.Child;
import family_of_members.model.family_member.Gender;
import family_of_members.model.family_member.Pet;
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
        System.out.println("Приятно было пообщаться");
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

    public void getFamilyMemberInfo() {
        presenter.refreshFamilyMemberListInfo();
    }

    public void addFamilyMember() {
        try {
            String kind = readFromConsoleNonEmptyValue("Введите вид члена семьи", "Вид члена семьи не может быть null");
            Gender gender = readFromConsoleGender();
            String name = readFromConsoleNonEmptyValue("Укажите имя члена семьи", "Имя члена семьи не может быть null");
            LocalDate birthDate = readFromConsoleBirthDate();
            LocalDate deathDate = readFromConsoleDeathDate();
            String father = readFromConsoleNonEmptyValue("Укажите отца члена семьи", "Отец члена семьи не может быть null");
            String mother = readFromConsoleNonEmptyValue("Укажите мать члена семьи", "Мать члена семьи не может быть null");
            List<Child> children = readChildrenFromConsole();
            List<Pet> pets = readFromConsolePets();
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
            presenter.refreshFamilyMemberListInfo();
        } catch (IllegalStateException ise) {
            System.out.println("Добавление члена семьи отменено");
        }
    }

    private String readFromConsoleNonEmptyValue(String msgForEnter, String errorMsgOnEmpty) {
        boolean valueIsEmpty = true;
        String value = "";
        while (valueIsEmpty) {
            System.out.println(msgForEnter);
            value = scanner.nextLine();
            if (value == null) {
                continue;
            }
            value = value.trim();
            if (value.equalsIgnoreCase("отмена")) {
                throw new IllegalStateException();
            }
            if (!value.isEmpty()) {
                valueIsEmpty = false;
            } else {
                System.out.println(errorMsgOnEmpty);
            }
        }
        return value;
    }

    private List<Pet> readFromConsolePets() {
        String petsString = readFromConsoleNonEmptyValue(
                "Укажите питомцев члена семьи (Пример ввода: имя1, имя2, имя3)",
                "Строка питомцев члена семьи не может быть null");
        List<Pet> pets = new ArrayList<>();
        for (String pet : petsString.split(",")) {
            // Проверка на пустую строку
            if (pet.trim().isEmpty()) {
                continue;
            }
            pets.add(new Pet(pet.trim()));
        }
        return pets;
    }

    private List<Child> readChildrenFromConsole() {
        List<Child> children = new ArrayList<>();
        String childrenString = readFromConsoleNonEmptyValue(
                "Укажите детей члена семьи (Пример ввода: имя1, имя2, имя3)",
                "Строка детей члена семьи не может быть null");
        for (String child : childrenString.split(",")) {
            // Проверка на пустую строку
            if (child.trim().isEmpty()) {
                continue;
            }
            children.add(new Child(child.trim()));
        }
        return children;
    }

    private LocalDate readFromConsoleDeathDate() {
        LocalDate deathDate = null;
        boolean isInvalidValue = true;
        while (isInvalidValue) {
            String deathDateString = readFromConsoleNonEmptyValue(
                    "Укажите дату смерти члена семьи в формате ГГГГ-ММ-ДД (или введите 'Жив(а)', если член семьи жив):",
                    "Входная строка не может быть null");
            if (deathDateString.equalsIgnoreCase("жив")
                    || deathDateString.equalsIgnoreCase("жива")) {
                return null;
            }

            try {
                deathDate = LocalDate.parse(deathDateString);
                isInvalidValue = false;
            } catch (DateTimeParseException ignored) {
//                System.out.println("Некорректный формат даты. Введите дату в формате ГГГГ-ММ-ДД");
//                deathDateString = scanner.nextLine();
//                if (deathDateString == null) {
//                    throw new IllegalArgumentException("Входная строка не может быть null");
//                }
//                if (deathDateString.equalsIgnoreCase("Жив")) {
//                    // FIXME Если пользователь ввел "Жив", то прекратить проверку формата даты
//                    deathDate = null;
//                    isInvalidValue = false;
//                }
            }
        }
        return deathDate;
    }

    private LocalDate readFromConsoleBirthDate() {
        LocalDate birthDate = null;
        boolean validInput1 = false;
        while (!validInput1) {
            String birthDateString = readFromConsoleNonEmptyValue(
                    "Укажите дату рождения члена семьи в формате ГГГГ-ММ-ДД:",
                    "Входная строка не может быть null");
            try {
                birthDate = LocalDate.parse(birthDateString);
                validInput1 = true;
            } catch (DateTimeParseException e) {
                System.out.println("Неверный формат даты. Введите дату в формате ГГГГ-ММ-ДД:");
            }
        }
        return birthDate;
    }

    private Gender readFromConsoleGender() {
        while (true) {
            System.out.println("Укажите пол члена семьи (любое значение из F/FEMALE/M/MALE)");
            String genderString = scanner.nextLine();
            String genderStringInUpperCase = genderString.toUpperCase();
            switch (genderStringInUpperCase) {
                case "F":
                case "Ж":
                case "FEMALE":
                    return Gender.FEMALE;
                case "M"://на латинице
                case "М"://на кириллице
                case "MALE":
                    return Gender.MALE;
                default:
                    System.out.println("Введено некорректное значение: " + genderString);
            }
        }
    }

    public void readLineFamilyOfMembers() {
        printMenu();
        deserialize("MembersOfFamily.txt");
        execute();
    }

    private void hello() {
        System.out.println("Приветствую!");
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
