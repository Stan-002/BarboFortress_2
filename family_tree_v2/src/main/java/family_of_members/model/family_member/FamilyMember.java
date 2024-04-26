package family_of_members.model.family_member;

import java.time.LocalDate;
import java.util.Iterator;
import java.util.List;

import family_of_members.model.family.FamilyItem;

/**
 * Класс FamilyMember представляет члена семьи с такими свойствами, как
 * идентификатор, имя и возраст,
 * реализуя интерфейсы Comparable и FamilyItem.
 */
public class FamilyMember implements Comparable<FamilyMember>, FamilyItem, Iterable<MembersOfFamily> {
    private String kind;
    private int id;
    private Gender gender;
    private String name;
    private LocalDate birthDate;
    private LocalDate deathDate;
    private String father;
    private String mother;
    private List<MembersOfFamily> children;
    private List<MembersOfFamily> pets;

    public FamilyMember(String kind, int id, Gender gender, String name, LocalDate birthDate, LocalDate deathDate,
            String father, String mother, List<MembersOfFamily> children, List<MembersOfFamily> pets) {
        this.kind = kind;
        this.id = id;
        this.gender = gender;
        this.name = name;
        this.birthDate = birthDate;
        this.deathDate = deathDate;
        this.father = father;
        this.mother = mother;
        this.children = children;
        this.pets = pets;
    }

    @Override
    public String toString() {
        return "FamilyMember [kind=" + kind + ", id=" + id + ", gender=" + gender + ", name=" + name + ", birthDate="
                + birthDate + ", deathDate=" + deathDate + ", father=" + father + ", mother=" + mother + ", children="
                + children + ", pets=" + pets + ", getClass()=" + getClass() + ", hashCode()=" + hashCode()
                + ", iterator()=" + iterator() + ", toString()=" + super.toString() + "]";
    }

    public String getKind() {
        return kind;
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

    public List<MembersOfFamily> getChildren() {
        return children;
    }

    public List<MembersOfFamily> getPets() {
        return pets;
    }

    @Override
    public int compareTo(FamilyMember o) {
        int result = 0;
        try {
            if (o == null) {
                throw new NullPointerException("Cannot compare to null FamilyMember");
            }
            result = this.kind.compareTo(o.kind);
            if (result == 0) {
                result = this.gender.compareTo(o.gender);
                if (result == 0) {
                    result = this.name.compareTo(o.name);
                    if (result == 0) {
                        result = this.father == null ? (o.father == null ? 0 : -1) : this.father.compareTo(o.father);
                        if (result == 0) {
                            result = this.mother == null ? (o.mother == null ? 0 : -1) : this.mother.compareTo(o.mother);
                            if (result == 0) {
                                // Compare children if they exist
                                if (this.children != null && o.children != null) {
                                    result = Integer.compare(this.children.size(), o.children.size());
                                    if (result == 0) {
                                        // Use iterator instead of indexed loop to avoid IndexOutOfBoundsException
                                        Iterator<MembersOfFamily> thisIter = this.children.iterator();
                                        Iterator<MembersOfFamily> oIter = o.children.iterator();
                                        while (thisIter.hasNext() && oIter.hasNext()) {
                                            result = thisIter.next().compareTo(oIter.next());
                                            if (result != 0) {
                                                break;
                                            }
                                        }
                                    }
                                } else if (this.children != null) {
                                    result = 1; // this has children, o does not
                                } else if (o.children != null) {
                                    result = -1; // o has children, this does not
                                }

                                // Compare pets if children comparison was inconclusive
                                if (result == 0 && this.pets != null && o.pets != null) {
                                    result = Integer.compare(this.pets.size(), o.pets.size());
                                    if (result == 0) {
                                        // Use iterator instead of indexed loop to avoid IndexOutOfBoundsException
                                        Iterator<MembersOfFamily> thisIter = this.pets.iterator();
                                        Iterator<MembersOfFamily> oIter = o.pets.iterator();
                                        while (thisIter.hasNext() && oIter.hasNext()) {
                                            result = thisIter.next().compareTo(oIter.next());
                                            if (result != 0) {
                                                break;
                                            }
                                        }
                                    }
                                } else if (result == 0 && (this.pets != null || o.pets != null)) {
                                    result = (this.pets != null) ? 1 : -1; // this has pets, o does not
                                }
                            }
                        }
                    }
                }
            }
        } catch (NullPointerException e) {
            e.printStackTrace();
        }
        return result;
    }

    @Override
    public Iterator<MembersOfFamily> iterator() {
        // TODO Итерация для children и pets
        if (this.children != null) {
            return this.children.iterator();
        }
        if (this.pets != null) {
            return this.pets.iterator();
        }
        return iterator();
    }
}