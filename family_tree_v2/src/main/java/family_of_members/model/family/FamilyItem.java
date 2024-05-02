package family_of_members.model.family;

// Этот фрагмент кода определяет интерфейс Java с именем FamilyItem. Этот интерфейс объявляет два
// абстрактных метода: getName(), который возвращает строку, представляющую имя члена семьи, и
// getAge(), который возвращает целое число, представляющее возраст члена семьи. Любой класс,
// реализующий этот интерфейс, должен будет предоставить конкретные реализации этих двух методов. Этот
// интерфейс можно использовать для реализации общей структуры классов, представляющих членов семейства
// в приложении, связанном с семейством.

import java.time.LocalDate;
import java.util.List;

import family_of_members.model.family_member.Child;
import family_of_members.model.family_member.Gender;
import family_of_members.model.family_member.Pet;

public interface FamilyItem{
    
    String getKind();

    Gender getGender();

    String getName();

    LocalDate getBirthDate();

    LocalDate getDeathDate();

    String getFather();

    String getMother();

    List<Child> getChildren();

    List<Pet> getPets();

}