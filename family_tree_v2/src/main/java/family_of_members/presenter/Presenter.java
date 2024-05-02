package family_of_members.presenter;

import java.time.LocalDate;
import java.util.List;

import family_of_members.model.family_member.Child;
import family_of_members.model.family_member.Gender;
import family_of_members.model.family_member.Pet;
import family_of_members.model.service.Service;
import family_of_members.view.View;

/**
 * Класс Presenter управляет взаимодействием между классами View и Service в
 * системе управления членами
 * семейства.
 */
public class Presenter {
    private View view;
    private Service service;

    public Presenter(View view) {
        this.view = view;
        service = new Service();
    }

    public void addFamilyMember(
            String kind,
            Gender gender,
            String name,
            LocalDate birthDate,
            LocalDate deathDate,
            String father,
            String mother,
            List<Child> child,
            List<Pet> pet) {

        service.addFamilyMember(
                kind,
                gender,
                name,
                birthDate,
                deathDate,
                father,
                mother,
                child,
                pet);
    }

    public void refreshFamilyMemberListInfo() {
        String info = service.getFamilyMemberInfo();
        view.printAnswer(info);
    }

    public void sortByKind() {
        service.sortByKind();
        refreshFamilyMemberListInfo();
    }

    public void sortByGender() {
        service.sortByGender();
        refreshFamilyMemberListInfo();
    }

    public void sortByName() {
        service.sortByName();
        refreshFamilyMemberListInfo();
    }

    public void sortByBirthDate() {
        service.sortByBirthDate();
        refreshFamilyMemberListInfo();
    }

    public void sortByDeathDate() {
        service.sortByDeathDate();
        refreshFamilyMemberListInfo();
    }

}


// FIXME Нельзя совместить список Взрослых и детей с животными! Нужно создать 3 списка