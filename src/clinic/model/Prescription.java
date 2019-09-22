package clinic.model;

import java.io.Serializable;
import java.util.Date;

import javafx.beans.property.*;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;

public class Prescription implements Serializable {
    private final StringProperty name;
    private final StringProperty 药品1;
    private final StringProperty 药品2;
    private final StringProperty 药品3;
    private final StringProperty 药品4;
    private final StringProperty 药品5;


    private static ObservableList<Prescription> PrescriptionData = FXCollections.observableArrayList();

    public static void addPre(Prescription prescription){
        PrescriptionData.add(prescription);
    }

    public static ObservableList<Prescription> getPrescriptionData(){
        return PrescriptionData;
    }

/*
    public Appointment(StringProperty 处方) {
        this(null, null, null);
    }
*/

    public Prescription(String name, String 药品1, String 药品2, String 药品3, String 药品4, String 药品5) {
        this.name = new SimpleStringProperty(name);
        this.药品1 = new SimpleStringProperty(药品1);
        this.药品2 = new SimpleStringProperty(药品2);
        this.药品3 = new SimpleStringProperty(药品3);
        this.药品4 = new SimpleStringProperty(药品4);
        this.药品5 = new SimpleStringProperty(药品5);
    }


    public String getName() {
        return name.get();
    }

    public void setName(String Name) {
        this.name.set(Name);
    }

    public StringProperty NameProperty() {
        return name;
    }




    public String get药品1() {
        return 药品1.get();
    }

    public void set药品1(String 药品1) {
        this.药品1.set(药品1);
    }

    public StringProperty 药品1Property() {
        return 药品1;
    }




    public String get药品2() {
        return 药品2.get();
    }

    public void set药品2(String 药品2) {
        this.药品2.set(药品2);
    }

    public StringProperty 药品2Property() {
        return 药品2;
    }




    public String get药品3() {
        return 药品3.get();
    }

    public void set药品3(String 药品3) {
        this.药品3.set(药品3);
    }

    public StringProperty 药品3Property() {
        return 药品3;
    }




    public String get药品4() {
        return 药品4.get();
    }

    public void set药品4(String 药品4) {
        this.药品4.set(药品4);
    }

    public StringProperty 药品4Property() {
        return 药品4;
    }




    public String get药品5() {
        return 药品5.get();
    }

    public void set药品5(String 药品5) {
        this.药品5.set(药品5);
    }

    public StringProperty 药品5Property() {
        return 药品5;
    }

    /**
     * hardcode some data
     */


}