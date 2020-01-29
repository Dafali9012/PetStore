import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.List;
import java.util.stream.Collectors;

public class PetNameGenerator {

    List<String> namesData;

    public PetNameGenerator() {
        loadNames();
    }

    private void loadNames() {
        try {
            namesData = Files.lines(Paths.get("PetNames.txt"))
            .peek(s -> System.out.println(s))
            .collect(Collectors.toList());
        } catch (IOException e) { e.printStackTrace(); }
    }

    public void generate() {

    }
}
