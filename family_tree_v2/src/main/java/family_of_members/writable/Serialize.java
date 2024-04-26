package family_of_members.writable;

import java.io.FileOutputStream;
import java.io.IOException;
import java.io.ObjectOutputStream;

public class Serialize implements Serializable {

    public void serialize() {
    try {
                ObjectOutputStream app = new ObjectOutputStream(new FileOutputStream("MembersOfFamily.txt"));
                
                System.out.println("Объект успешно сериализован и записан в файл.");
            } catch (IOException e) {
                System.out.println("Ошибка при сериализации объекта: " + e.getMessage());
            }
            System.out.println("Объект успешно сериализован и записан в файл.");
        }
}
