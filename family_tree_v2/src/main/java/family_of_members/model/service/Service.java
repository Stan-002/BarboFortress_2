package family_of_members.model.service;

import java.time.LocalDate;
import java.util.List;

import family_of_members.model.family.FamilyTree;
import family_of_members.model.family_member.FamilyMember;
import family_of_members.model.family_member.Gender;
import family_of_members.model.family_member.MembersOfFamily;

/**
 * Класс Service управляет генеалогическим деревом объектов FamilyMember,
 * позволяя добавлять членов
 * семьи, получать информацию о членах семьи и сортировать их по имени или
 * возрасту.
 */
public class Service {
    private int idFamilyMember;
    private FamilyTree<FamilyMember> family;

    public Service() {
        family = new FamilyTree<>();
    }

    public void addFamilyMember(
            String kind,
            Gender gender,
            String name,
            LocalDate birthDate,
            LocalDate deathDate,
            String father,
            String mother,
            List<MembersOfFamily> children,
            List<MembersOfFamily> pets) {

        FamilyMember familyMember = new FamilyMember(
                kind,
                idFamilyMember++,
                gender,
                name,
                birthDate,
                deathDate,
                father,
                mother,
                children,
                pets);

        family.addFamilyMember(familyMember);
    }

    public String getMembersOfFamilyInfo() {
        StringBuilder stringBuilder = new StringBuilder();
        stringBuilder.append("Список членов семьи:\n");

        // Iterator<FamilyMember> iterator = family.iterator();
        // while (iterator.hasNext()){
        // FamilyMember familyMember = iterator.next();
        // stringBuilder.append(familyMember);
        // stringBuilder.append("\n");
        // }
        for (FamilyMember familyMember : family) {
            stringBuilder.append(familyMember);
            stringBuilder.append("\n");
        }
        return stringBuilder.toString();
    }

    public void sortByKind() {
        family.sortByKind();
    }

    public void sortByGender() {
        family.sortByGender();
    }

    public void sortByName() {
        family.sortByName();
    }

    public void sortByBirthDate() {
        family.sortByBirthDate();
    }

    public void sortByDeathDate() {
        family.sortByDeathDate();
    }

    public void sortByFather() {
        family.sortByFather();
    }

    public void sortByMother() {
        family.sortByMother();
    }

    public void sortByChildren() {
        family.sortByChildren();
    }

    public void sortByPets() {
        family.sortByPets();
    }

}
