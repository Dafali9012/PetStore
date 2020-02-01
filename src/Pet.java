import enums.Species;

import java.security.SecureRandom;

public class Pet {
    private SecureRandom sr = new SecureRandom();
    private  String name;
    private  String species = Species.values()[sr.nextInt(Species.values().length)].toString();

    public Pet(String name) {
        this.name = name;
    }

    public String getSpecies() {
        return species;
    }

    public String getName() {
        return name;
    }
}
