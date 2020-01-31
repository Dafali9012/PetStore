public class PetStore {
    private static final PetStore instance = new PetStore();
    private static int animalsLeft = 100;

    public static Pet getPet() {
        animalsLeft--;
        return new Pet();
    }

    public static PetStore getInstance() {
        return instance;
    }
}
