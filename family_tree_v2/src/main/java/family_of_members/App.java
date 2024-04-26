package family_of_members;

// Эти операторы импорта в коде Java импортируют классы, связанные с операциями ввода и вывода. Вот
// краткое объяснение каждого из них:
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;

import family_of_members.view.ConsoleUI;
import family_of_members.view.View;
import family_of_members.writable.Serializable;

/**
 * Класс «App» содержит основной метод, который печатает «Hello World!» на
 * консоль.
 */
public class App implements Serializable {
    public static void main(String[] args) {
        View view = new ConsoleUI();
        view.start();
        App app = new App();
        app.serialize();
        App deserializedApp = deserialize();
        if (deserializedApp != null) {
            App.deserialize();
        }
    }
    
    // public void serialize() {
    //     try {
    //         ObjectOutputStream app = new ObjectOutputStream(new FileOutputStream("MembersOfFamily.txt"));
            
    //         System.out.println("Объект успешно сериализован и записан в файл.");
    //     } catch (IOException e) {
    //         System.out.println("Ошибка при сериализации объекта: " + e.getMessage());
    //     }
    // }
    
    // public static App deserialize() {
    //     try (ObjectInputStream ois = new ObjectInputStream(new FileInputStream("MembersOfFamily.txt"))) {
    //         return (App) ois.readObject();
    //     } catch (IOException | ClassNotFoundException e) {
    //         System.out.println("Ошибка при десериализации объекта: " + e.getMessage());
    //         return null;
    //     }
    // }
    
}
