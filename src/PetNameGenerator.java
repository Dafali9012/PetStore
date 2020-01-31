import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.security.SecureRandom;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.Stream;

public abstract class PetNameGenerator {

    private static List<String> petNames;

    public static void loadNames() {
        try {
            petNames = Files.lines(Paths.get("PetNames.txt"))
            .flatMap(s -> Stream.of(s.split("[\", ]")))
            .filter(s -> s.matches("[A-Z][a-z]*"))
            .collect(Collectors.toList());
        } catch (IOException e) { e.printStackTrace(); }
    }

    public static String getPetName() {
        SecureRandom sr = new SecureRandom();
        int index = sr.nextInt(petNames.size());
        String name = petNames.get(index);
        petNames.remove(index);
        return name;
    }

    public static void printRemaining() {
        System.out.println(petNames);
    }
}
