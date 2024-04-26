package family_of_members.writable;

import java.io.FileInputStream;
import java.io.ObjectInputStream;

import family_of_members.App;

public class Deserialize implements Serializable {

    public static App deserialize() {
        try (ObjectInputStream ois = new ObjectInputStream(new FileInputStream("MembersOfFamily.txt"))) {
            return (App) ois.readObject();
        } catch (IOException | ClassNotFoundException e) {
            System.out.println("Ошибка при десериализации объекта: " + e.getMessage());
            return null;
        }
        System.out.println("Объект успешно десериализован.");
    }
}
