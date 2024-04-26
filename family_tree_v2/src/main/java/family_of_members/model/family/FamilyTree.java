package family_of_members.model.family;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

import family_of_members.model.family.iterators.FamilyMemberIterator;
import family_of_members.model.family_member.comparators.FamilyMemberComparatorByBirthDate;
import family_of_members.model.family_member.comparators.FamilyMemberComparatorByChildren;
import family_of_members.model.family_member.comparators.FamilyMemberComparatorByDeathDate;
import family_of_members.model.family_member.comparators.FamilyMemberComparatorByFather;
import family_of_members.model.family_member.comparators.FamilyMemberComparatorByGender;
import family_of_members.model.family_member.comparators.FamilyMemberComparatorByKind;
import family_of_members.model.family_member.comparators.FamilyMemberComparatorByMother;
import family_of_members.model.family_member.comparators.FamilyMemberComparatorByName;
import family_of_members.model.family_member.comparators.FamilyMemberComparatorByPets;

/**
 * Класс FamilyTree в Java представляет коллекцию членов семьи и предоставляет
 * методы для добавления
 * членов, перебора их и сортировки по имени или возрасту.
 */
public class FamilyTree<E extends FamilyItem> implements Iterable<E> {
    private List<E> familyMemberList;

    public FamilyTree() {
        familyMemberList = new ArrayList<>();
    }

    public void addFamilyMember(E familyMember) {

        familyMemberList.add(familyMember);
    }

    @Override
    public Iterator<E> iterator() {
        return new FamilyMemberIterator<>(familyMemberList);
    }

    public void sortByKind() {
        familyMemberList.sort(new FamilyMemberComparatorByKind<>());
    }

    public void sortByGender() {
        familyMemberList.sort(new FamilyMemberComparatorByGender<>());
    }

    public void sortByName() {
        familyMemberList.sort(new FamilyMemberComparatorByName<>());
    }

    public void sortByBirthDate() {
        familyMemberList.sort(new FamilyMemberComparatorByBirthDate<>());
    }

    public void sortByDeathDate() {
        familyMemberList.sort(new FamilyMemberComparatorByDeathDate<>());
    }
    
    public void sortByFather(){
        familyMemberList.sort(new FamilyMemberComparatorByFather<>());
    }

    public void sortByMother(){
        familyMemberList.sort(new FamilyMemberComparatorByMother<>());
    }

    public void sortByChildren(){
        familyMemberList.sort(new FamilyMemberComparatorByChildren<>());
    }

    public void sortByPets(){
        familyMemberList.sort(new FamilyMemberComparatorByPets<>());
    }

}
