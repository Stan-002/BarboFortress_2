package family_of_members.presenter;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;

import family_of_members.model.family_member.Children;
import family_of_members.model.family_member.Gender;
import family_of_members.model.family_member.Pets;
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
            List<Children> child,
            List<Pets> pet) {

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

        getFamilyMemberListInfo();
    }

    public void getFamilyMemberListInfo() {
        String info = service.getFamilyMemberInfo();
        view.printAnswer(info);
    }

    public void sortByKind() {
        service.sortByKind();
        getFamilyMemberListInfo();
    }

    public void sortByGender() {
        service.sortByGender();
        getFamilyMemberListInfo();
    }

    public void sortByName() {
        service.sortByName();
        getFamilyMemberListInfo();
    }

    public void sortByBirthDate() {
        service.sortByBirthDate();
        getFamilyMemberListInfo();
    }

    public void sortByDeathDate() {
        service.sortByDeathDate();
        getFamilyMemberListInfo();
    }

    public void sortByFather() {
        service.sortByFather();
        getFamilyMemberListInfo();
    }

    public void sortByMother() {
        service.sortByMother();
        getFamilyMemberListInfo();
    }

    public void sortByChildren() {
        service.sortByChildren();
        getFamilyMemberListInfo();
    }

    public void sortByPets() {
        service.sortByPets();
        getFamilyMemberListInfo();
    }
}


// FIXME Нельзя совместить список Взрослых и детей с животными! Нужно создать 3 списка