package family_of_members.model.family_member;

public class Children {

    String child;

    @Override
    public String toString() {
        return "Children:" + child;
    }

    public String getChild() {
        return child;
    }

    public void setChild(String child) {
        this.child = child;
    }

    public Children(String child) {
        this.child = child;
    }
}
