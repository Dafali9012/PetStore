import java.util.ArrayList;
import java.util.List;

public class Program {
    private static final Program instance = new Program();
    List<Person> people = new ArrayList<>();

    public Program() {
        PetNameGenerator.loadNames();
        HumanNames.loadNames();

        HumanNames.getNames().stream().forEach(this::generatePerson);
        people.stream().forEach(s -> s.acquirePet(PetStore.getPet()));
        people.stream().forEach(s -> System.out.printf("%s (%d) owns the %s: %s\n", s.getName(), s.getAge(), s.getPets().stream().));
    }

    private void generatePerson(String name) {
        people.add(new Person(name));
    }

    public static Program getInstance() {
        return instance;
    }
}
