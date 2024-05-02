package family_of_members.model.family;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.Comparator;
import java.util.Iterator;
import java.util.List;

import family_of_members.model.family.iterators.FamilyMemberIterator;

/**
 * Класс FamilyTree в Java представляет коллекцию членов семьи и предоставляет
 * методы для добавления
 * членов, перебора их и сортировки по имени или возрасту.
 */
public class FamilyTree<E extends FamilyItem> implements Iterable<E> {
    private Comparator<LocalDate> nullSafeLocalDateCOmparator = (o1, o2) -> o1 != null && o2 != null ? o1.compareTo(o2) : 0;
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
        familyMemberList.sort(Comparator.comparing(FamilyItem::getKind));
    }

    public void sortByGender() {
        familyMemberList.sort(Comparator.comparing(FamilyItem::getGender));
    }

    public void sortByName() {
        familyMemberList.sort(Comparator.comparing(FamilyItem::getName));
    }

    public void sortByBirthDate() {
        familyMemberList.sort(Comparator.comparing(FamilyItem::getBirthDate));
    }

    public void sortByDeathDate() {
        familyMemberList.sort(Comparator.comparing(FamilyItem::getDeathDate, nullSafeLocalDateCOmparator));
    }

    public List<E> getFamilyMembers() {
        return familyMemberList;
    }
}
