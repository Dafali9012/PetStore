import java.security.SecureRandom;
import java.security.cert.CollectionCertStoreParameters;
import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.Stream;

import static java.util.stream.Collectors.groupingBy;

public class Person {
    private SecureRandom sr = new SecureRandom();
    private String name;
    private int age = sr.nextInt(56) + 5;
    ;
    private List<Pet> pets = new ArrayList<>();

    public Person(String name) {
        this.name = name;
    }

    public void acquirePet(Pet pet) {
        pets.add(pet);
    }

    public String getName() {
        return name;
    }

    public List<Pet> getPets() {
        return pets;
    }

    @Override
    public String toString() {
        if (pets.size() == 0) {
            return String.format("%s (%d) has no animals.", name, age);
        } else if (pets.size() == 1) {
            return String.format("%s (%d) owns the %s: %s", name, age, pets.get(0).getSpecies(), pets.get(0).getName());
        } else {
            return String.format("%s (%d) owns the animals: [%s]", name, age,
            pets.stream()
            .collect(groupingBy(Pet::getSpecies)).entrySet().stream()
            .map(o -> (o.getKey()=="Fox")?"Foxes: ":o.getKey()+"s: "+o.getValue().stream().map(Pet::getName).collect(Collectors.joining(", ")))
            .collect(Collectors.joining(" | ")));
        }
    }
}
