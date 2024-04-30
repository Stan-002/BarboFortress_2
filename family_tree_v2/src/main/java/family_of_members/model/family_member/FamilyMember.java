package family_of_members.model.family_member;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.Comparator;
import java.util.Iterator;
import java.util.List;

import family_of_members.model.family.FamilyItem;

/**
 * Класс FamilyMember представляет члена семьи с такими свойствами, как
 * идентификатор, имя и возраст,
 * реализуя интерфейсы Comparable и FamilyItem.
 */

public class FamilyMember implements Comparable<FamilyMember>, FamilyItem {
    private String kind;
    private int id;
    private Gender gender;
    private String name;
    private LocalDate birthDate;
    private LocalDate deathDate;
    private String father;
    private String mother;
    private List<Children> child = new ArrayList<>();
    private List<Pets> pet = new ArrayList<>();

    public FamilyMember(String kind, int id, Gender gender, String name, LocalDate birthDate, LocalDate deathDate,
            String father, String mother, List<Children> child, List<Pets> pet) {
        this.kind = kind;
        this.id = id;
        this.gender = gender;
        this.name = name;
        this.birthDate = birthDate;
        this.deathDate = deathDate;
        this.father = father;
        this.mother = mother;
        this.child = child;
        this.pet = pet;
    }

    @Override
    public String toString() {
        return "FamilyMember [kind=" + kind + ", id=" + id + ", gender=" + gender + ", name=" + name + ", birthDate="
                + birthDate + ", deathDate=" + deathDate + ", father=" + father + ", mother=" + mother + ", child="
                + child + ", pet=" + pet + "]";
    }

    public String getKind() {
        return kind;
    }

    public int getId() {
        return id;
    }

    public Gender getGender() {
        return gender;
    }

    public String getName() {
        return name;
    }

    public LocalDate getBirthDate() {
        return birthDate;
    }

    public LocalDate getDeathDate() {
        return deathDate;
    }

    public String getFather() {
        return father;
    }

    public String getMother() {
        return mother;
    }

    public List<Children> getChild() {
        return child;
    }

    public List<Pets> getPet() {
        return pet;
    }


    //TODO сделать compareTo в соотвествии с полями

    @Override
    public int compareTo(FamilyMember o) {
        // Compare by kind
        int result = this.kind.compareTo(o.getKind());
        if (result != 0) {
            return result;
        }
    
        // Compare by gender
        result = this.gender.compareTo(o.getGender());
        if (result != 0) {
            return result;
        }
    
        // Compare by name
        result = this.name.compareTo(o.getName());
        if (result != 0) {
            return result;
        }
    
        // Compare by father
        result = this.father.compareTo(o.getFather());
        if (result != 0) {
            return result;
        }
    
        // Compare by mother
        result = this.mother.compareTo(o.getMother());
        if (result != 0) {
            return result;
        }
    
        // Compare by birth date
        result = this.birthDate.compareTo(o.getBirthDate());
        if (result != 0) {
            return result;
        }

        // Compare by death date

        result = this.deathDate.compareTo(o.getDeathDate());
        if (result != 0) {
            return result;
        }

        // Compare by id
        result = this.id - o.getId();
        if (result != 0) {
            return result;
        }
        return 0;
    }
}