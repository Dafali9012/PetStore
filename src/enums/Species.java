package enums;

public enum Species {
    FOX("Fox"),
    GOAT("Goat"),
    HEDGEHOG("Hedgehog"),
    SQUIRREL("Squirrel"),
    TURTLE("Turtle");

    private final String name;

    Species(String name) {
        this.name = name;
    }

    @Override
    public String toString() {
        return name;
    }
}
