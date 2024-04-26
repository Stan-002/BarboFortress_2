package family_of_members.view;

import java.time.LocalDate;
import java.time.format.DateTimeParseException;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

import family_of_members.model.family_member.Gender;
import family_of_members.model.family_member.MembersOfFamily;
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

    public void getMembersOfFamilyListInfo() {
        presenter.getMembersOfFamilyListInfo();
    }

    public void addFamilyMember() {
        System.out.println("Введите вид члена семьи");
        String kind = scanner.nextLine();
        if (kind == null) {
            throw new IllegalArgumentException("Вид члена семьи не может быть null");
        }

        System.out.println("Укажите пол члена семьи");
        String genderString = scanner.nextLine();
        if (genderString == null) {
            throw new IllegalArgumentException("Пол члена семьи не может быть null");
        }
        Gender gender;
        try {
            gender = Gender.valueOf(genderString.toUpperCase());
        } catch (IllegalArgumentException e) {
            throw new IllegalArgumentException("Неверный пол члена семьи");
        }

        System.out.println("Укажите имя члена семьи");
        String name = scanner.nextLine();
        if (name == null) {
            throw new IllegalArgumentException("Имя члена семьи не может быть null");
        }

        System.out.println("Укажите дату рождения члена семьи в формате ГГГГ-ММ-ДД:");
        LocalDate birthDate = null;
        boolean validInput1 = false;
        while (!validInput1) {
            String birthDateString = scanner.nextLine();
            if (birthDateString == null) {
                throw new IllegalArgumentException("Входная строка не может быть null");
            }
            try {
                birthDate = LocalDate.parse(birthDateString);
                validInput1 = true;
            } catch (DateTimeParseException e) {
                System.out.println("Неверный формат даты. Введите дату в формате ГГГГ-ММ-ДД:");
            }
        }

        System.out
                .println(
                        "Укажите дату смерти члена семьи в формате ГГГГ-ММ-ДД (или введите 'Жив', если член семьи жив):");
        LocalDate deathDate = null;
        String deathDateString = scanner.nextLine();
        if (deathDateString == null) {
            throw new IllegalArgumentException("Входная строка не может быть null");
        }
        if (!deathDateString.equalsIgnoreCase("Жив")) {
            boolean validInput2 = true;
            while (!validInput2) {
                try {
                    deathDate = LocalDate.parse(deathDateString);
                    validInput2 = true;
                } catch (DateTimeParseException e) {
                    System.out.println("Неверный формат даты. Введите дату в формате ГГГГ-ММ-ДД (или введите 'Жив'):");
                    deathDateString = scanner.nextLine();
                    if (deathDateString == null) {
                        throw new IllegalArgumentException("Входная строка не может быть null");
                    }
                    if (deathDateString.equalsIgnoreCase("Жив")) {
                        // FIXME Если пользователь ввел "Жив", то прекратить проверку формата даты
                        deathDate = null;
                        validInput2 = false;
                    }
                }
            }
        }

        System.out.println("Укажите отца члена семьи");
        String father = scanner.nextLine();
        if (father == null) {
            throw new IllegalArgumentException("Отец члена семьи не может быть null");
        }

        System.out.println("Укажите мать члена семьи");
        String mother = scanner.nextLine();
        if (mother == null) {
            throw new IllegalArgumentException("Мать члена семьи не может быть null");
        }

        System.out.println("Укажите детей члена семьи (Пример ввода: имя1, имя2, имя3)");
        String childrenString = scanner.nextLine();
        if (childrenString == null) {
            throw new IllegalArgumentException("Строка детей члена семьи не может быть null");
        }
        List<MembersOfFamily> children = new ArrayList<>();
        for (String child : childrenString.split(",")) {
            // Проверка на пустую строку
            if (child.trim().isEmpty()) {
                continue;
            }
            children.add(new MembersOfFamily(child.trim()));
        }

        System.out.println("Укажите питомцев члена семьи (Пример ввода: имя1, имя2, имя3)");
        String petsString = scanner.nextLine();
        if (petsString == null) {
            throw new IllegalArgumentException("Строка питомцев члена семьи не может быть null");
        }
        List<MembersOfFamily> pets = new ArrayList<>();
        for (String pet : petsString.split(",")) {
            // Проверка на пустую строку
            if (pet.trim().isEmpty()) {
                continue;
            }
            pets.add(new MembersOfFamily(pet.trim()));
        }
        // сделать проверку ввода возраста
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
