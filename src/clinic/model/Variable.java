package clinic.model;

public class Variable {
    public static String getClassification() {
        return classification;
    }

    public static void setClassification(String classification) {
        Variable.classification = classification;
    }

    public static String getName() {
        return name;
    }

    public static void setName(String name) {
        Variable.name = name;
    }

    private static String classification;
    private static String name;
}
