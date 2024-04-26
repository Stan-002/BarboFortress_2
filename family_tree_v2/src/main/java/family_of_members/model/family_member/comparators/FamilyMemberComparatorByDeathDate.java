package family_of_members.model.family_member.comparators;

import java.util.Comparator;

import family_of_members.model.family.FamilyItem;

public class FamilyMemberComparatorByDeathDate <T extends FamilyItem> implements Comparator<T> {

    public int compare(T o1, T o2) {
        return o1.getDeathDate().compareTo(o2.getDeathDate());
    }
}
