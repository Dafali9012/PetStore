import enums.Sorting;

import java.security.SecureRandom;
import java.util.ArrayList;
import java.util.Comparator;
import java.util.List;

public class Program {
    private static final Program instance = new Program();
    private SecureRandom sr = new SecureRandom();
    private List<Person> people = new ArrayList<>();
    PetStore petStore = new PetStore();

    public Program() {
        generatePeople(20);
        printPeople(Sorting.NAME);
    }

    private void generatePeople(int amount) {

        while (amount > 0) {
            Person person = new Person(NameGenerator.expendPersonName());
            int petAmount = sr.nextInt(6);
            while (petAmount > 0) {
                person.acquirePet(petStore.sellPet());
                petAmount--;
            }
            people.add(person);
            amount--;
        }
    }

    private void printPeople(Sorting sortBy) {
        if (sortBy == Sorting.NAME) {
            people.stream()
                    .filter(p -> p.getPets().size() > 0)
                    .sorted(Comparator.comparing(Person::getName))
                    .forEach(p -> System.out.println(p.toString()));
        }
        if (sortBy == Sorting.NUM_ANIMALS) {
            people.stream()
                    .filter(p -> p.getPets().size() > 0)
                    .sorted(Comparator.comparingInt(p -> p.getPets().size()))
                    .forEach(p -> System.out.println(p.toString()));
        }
    }

    public static Program getInstance() {
        return instance;
    }
}
