package family_of_members.model.family_member;

public class Child {

    String child;

    @Override
    public String toString() {
        return "Дети: " + child;
    }

    public String getChild() {
        return child;
    }

    public void setChild(String child) {
        this.child = child;
    }

    public Child(String child) {
        this.child = child;
    }
}
