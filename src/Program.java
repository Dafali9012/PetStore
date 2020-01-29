public class Program {
    private static final Program instance = new Program();
    private PetNameGenerator petNameGenerator = new PetNameGenerator();

    public Program() {

    }

    public static Program getInstance() {
        return instance;
    }
}
