public class PetStore {
    private static final PetStore instance = new PetStore();
    private static int animalStock = 100;

    public PetStore() {

    }

    public Pet sellPet() {
        animalStock--;
        return new Pet(NameGenerator.expendPetName());
    }

    public static PetStore getInstance() {
        return instance;
    }
}
