package family_of_members.model.family_member.comparators;

import java.util.Comparator;

import family_of_members.model.family.FamilyItem;

public class FamilyMemberComparatorByGender<T extends FamilyItem> implements Comparator<T> {

    @Override
    public int compare(T o1, T o2) {
        return o1.getGender().compareTo(o2.getGender());
    }
}
