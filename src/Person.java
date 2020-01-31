import java.security.SecureRandom;
import java.util.ArrayList;
import java.util.List;

public class Person {
    private List<Pet> pets = new ArrayList<>();
    private String name;
    private int age;

    public Person(String name) {
        this.name = name;
        SecureRandom sr = new SecureRandom();
        this.age = sr.nextInt(51)+10;
    }

    public void acquirePet(Pet pet) {
        this.pets.add(pet);
    }

    public String getName() {
        return name;
    }

    public int getAge() {
        return age;
    }

    public List<Pet> getPets() {
        return pets;
    }
}
