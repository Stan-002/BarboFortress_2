package family_of_members.model.service;

import java.io.FileOutputStream;
import java.io.IOException;
import java.io.OutputStreamWriter;
import java.io.Writer;
import java.nio.charset.StandardCharsets;
import java.time.LocalDate;
import java.util.List;

import family_of_members.model.family.FamilyTree;
import family_of_members.model.family_member.Child;
import family_of_members.model.family_member.FamilyMember;
import family_of_members.model.family_member.Gender;
import family_of_members.model.family_member.Pet;

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

    public List<FamilyMember> getFamilyMembers() {
        return family.getFamilyMembers();
    }

    public void addFamilyMember(
            String kind,
            Gender gender,
            String name,
            LocalDate birthDate,
            LocalDate deathDate,
            String father,
            String mother,
            List<Child> children,
            List<Pet> pets) {

        FamilyMember familyMember = new FamilyMember(
                idFamilyMember++,
                kind,
                gender,
                name,
                birthDate,
                deathDate,
                father,
                mother,
                children,
                pets);

        family.addFamilyMember(familyMember);

        serialize("MembersOfFamily.txt",
                "Вид:" + kind + ", " +
                        "Пол:" + gender + ", " +
                        "Имя:" + name + ", " +
                        "День рождения:" + birthDate + ", " +
                        "День смерти:" + deathDate + ", " +
                        "отец:" + father + ", " +
                        "мать:" + mother + ", " +
                        "Дети:" + children + ", " +
                        "Питомцы:" + pets + "\n");
    }

    public String getFamilyMemberInfo() {
        StringBuilder stringBuilder = new StringBuilder();
        stringBuilder.append("Список членов семьи:\n");
        List<FamilyMember> familyMembers = family.getFamilyMembers();
        for (FamilyMember familyMember : familyMembers) {
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

    private void serialize(String filePath, String data) {
        try (Writer writer = new OutputStreamWriter(new FileOutputStream(filePath, true), StandardCharsets.UTF_8)) {
            writer.write(data + "\n");
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

}
