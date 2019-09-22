package clinic.model;

import java.util.ArrayList;

public class Disease {
    String ZJM;
    String name;
    String icdCode;
    String classification;

    public String getZJM() {
        return ZJM;
    }

    public void setZJM(String ZJM) {
        this.ZJM = ZJM;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getIcdCode() {
        return icdCode;
    }

    public void setIcdCode(String icdCode) {
        this.icdCode = icdCode;
    }

    public String getClassification() {
        return classification;
    }

    public void setClassification(String classification) {
        this.classification = classification;
    }

    public Disease(String ZJM, String name, String icdCode, String classification) {
        this.ZJM = ZJM;
        this.name = name;
        this.icdCode = icdCode;
        this.classification = classification;
    }

    public static ArrayList<Disease> getDiseases() {
        return diseases;
    }

    public static void addDisease(Disease disease) {
        diseases.add(disease);
    }

    private static ArrayList<Disease> diseases = new ArrayList<>();
}
