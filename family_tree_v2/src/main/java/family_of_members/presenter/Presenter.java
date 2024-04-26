package family_of_members.presenter;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;

import family_of_members.model.family_member.Gender;
import family_of_members.model.family_member.MembersOfFamily;
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
            List<MembersOfFamily> children,
            List<MembersOfFamily> pets) {

        service.addFamilyMember(
                kind,
                gender,
                name,
                birthDate,
                deathDate,
                father,
                mother,
                children,
                pets);

        getMembersOfFamilyListInfo();
    }

    public void getMembersOfFamilyListInfo() {
        String info = service.getMembersOfFamilyInfo();
        view.printAnswer(info);
    }

    public void sortByKind() {
        service.sortByKind();
        getMembersOfFamilyListInfo();
    }

    public void sortByGender() {
        service.sortByGender();
        getMembersOfFamilyListInfo();
    }

    public void sortByName() {
        service.sortByName();
        getMembersOfFamilyListInfo();
    }

    public void sortByBirthDate() {
        service.sortByBirthDate();
        getMembersOfFamilyListInfo();
    }

    public void sortByDeathDate() {
        service.sortByDeathDate();
        getMembersOfFamilyListInfo();
    }

    public void sortByFather() {
        service.sortByFather();
        getMembersOfFamilyListInfo();
    }

    public void sortByMother() {
        service.sortByMother();
        getMembersOfFamilyListInfo();
    }

    public void sortByChildren() {
        service.sortByChildren();
        getMembersOfFamilyListInfo();
    }

    public void sortByPets() {
        service.sortByPets();
        getMembersOfFamilyListInfo();
    }

    public List<MembersOfFamily> getMembersOfFamilyList1(String childrenString) {
        List<MembersOfFamily> membersList = new ArrayList<>();
        return membersList;
    }

    public List<MembersOfFamily> getMembersOfFamilyList2(String petsString) {
        List<MembersOfFamily> membersList = new ArrayList<>();
        return membersList;
    }

}
