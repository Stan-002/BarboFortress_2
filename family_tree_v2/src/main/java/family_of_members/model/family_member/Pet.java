package family_of_members.model.family_member;

public class Pet {
    
    String pet;

    @Override
    public String toString() {
        return "Питомцы: " + pet;
    }

    public String getPet() {
        return pet;
    }

    public void setPet(String pet) {
        this.pet = pet;
    }

    public Pet(String pet) {
        this.pet = pet;
    }
}
