package family_of_members.model.family_member.comparators;

import java.util.Comparator;

import family_of_members.model.family.FamilyItem;

/**
 * Класс FamilyMemberComparatorByName — это компаратор Java, который сравнивает
 * объекты типа FamilyItem
 * на основе их имен.
 */
public class FamilyMemberComparatorByName<T extends FamilyItem> implements Comparator<T> {
    @Override
    public int compare(T o1, T o2) {
        return o1.getName().compareTo(o2.getName());
    }
}
