/*
Урок 6. Семинар: Продвинутая работа с исключениями в Java
        Напишите приложение, которое будет запрашивать у пользователя следующие данные в произвольном порядке, разделенные пробелом:
Фамилия Имя Отчество датарождения номертелефона пол
Форматы данных:
фамилия, имя, отчество - строки

дата_рождения - строка формата dd.mm.yyyy

номер_телефона - целое беззнаковое число без форматирования

пол - символ латиницей f или m.
*/

package Model;

import Controller.PersonController;

import java.time.LocalDate;

public class Person {
        private String lastName;
        private String firstName;
        private String middleName;
        private LocalDate birthDate;
        private Long phoneNumber;
        private String gender;

        public Person(String lastName, String firstName, String middleName, LocalDate birthDate, Long phoneNumber,
                        String gender) {
                this.lastName = lastName;
                this.firstName = firstName;
                this.middleName = middleName;
                this.birthDate = birthDate;
                this.phoneNumber = phoneNumber;
                this.gender = gender;
        }
}