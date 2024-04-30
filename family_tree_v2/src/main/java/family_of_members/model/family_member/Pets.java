package family_of_members.model.family_member;

public class Pets {
    
    String pet;

    @Override
    public String toString() {
        return "Pets:" + pet;
    }

    public String getPet() {
        return pet;
    }

    public void setPet(String pet) {
        this.pet = pet;
    }

    public Pets(String pet) {
        this.pet = pet;
    }
}
