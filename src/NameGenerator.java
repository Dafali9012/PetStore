import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.security.SecureRandom;
import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.Stream;

public abstract class NameGenerator {
    private static SecureRandom sr = new SecureRandom();
    private static List<String> personNames;
    private static List<String> petNames;
    static {
        try {
            personNames = Files.lines(Paths.get("names/people.txt"))
            .flatMap(o -> Stream.of(o.split("[,]")))
            .filter(s -> s.matches("[a-zA-Z]+"))
            .collect(Collectors.toList());
            petNames = Files.lines(Paths.get("names/pets.txt"))
            .flatMap(o -> Stream.of(o.split("[\" ]")))
            .filter(s -> s.matches("[a-zA-Z]+"))
            .collect(Collectors.toList());
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    public static List<String> getPersonNamesList() {
        return personNames;
    }

    public static List<String> getPetNamesList() {
        return petNames;
    }

    public static String expendPetName() {
        int index = sr.nextInt(petNames.size());
        String name = petNames.get(index);
        petNames.remove(index);
        return name;
    }

    public static String expendPersonName() {
        int index = sr.nextInt(personNames.size());
        String name = personNames.get(index);
        personNames.remove(index);
        return name;
    }
}
