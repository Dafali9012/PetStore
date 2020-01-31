import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.security.SecureRandom;
import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.Stream;

public abstract class HumanNames {

    private static List<String> humanNames;

    public static void loadNames() {
        try {
            humanNames = Files.lines(Paths.get("HumanNames.txt"))
                    .flatMap(s -> Stream.of(s.split("[0-9,\n]")))
                    .filter(s -> s.matches("[A-Z][a-z]*"))
                    .collect(Collectors.toList());
        } catch (IOException e) { e.printStackTrace(); }
    }

    public static List<String> getNames() {
        return humanNames;
    }
}
