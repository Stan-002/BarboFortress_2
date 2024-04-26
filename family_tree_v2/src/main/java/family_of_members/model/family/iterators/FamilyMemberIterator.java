    package family_of_members.model.family.iterators;

import java.util.Iterator;
import java.util.List;

public class FamilyMemberIterator<E> implements Iterator<E> {
    private int index;
    private List<E> familyMemberList;

    public FamilyMemberIterator(List<E> familyMemberList) {
        this.familyMemberList = familyMemberList;
    }

    @Override
    public boolean hasNext() {
        return index < familyMemberList.size();
    }

    @Override
    public E next() {
        return familyMemberList.get(index++);
    }
}