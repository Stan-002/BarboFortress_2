package family_of_members.model.family_member;

import java.time.LocalDate;
import java.util.List;

import family_of_members.model.family.FamilyItem;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;

/**
 * Класс FamilyMember представляет члена семьи с такими свойствами, как
 * идентификатор, имя и возраст,
 * реализуя интерфейсы Comparable и FamilyItem.
 */

@Getter
@NoArgsConstructor
@AllArgsConstructor
public class FamilyMember implements Comparable<FamilyMember>, FamilyItem {
    private int id;
    private String kind;
    private Gender gender;
    private String name;
    private LocalDate birthDate;
    private LocalDate deathDate;
    private String father;
    private String mother;
    private List<Child> children;
    private List<Pet> pets;

    @Override
    public String toString() {
        return "FamilyMember [id=" + id + ", Вид:" + kind + ", Пол:" + gender + ", Имя:" + name + ", День рождения:"
                + birthDate + ", День смерти:" + deathDate + ", Отец:" + father + ", Мать:" + mother + ", Дети:"
                + children + ", Питомцы:" + pets + "]";
    }

    //TODO сделать compareTo в соотвествии с полями

    @Override
    public int compareTo(FamilyMember o) {
        int result = this.kind.compareTo(o.getKind());
        if (result != 0) {
            return result;
        }
    
        result = this.gender.compareTo(o.getGender());
        if (result != 0) {
            return result;
        }
    
        result = this.name.compareTo(o.getName());
        if (result != 0) {
            return result;
        }
    
        result = this.father.compareTo(o.getFather());
        if (result != 0) {
            return result;
        }
    
        result = this.mother.compareTo(o.getMother());
        if (result != 0) {
            return result;
        }
    
        result = this.birthDate.compareTo(o.getBirthDate());
        if (result != 0) {
            return result;
        }

        result = this.deathDate.compareTo(o.getDeathDate());
        if (result != 0) {
            return result;
        }

        result = this.id - o.getId();
        if (result != 0) {
            return result;
        }
        return 0;
    }
}