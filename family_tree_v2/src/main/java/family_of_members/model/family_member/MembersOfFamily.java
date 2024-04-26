package family_of_members.model.family_member;

import java.util.ArrayList;
import java.util.List;

public class MembersOfFamily {
    private List<MembersOfFamily> children = new ArrayList<>();
    private List<MembersOfFamily> pets = new ArrayList<>();
    private String info;

    public String getInfo() {
        return info;
    }

    public void setInfo(String info) {
        this.info = info;
    }

    public MembersOfFamily(List<MembersOfFamily> children, List<MembersOfFamily> pets) {
        this.children = children;
        this.pets = pets;
    }
    
    public List<MembersOfFamily> getChildren() {
        return children;
    }
    
    public List<MembersOfFamily> getPets() {
        return pets;
    }

    public MembersOfFamily(String info) {
        // Просто сохраняем информацию о ребенке или питомце
        this.info = info;
    }
    

    public List<MembersOfFamily> getMembersOfFamilyList1(String childrenString) {
        List<MembersOfFamily> membersList = new ArrayList<>();        
        String[] childrenArray = childrenString.split(",");        
        for (String child : childrenArray) {
            String trimmedChild = child.trim();            
            membersList.add(new MembersOfFamily(trimmedChild));
        }
        return membersList;
    }
    
    public int compareTo(MembersOfFamily membersOfFamily) {
        // TODO Сравнивание pets и children
        int result = Integer.compare(children.size(), membersOfFamily.children.size());
        if (result == 0) {
            for (int i = 0; i < children.size(); i++) {
                result = children.get(i).compareTo(membersOfFamily.children.get(i));
                if (result != 0) {
                    break;
                }
            }
        }
        if (result == 0) {
            result = Integer.compare(pets.size(), membersOfFamily.pets.size());
        }
        if (result == 0) {
            for (int i = 0; i < pets.size(); i++) {
                result = pets.get(i).compareTo(membersOfFamily.pets.get(i));
                if (result != 0) {
                    break;
                }
            }
        }
        return result;
    }
}
