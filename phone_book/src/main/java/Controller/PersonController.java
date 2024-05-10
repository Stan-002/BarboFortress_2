package Controller;

import java.io.BufferedWriter;
import java.io.FileWriter;
import java.io.IOException;
import java.time.DateTimeException;
import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.util.Scanner;

import Model.Person;

public class PersonController {

    public static void addPerson(Scanner scanner) {

        String input = scanner.nextLine();

        String[] fields = input.split(" ");
        if (fields.length != 6) {
            System.err.println("Неверное количество полей, вы ввели " + fields.length + " введите 6 полей!");
        }

        String lastName = fields[0];
        String firstName = fields[1];
        String middleName = fields[2];
        LocalDate birthDate;
        Long phoneNumber;
        String gender;
        try {
            DateTimeFormatter formatter = DateTimeFormatter.ofPattern("dd.MM.yyyy");
            birthDate = LocalDate.parse(fields[3], formatter);
        } catch (DateTimeException e) {
            System.out.println("Неверный формат даты!");
            return;
        }

        try {
            phoneNumber = Long.parseLong(fields[4]);
        } catch (NumberFormatException e) {
            System.err.println("Неверный формат телефона");
            return;
        }

        gender = fields[5];
        if ((!"m".equals(gender)) && (!"f".equals(gender))) {
            System.err.println("Неверный формат пола, введите f или m!");
        }

        String fileName = lastName + ".txt";
        try (BufferedWriter writer = new BufferedWriter(new FileWriter(fileName, true))) {
            writer.write(lastName + " " + firstName + " " + middleName + " "
                    + birthDate.format(DateTimeFormatter.ISO_LOCAL_DATE) + " " + phoneNumber + " " + gender);
            writer.newLine();
        } catch (IOException e) {
            System.out.println("Ошибка записи!");
        }
    }
}
