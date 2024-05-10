package View;

/*
 *View (Вид): Вид отображает данные, 
 которые предоставляет модель, 
 и получает ввод от пользователя. 
 Он не должен знать ничего о модели или контроллере, 
 и не должен взаимодействовать с ними напрямую.
 * */

//фамилия, имя, отчество - строки
//
//дата_рождения - строка формата dd.mm.yyyy
//
//номер_телефона - целое беззнаковое число без форматирования
//
//пол - символ латиницей f или m.

//Приложение должно проверить введенные данные по количеству.
// Если количество не совпадает с требуемым,
// вернуть код ошибки, обработать его и показать пользователю сообщение,
// что он ввел меньше и больше данных, чем требуется.

import Controller.PersonController;

import java.util.Scanner;

public class PersonMenu {
    private PersonController personController;

    public PersonMenu(PersonController personController) {
        this.personController = personController;
    }

    public void printPerson(String text) {
        System.out.println(text);
    }

    public void start() {
        Scanner scanner = new Scanner(System.in);
        int choice;
        do {
            System.out.println("1. Добавить человека");
            System.out.println("2. Выход");
            System.out.print("Выберите действие: ");
            choice = scanner.nextInt();
            scanner.nextLine();
            switch (choice) {
                case 1:
                    System.out.println(
                            "Введите данные человека: <Фамилия> <Имя> <Отчество> <dd.MM.yyyy> <номер телефона> <пол - символ латиницей f или m>");
                    PersonController.addPerson(scanner);
                    break;
                case 2:
                    System.out.println("Выход");
                    break;
                default:
                    System.out.println("Неверная команда попробуйте ещё раз");
            }
        } while (choice != 2);
        scanner.close();
    }
}