import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;

public class PetNameGenerator {

    List<String> namesData;

    public PetNameGenerator() {
        loadNames();
        System.out.println(namesData.get(0));
    }

    private void loadNames() {
        try {
            namesData = Files.lines(Paths.get("PetNames.txt"))
            .collect(Collectors.toList());
            namesData = List.of(namesData.get(0).split(" "));
        } catch (IOException e) { e.printStackTrace(); }
    }

    public void generate() {

    }
}
