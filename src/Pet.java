import java.security.SecureRandom;

public class Pet {
    String[] species = {"Fox", "Goat", "Hedgehog", "Squirrel", "Turtle"};
    String thisSpecies;
    private String name;

    public Pet() {
        this.name = PetNameGenerator.getPetName();
        SecureRandom sr = new SecureRandom();
        thisSpecies = species[sr.nextInt(5)];
    }

    public String getName() {
        return name;
    }

    public String getSpecies() {
        return thisSpecies;
    }
}
